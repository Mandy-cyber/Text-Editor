package textEditor.model.io.readers;

import java.io.File;

/**
 * Represents a tool for reading content from a file
 */
public interface FileReader {

    /**
     * Reads and returns the content found in the given file
     *
     * @param file the file being read from
     * @return the string content found
     * @throws RuntimeException if the given file could not be found
     * @throws IllegalArgumentException if the given file has the wrong extension
     */
    String read(File file);
}
