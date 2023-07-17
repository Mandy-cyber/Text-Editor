package textEditor.model.io.readers;

import textEditor.model.Content;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<Content> content = new ArrayList<>();
        Scanner scanner = new Scanner(htmlString);

        return content;
    }

    /**
     * Finds the 'id' of the html element from the given html string
     *
     * @param htmlString the string of html
     * @return the id of the element in the string
     */
    private String findElementId(String htmlString) {
        Pattern pattern = Pattern.compile("id=['\"](.*?)['\"]");
        Matcher matcher = pattern.matcher(htmlString);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    /**
     * Finds the paragraph text enclosed in the given html string
     *
     * @param htmlString the string of html
     * @return the paragraph text
     */
    private String findParagraphText(String htmlString) {
        Pattern pattern = Pattern.compile("=['\"](.*?)['\"]");
    }
}









