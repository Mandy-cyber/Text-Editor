package textEditor.model;

import textEditor.model.io.writers.HtmlWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user-made text file/page
 */
public class PageFile {
    private List<Content> pageContent;
    private File htmlFile;

    /**
     * Initializes a PageFile with the given content and html file
     *
     * @param pageContent the content of the page
     * @param htmlFile the file with the page's html
     */
    public PageFile(List<Content> pageContent, File htmlFile) {
        this.pageContent = pageContent;
        this.htmlFile = htmlFile;
    }

    /**
     * Initializes a blank PageFile
     */
    public PageFile() {
        this.pageContent = new ArrayList<>();
        // TODO: add method that will increment the file name if it already exists
        this.htmlFile = new File("src/main/resources/untitled.html");
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
     * Gets the html file associated with this page
     *
     * @return this page's html file
     */
    public File getHtmlFile() {
        return this.htmlFile;
    }

    /**
     * Sets the html file to be associated with this page if a valid file is provided
     * (i.e. ends with .html)
     *
     * @param file the page's new html file
     * @return if the file could be set
     */
    public boolean setHtmlFile(File file) {
        if (!file.getName().endsWith(".html")) {
            return false;
        }
        this.htmlFile = file;
        return true;
    }


    /**
     * Creates the html for this page including its css styling
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
     * Saves the html of this page
     */
    public void savePage() {
        new HtmlWriter().write(this.toHtml(), this.htmlFile);
    }

}
