package textEditor.model.io;

import java.io.File;

/**
 * Represents a tool for writing to a file
 */
public interface FileWriter {

    /**
     * Writes the given content to the given html file
     *
     * @param content the string content to be written
     * @param file the file to write to
     * @throws IllegalArgumentException if the given file is not of the correct extension
     * @throws RuntimeException if the file could not be found or written to
     */
    void write(String content, File file);
}
