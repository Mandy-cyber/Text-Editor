package textEditor.model.io.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CssReader implements FileReader {

    /**
     * Reads and returns the content found in the given css file
     *
     * @param file the css file being read from
     * @return the string of css found
     * @throws RuntimeException if the given css file could not be found or scanned
     * @throws IllegalArgumentException if the given file is not a css file
     */
    @Override
    public String read(File file) {
        return null;
    }

    /**
     * Determines if the given css file is valid (i.e. can be found/scanned and
     * has the correct file extension).
     *
     * @param file the file to be checked
     * @return the file's scanner if the file is valid
     * @throws IllegalArgumentException if the file name does not end in .css
     * @throws RuntimeException if the css file could not be found or read
     */
    @Override
    public Scanner isValidFile(File file) {
        if (!file.getName().endsWith(".css")) {
            throw new IllegalArgumentException("File must end in '.css'");
        }

        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The given css file could not be found or read\n-------------------\n", e);
        }
    }
}
