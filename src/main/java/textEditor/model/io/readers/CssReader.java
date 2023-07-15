package textEditor.model.io.readers;

import java.io.File;

public class CssReader implements FileReader {

    /**
     * Reads and returns the content found in the given css file
     *
     * @param file the css file being read from
     * @return the string of css found
     * @throws RuntimeException         if the given css file could not be found
     * @throws IllegalArgumentException if the given file is not a css file
     */
    @Override
    public String read(File file) {
        return null;
    }
}
