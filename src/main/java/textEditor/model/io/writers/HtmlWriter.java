package textEditor.model.io.writers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a tool for writing to a html file
 */
public class HtmlWriter implements FileWriter {
    String htmlFileStart = """
            <html lang="en">
            <head>
            <title>Sample Page</title>
            </head>
            <body>
            """;
    String htmlFileEnd = """
            </body>
            </html>
            """;
    /**
     * Writes the given html content to the given html file
     *
     * @param content the string of html content to be written
     * @param file the html file to write to
     * @throws IllegalArgumentException if the given file is not a html file
     * @throws RuntimeException if the given file could not be found or written to
     */
    @Override
    public void write(String content, File file) {
        // is not a html file
        if (!file.getName().endsWith(".html")) {
            throw new IllegalArgumentException("Cannot write html to a non-html file");
        }

        // is a html file
        String fullHtml = htmlFileStart + content + htmlFileEnd;
        Path p = file.toPath();
        byte[] data = fullHtml.getBytes();
        try {
            Files.write(p, data);
        } catch (Exception e) {
            throw new RuntimeException("The given file could not be found or written to");
        }
    }

}
