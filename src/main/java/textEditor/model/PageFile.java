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
     * Creates a string representation of this page file
     *
     * @return the string representation (including the html tags)
     */
    public String toString() {
        // TODO: implement this
        return "";
    }
}
