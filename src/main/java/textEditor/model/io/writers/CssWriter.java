package textEditor.model.io.writers;

import textEditor.model.io.writers.FileWriter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a tool for writing to a css file
 */
public class CssWriter implements FileWriter {
    /**
     * Writes the given css content to the given css file
     *
     * @param content the string of cs content to be written
     * @param file the cs file to write to
     * @throws IllegalArgumentException if the given file is not a css file
     * @throws RuntimeException if the given file could not be found or written to
     */
    @Override
    public void write(String content, File file) {
        // is not a css file
        if (!file.getName().endsWith(".css")) {
            throw new IllegalArgumentException("Cannot write css to a non-css file");
        }

        // is a css file
        Path p = file.toPath();
        byte[] data = content.getBytes();
        try {
            Files.write(p, data);
        } catch (Exception e) {
            throw new RuntimeException("The given file could not be found or written to");
        }
    }
}
