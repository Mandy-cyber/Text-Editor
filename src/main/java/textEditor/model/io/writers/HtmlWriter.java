package textEditor.model.io.writers;

import textEditor.model.io.writers.FileWriter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a tool for writing to a html file
 */
public class HtmlWriter implements FileWriter {
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
        Path p = file.toPath();
        byte[] data = content.getBytes();
        try {
            Files.write(p, data);
        } catch (Exception e) {
            throw new RuntimeException("The given file could not be found or written to");
        }
    }

}
