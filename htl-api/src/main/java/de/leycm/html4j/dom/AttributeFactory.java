package de.leycm.html4j.dom;

import de.leycm.html4j.attr.*;
import de.leycm.html4j.util.ClassAttribute;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Factory class for parsing HTML attribute strings and converting them to Attribute instances.
 * Supports registration of custom attribute parsers and automatic fallback to GenericAttribute.
 *
 * <p>This class provides a flexible way to parse HTML attribute strings like
 * {@code src="image.jpg"} or {@code disabled} into typed Attribute instances.
 *
 * <h3>Usage Examples:</h3>
 * <pre>{@code
 * // Parse standard attributes
 * Attribute attr1 = AttributeFactory.parse("src=\"image.jpg\"");
 * Attribute attr2 = AttributeFactory.parse("disabled");
 * Attribute attr3 = AttributeFactory.parse("class=\"btn btn-primary\"");
 *
 * // Register custom attribute parser
 * AttributeFactory.register("data-custom", (name, value) ->
 *     new CustomDataAttribute(value));
 * }</pre>
 *
 * @author LeyCM
 * @version 1.0.0
 * @since 1.0.0
 */
public final class AttributeFactory {

    private static final Map<String, BiFunction<String, String, Attribute>> PARSERS = new HashMap<>();
    private static final Pattern ATTRIBUTE_PATTERN =
            Pattern.compile("^([a-zA-Z][a-zA-Z0-9_-]*)(?:=\"([^\"]*)\")?$");

    static {
        registerBuiltInParsers();
    }

    private AttributeFactory() {
        throw new UnsupportedOperationException("");
    }

