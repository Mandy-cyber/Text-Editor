package textEditor.model.io.readers;

import textEditor.model.io.readers.FileReader;

import java.io.File;

/**
 * Represents a tool for reading content from a html file
 */
public class HtmlReader implements FileReader {
    // TODO consider using jsoup for parsing html files

    /**
     * Reads and returns the content found in the given html file
     *
     * @param file the html file being read from
     * @return the string of html found
     * @throws RuntimeException         if the given html file could not be found
     * @throws IllegalArgumentException if the given file is not a html file
     */
    @Override
    public String read(File file) {
        return null;
    }
}
