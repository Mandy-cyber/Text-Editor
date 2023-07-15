package textEditor.model;

import textEditor.model.enums.ContentType;
import textEditor.model.enums.StyleType;

import java.util.*;
import java.util.Map.Entry;

/**
 * Represents content on a page
 */
public class Content {
    private final String alphaNumeric = "0123456789abcdefghijklmnopqrstuvxyz";
    private final int idSize = 6;
    private final Random idRandomizer = new Random(6);
    private final String id;
    private ContentType type;
    private String value;
    private Map<StyleType, String> styling;

    /**
     * Initializes Content with all information given
     *
     * @param id this content's unique identification
     * @param type the type of the content
     * @param value the value (i.e. text) of the content
     * @param styling the content's styling
     */
    public Content(String id, ContentType type, String value, Map<StyleType, String> styling) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.styling = styling;
    }

    /**
     * Initializes Content with all information given and a randomly generated id
     *
     * @param type the type of the content
     * @param value the value (i.e. text) of the content
     * @param styling the content's styling
     */
    public Content(ContentType type, String value, Map<StyleType, String> styling) {
        this.type = type;
        this.id = generateId();
        this.value = value;
        this.styling = styling;
    }

    /**
     * Initializes Content with all information given after finding the content's
     * associated styling.
     *
     * @param id this content's unique identification
     * @param type the type of the content
     * @param value the value (i.e. text) of the content
     * @param stylingPerId a map of content id's and their associated styling
     */
    public Content(String id, ContentType type, String value, HashMap<String, Map<StyleType, String>> stylingPerId) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.styling = findMatchingStyle(id, stylingPerId);
    }

    /**
     * Randomly generates an id for this content
     *
     * @return the random id
     */
    public String generateId() {
        String type = this.type
                .getHtmlTags()
                .get(0).replace("<", "")
                .replace(">", "");

        StringBuilder id = new StringBuilder();
        for (int i = 0; i < this.idSize; i++) {
            id.append(this.alphaNumeric.charAt(this.idRandomizer.nextInt(36)));
        }
        return type + id;
    }

    /**
     * Finds the matching styling for the given id
     *
     * @param id a content's unique identification
     * @param stylingPerId a map of content id's and their associated styling
     * @return the matching styling
     */
    public Map<StyleType, String> findMatchingStyle(String id, Map<String, Map<StyleType, String>> stylingPerId) {
        return stylingPerId.get(id);
    }

    /**
     * Gets the identification of this content
     *
     * @return the content's id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Gets the type of this Content
     *
     * @return the content type
     */
    public ContentType getType() {
        return this.type;
    }

    /**
     * Sets the type of this Content
     *
     * @param type the new type for this content
     */
    public void setType(ContentType type) {
        this.type = type;
    }

    /**
     * Gets the value of this Content
     *
     * @return the content's value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Sets the value of this Content
     *
     * @param value the new value for this content
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the style of this Content
     *
     * @return this content's style
     */
    public Map<StyleType, String> getStyling() {
        return this.styling;
    }

    /**
     * Sets the styling of this Content
     *
     * @param styling the new styling for this content
     */
    public void setStyling(Map<StyleType, String> styling) {
        this.styling = styling;
    }

    /**
     * Adds the given style to this content's existing styling
     *
     * @param style the new styling to be added
     * @param value the value of the style
     * @return if the new style could be added (i.e. was valid)
     */
    public boolean addStyle(StyleType style, String value) {
        if (isValidStyling(style, value)) {
            this.styling.put(style, value);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Determines whether, or not, the given styling is valid
     * TODO: determine what this means lol
     */
    private boolean isValidStyling(StyleType style, String value) {
        return false;
    }

    /**
     * Determines if this content shares the same type and styling as the given content
     *
     * @param otherContent the other content
     * @return if the contents are the same
     */
    @Override
    public boolean equals(Object otherContent) {
        if (otherContent == this) {
            return true;
        }
        if (!(otherContent instanceof Content other)) {
            return false;
        }
        return this.styling.equals(other.styling)
                && this.type.equals(other.type);
    }

    /**
     * Creates a string representation of this content enclosed in html tags
     *
     * @return the content as a string of html
     */
    public String toHtml() {
        List<String> htmlTags = type.getHtmlTags();
        String openingTag = htmlTags.get(0);
        if (htmlTags.size() > 1) {
            return openingTag + value + htmlTags.get(1) + "\n";
        }
        return openingTag + "\n";
    }

    /**
     * Creates a string representation of this content as css
     *
     * @return the content as a string block of css
     */
    public String toCss() {
        // opening
        StringBuilder cssBlock = new StringBuilder();
        String opening = "#" + this.id + " {\n";
        cssBlock.append(opening);

        // body
        // turning into list to be able to index styles
        List<Entry<StyleType, String>> styles = new ArrayList<>(this.styling.entrySet());
        for (int i = 0; i < styles.size(); i++) {
            Entry<StyleType, String> style = styles.get(i);
            String newLine = style.getKey().attr() + " " + style.getValue() + ";";
            cssBlock.append(newLine);
        }

        // closing
        String closing = "}";
        cssBlock.append(closing);
        return cssBlock.toString();
    }
}






