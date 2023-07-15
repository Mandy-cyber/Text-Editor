package textEditor.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user-made text file/page
 */
public class PageFile {
    private List<Content> pageContent;

    /**
     * Initializes a PageFile with the given content
     *
     * @param pageContent the content of the page
     */
    public PageFile(List<Content> pageContent) {
        this.pageContent = pageContent;
    }

    /**
     * Initializes a blank PageFile
     */
    public PageFile() {
        this.pageContent = new ArrayList<>();
    }

    /**
     * Gets the content of this page's file
     *
     * @return the page's content
     */
    public List<Content> getPageContent() {
        return this.pageContent;
    }

    /**
     * Sets the content of this page to be the given content
     *
     * @param pageContent the new content for the page
     */
    public void setPageContent(List<Content> pageContent) {
        this.pageContent = pageContent;
    }

    /**
     * Adds the given content to this page's content at the given position
     *
     * @param content the content to add to the page
     * @param position the position (i.e. index) to add the content at
     */
    public void addPageContent(Content content, int position) {
        this.pageContent.add(position, content);
    }

    /**
     * Creates the html for this page
     *
     * @return the string of html for this page
     */
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        for (Content content: pageContent) {
            html.append(content.toHtml());
        }
        return html.toString();
    }

    /**
     * Creates the css for this page
     *
     * @return the string of css for this page
     */
    public String toCss() {
        StringBuilder css = new StringBuilder();
        for (Content content: pageContent) {
            css.append(content.toCss());
        }
        return css.toString();
    }
}
