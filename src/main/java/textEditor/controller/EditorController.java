package textEditor.controller;

import javafx.stage.Stage;
import textEditor.model.PageFile;

/**
 * Represents a tool for controlling the display and functionality of
 * the 'Editor' page in the Text Editor app
 */
public class EditorController extends PageController {
    /**
     * Initializes a new EditorController with the given page on the given stage
     *
     * @param pageFile a page file
     * @param stage the stage that will be loaded
     */
    public EditorController(PageFile pageFile, Stage stage) {
        super(pageFile, stage);
    }

    /**
     * Runs the controller
     */
    @Override
    public void run() {

    }

    /**
     * Initializes the elements on the page
     */
    @Override
    public void initElements() {

    }
}
