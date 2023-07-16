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
    FONT_WEIGHT("font-weight:bold;"),

    /**
     * The style of the font (i.e. italic)
     */
    FONT_STYLE("font-style:italic;"),

    /**
     * The font's decoration (i.e. underline)
     */
    TEXT_DECORATION("text-decoration:underline;"),

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
}
