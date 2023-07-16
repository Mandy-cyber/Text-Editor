package textEditor.model;

import textEditor.model.io.writers.CssWriter;
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
    private File cssFile;

    /**
     * Initializes a PageFile with the given content and associated files
     *
     * @param pageContent the content of the page
     * @param htmlFile the file with the page's html
     * @param cssFile the file with the page's css
     */
    public PageFile(List<Content> pageContent, File htmlFile, File cssFile) {
        this.pageContent = pageContent;
        this.htmlFile = htmlFile;
        this.cssFile = cssFile;
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
     * Gets the css file associated with this page
     *
     * @return this page's css file
     */
    public File getCssFile() {
        return this.cssFile;
    }

    /**
     * Sets the css file to be associated with this page if a valid file is provided
     * (i.e. ends with .css)
     *
     * @param file the page's new html file
     * @return if the file could be set
     */
    public boolean setCssFile(File file) {
        if (!file.getName().endsWith(".css")) {
            return false;
        }
        this.cssFile = file;
        return true;
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

    /**
     * Saves the html and css of this page in their respective files
     */
    public void savePage() {
        new HtmlWriter().write(toHtml(), htmlFile);
        new CssWriter().write(toCss(), cssFile);
    }

}
