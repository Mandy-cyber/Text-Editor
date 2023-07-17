package textEditor.model.io.readers;

import java.util.Scanner;
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

    /**
     * Determines if the given file is valid (i.e. can be found/scanned and has the correct
     * file extension).
     *
     * @param file the file to be checked
     * @return the file's scanner if the file is valid
     * @throws IllegalArgumentException if the file name does not end in the correct extension
     * @throws RuntimeException if the file could not be found or read
     */
    Scanner isValidFile(File file);
}