    /**
     * Registers all built-in attribute parsers for standard HTML attributes.
     */
    private static void registerBuiltInParsers() {
        // Global attributes
        register("accesskey", AccesskeyAttribute::new);
        register("autocapitalize", AutocapitalizeAttribute::new);
        register("autofocus", (name, value) -> new AutofocusAttribute(Boolean.parseBoolean(value)));
        register("contenteditable", (name, value) -> new ContenteditableAttribute(Boolean.parseBoolean(value)));
        register("dir", DirAttribute::new);
        register("draggable", (name, value) -> new DraggableAttribute(Boolean.parseBoolean(value)));
        register("hidden", (name, value) -> new HiddenAttribute(Boolean.parseBoolean(value)));
        register("id", IdAttribute::new);
        register("lang", LangAttribute::new);
        register("spellcheck", (name, value) -> new SpellcheckAttribute(Boolean.parseBoolean(value)));
        register("tabindex", (name, value) -> {
            try {
                return new TabindexAttribute(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                return new GenericAttribute(name, value);
            }
        });

        // Form attributes
        register("accept", AcceptAttribute::new);
        register("autocomplete", AutocompleteAttribute::new);
        register("capture", CaptureAttribute::new);
        register("disabled", (name, value) -> new DisabledAttribute(Boolean.parseBoolean(value)));
        register("max", MaxAttribute::new);
        register("maxlength", (name, value) -> {
            try {
                return new MaxlengthAttribute(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                return new GenericAttribute(name, value);
            }
        });
        register("min", MinAttribute::new);
        register("minlength", (name, value) -> {
            try {
                return new MinlengthAttribute(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                return new GenericAttribute(name, value);
            }
        });
        register("multiple", (name, value) -> new MultipleAttribute(Boolean.parseBoolean(value)));
        register("pattern", PatternAttribute::new);
        register("placeholder", PlaceholderAttribute::new);
        register("readonly", (name, value) -> new ReadonlyAttribute(Boolean.parseBoolean(value)));
        register("size", (name, value) -> {
            try {
                return new SizeAttribute(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                return new GenericAttribute(name, value);
            }
        });
        register("step", StepAttribute::new);

        // Specific attributes
        register("alt", AltAttribute::new);
        register("class", (name, value) -> {
            ClassAttribute classAttr = new ClassAttribute();
            if (value != null && !value.trim().isEmpty()) {
                String[] classes = value.trim().split("\\s+");
                classAttr.addClass(classes);
            }
            return classAttr;
        });
        register("content", ContentAttribute::new);
        register("crossorigin", CrossoriginAttribute::new);
        register("for", ForAttribute::new);
        register("form", FormAttribute::new);
        register("href", (name, value) -> {
            try {
                return new HrefAttribute(value);
            } catch (URISyntaxException e) {
                return new GenericAttribute("href", value);
            }
        });
        register("rel", RelAttribute::new);
        register("src", (name, value) -> {
            try {
                return new SrcAttribute(new URI(value));
            } catch (URISyntaxException e) {
                return new GenericAttribute("src", value);
            }
        });

        // Data attributes pattern
        registerPattern("data-", (name, value) ->
                new DataAttribute(name.substring(5), value));
    }

    /**
     * Registers a parser for a specific attribute name.
     *
     * @param attributeName the name of the attribute (case-insensitive)
     * @param parser        the function that creates an Attribute instance
     */
    public static void register(@NonNull String attributeName,
                                @NonNull BiFunction<String, String, Attribute> parser) {
        PARSERS.put(attributeName.toLowerCase(), parser);
    }

    /**
     * Registers a parser for a specific attribute name with simplified function (value only).
     *
     * @param attributeName the name of the attribute (case-insensitive)
     * @param parser        function mapping only the value
     */
    public static void register(@NonNull String attributeName,
                                @NonNull Function<String, Attribute> parser) {
        PARSERS.put(attributeName.toLowerCase(), (name, value) -> parser.apply(value));
    }

    /**
     * Registers a parser for attributes matching a prefix pattern.
     *
     * @param prefix the attribute name prefix to match
     * @param parser the function that creates an Attribute instance
     */
    public static void registerPattern(@NonNull String prefix,
                                       @NonNull BiFunction<String, String, Attribute> parser) {
        PARSERS.put(prefix.toLowerCase(), parser);
    }

    /**
     * Parses an HTML attribute string and returns an Attribute instance.
     *
     * <p>Supported formats:
     * <ul>
     *   <li>With value: {@code name="value"}</li>
     *   <li>Boolean: {@code name}</li>
     * </ul>
     *
     * @param attributeString the HTML attribute string to parse
     * @return an Attribute instance (never {@code null})
     * @throws IllegalArgumentException if the format is invalid
     */
    public static @NonNull Attribute parse(@NonNull String attributeString) {
        String trimmed = attributeString.trim();

        if (trimmed.matches("^[a-zA-Z][a-zA-Z0-9_-]*$")) {
            String name = trimmed.toLowerCase();
            BiFunction<String, String, Attribute> parser = PARSERS.get(name);

            if (parser != null) {
                return parser.apply(name, null);
            } else if (name.startsWith("data-")) {
                BiFunction<String, String, Attribute> dataParser = PARSERS.get("data-");
                if (dataParser != null) {
                    return dataParser.apply(name, null);
                }
            }
            return new GenericAttribute(name, "");
        }

        var matcher = ATTRIBUTE_PATTERN.matcher(trimmed);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid attribute format: " + attributeString);
        }

        String name = matcher.group(1).toLowerCase();
        String value = matcher.group(2);
        String unescapedValue = value != null ? unescapeHtml(value) : null;

        BiFunction<String, String, Attribute> parser = PARSERS.get(name);
        if (parser != null) {
            return parser.apply(name, unescapedValue);
        }

        if (name.startsWith("data-")) {
            BiFunction<String, String, Attribute> dataParser = PARSERS.get("data-");
            if (dataParser != null)
                return dataParser.apply(name, unescapedValue);
        }

        assert unescapedValue != null;
        return new GenericAttribute(name, unescapedValue);
    }

    /**
     * Creates an Attribute instance from name and value.
     *
     * @param name  the attribute name
     * @param value the attribute value (maybe {@code null})
     * @return an Attribute instance (never {@code null})
     */
    public static @NonNull Attribute create(@NonNull String name, @Nullable String value) {
        String normalizedName = name.toLowerCase();
        BiFunction<String, String, Attribute> parser = PARSERS.get(normalizedName);

        if (parser != null)
            return parser.apply(normalizedName, value);

        if (normalizedName.startsWith("data-")) {
            BiFunction<String, String, Attribute> dataParser = PARSERS.get("data-");
            if (dataParser != null)
                return dataParser.apply(normalizedName, value);
        }

        assert value != null;
        return new GenericAttribute(normalizedName, value);
    }

    /**
     * Unescapes common HTML entities in attribute values.
     */
    private static @NonNull String unescapeHtml(@NonNull String text) {
        return text.replace("&quot;", "\"")
                .replace("&#39;", "'")
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }

    /**
     * Returns the registered parser for a specific attribute name.
     */
    public static @NonNull Optional<BiFunction<String, String, Attribute>> getParser(@NonNull String attributeName) {
        return Optional.ofNullable(PARSERS.get(attributeName.toLowerCase()));
    }

    /**
     * Checks if a parser is registered for the specified attribute name.
     */
    public static boolean hasParser(@NonNull String attributeName) {
        return PARSERS.containsKey(attributeName.toLowerCase());
    }

    /**
     * Unregisters a parser for the specified attribute name.
     */
    public static BiFunction<String, String, Attribute> unregister(@NonNull String attributeName) {
        return PARSERS.remove(attributeName.toLowerCase());
    }

    /**
     * Returns the number of registered parsers.
     */
    public static int getParserCount() {
        return PARSERS.size();
    }

    /**
     * Clears all registered parsers (including built-in ones).
     * Re-registers built-ins automatically.
     */
    public static void clearParsers() {
        PARSERS.clear();
        registerBuiltInParsers();
    }
}
