package textEditor.model.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a type of HTML content that can be used in the text editor
 */
public enum ContentType {
    /**
     * Equivalent of html 'h1' tag
     */
    H1(new ArrayList<>(List.of("<h1>", "</h1>"))),

    /**
     * Equivalent of html 'h2' tag
     */
    H2(new ArrayList<>(List.of("<h2>", "</h2>"))),

    /**
     * Equivalent of html 'h3' tag
     */
    H3(new ArrayList<>(List.of("<h3>", "</h3>"))),

    /**
     * Equivalent of html 'h4' tag
     */
    H4(new ArrayList<>(List.of("<h4>", "</h4>"))),

    /**
     * Equivalent of html 'h5' tag
     */
    H5(new ArrayList<>(List.of("<h5>", "</h5>"))),

    /**
     * Equivalent of html 'h6' tag
     */
    H6(new ArrayList<>(List.of("<h6>", "</h6>"))),

    /**
     * Equivalent of html 'br' tag
     */
    BR(new ArrayList<>(List.of("<br>"))),

    /**
     * Equivalent of html 'p' tag
     */
    PARA(new ArrayList<>(List.of("<p>", "</p>"))),

    /**
     * Equivalent of html  'strong' tag
     */
    BOLD(new ArrayList<>(List.of("<strong>", "</strong>"))),

    /**
     * Equivalent of html  'em' tag
     */
    ITALIC(new ArrayList<>(List.of("<em>", "</em>"))),

    /**
     * Equivalent of html  'u' tag
     */
    UNDERLINE(new ArrayList<>(List.of("<u>", "</u>"))),

    /**
     * Equivalent of html 'link' tag
     */
    STYLE_LINK(new ArrayList<>(List.of("<link>")));

    private final ArrayList<String> htmlTags;

    /**
     * Initializes a ContentType defined by the given html tag(s)
     *
     * @param htmlTags the opening and closing (if exists) tags for the content type
     */
    ContentType(ArrayList<String> htmlTags) {
        this.htmlTags = htmlTags;
    }

    /**
     * Gets the html tags for this content type
     *
     * @return the content type's html tags
     */
    public ArrayList<String> getHtmlTags() {
        return htmlTags;
    }
}
