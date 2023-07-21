package textEditor.model.io.readers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import textEditor.model.Content;
import textEditor.model.enums.ContentType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a tool for reading content from a html file
 */
public class HtmlReader implements FileReader {

    /**
     * Reads and returns the content found in the given html file
     *
     * @param file the html file being read from
     * @return the string of html found
     */
    @Override
    public String read(File file) {
        Scanner scanner = isValidFile(file);
        StringBuilder htmlString = new StringBuilder();

        while (scanner.hasNextLine()) {
            String html = scanner.nextLine() + "\n";
            htmlString.append(html);
        }

        return htmlString.toString();
    }

    /**
     * Determines if the given html file is valid (i.e. can be found/scanned and
     * has the correct file extension).
     *
     * @param file the file to be checked
     * @return the file's scanner if the file is valid
     * @throws IllegalArgumentException if the file name does not end in .html
     * @throws RuntimeException if the file could not be found or read
     */
    @Override
    public Scanner isValidFile(File file) {
        if (!file.getName().endsWith(".html")) {
            throw new IllegalArgumentException("File must end in '.html'");
        }

        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The given html file could not be found or read\n-------------------\n", e);
        }
    }

    /**
     * Parses the given string of html and represents it as PageFile content
     *
     * @param htmlString the string of html to parse
     * @return a list of the PageFile content found
     */
    public List<Content> htmlParser(String htmlString) {
        List<Content> contents = new ArrayList<>();
        // Get all html elements in the body
        Document doc = Jsoup.parse(htmlString);
        Elements elements = doc.body().select("*");
        elements.remove(0);

        for (Element element : elements) {
            // Construct PageContent
            String id = element.attr("id");
            ContentType type = ContentType.determineType(element.tagName());
            String value = element.text();

            Content content = id.equals("") ? new Content(type, value) : new Content(id, type, value);
            contents.add(content);
        }
        return contents;
    }
}









