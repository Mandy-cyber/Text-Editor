package textEditor.model.enums;

/**
 * Represents a css style that an element can adopt
 */
public enum StyleType {
    /**
     * The size of a font
     */
    FONT_SIZE("font-size:"),

    /**
     * The color of a font
     */
    FONT_COLOR("color:"),

    /**
     * The family of a font
     */
    FONT_FAMILY("font-family:"),

    /**
     * The weight of the font (i.e. boldness)
     */
    FONT_WEIGHT("font-weight:"),

    /**
     * The style of the font (i.e. italic)
     */
    FONT_STYLE("font-style:"),

    /**
     * The font's decoration (i.e. underline)
     */
    TEXT_DECORATION("text-decoration:"),

    /**
     * The background color of an element
     */
    BG_COLOR("background-color:");

    private final String attr;

    /**
     * Initializes a StyleType with the given attr
     *
     * @param attr the attribute for the style element
     */
    StyleType(String attr) {
        this.attr = attr;
    }

    /**
     * Gets the attribute of this style type
     *
     * @return the style's attribute
     */
    public String attr() {
        return this.attr;
    }

    /**
     * Determines the style type from the given string
     *
     * @param cssStr a string of css
     * @return the StyleType of the css
     * @throws IllegalArgumentException if a style type could not be found for the given string
     */
    public static StyleType determineType(String cssStr) {
        return switch (cssStr) {
            case "font-size" -> StyleType.FONT_SIZE;
            case "color" -> StyleType.FONT_COLOR;
            case "font-family" -> StyleType.FONT_FAMILY;
            case "font-weight" -> StyleType.FONT_WEIGHT;
            case "font-style" -> StyleType.FONT_STYLE;
            case "text-decoration" -> StyleType.TEXT_DECORATION;
            case "background-color" -> StyleType.BG_COLOR;
            default -> throw new IllegalArgumentException("Invalid css string provided.");
        };
    }
}









