package textEditor.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import textEditor.controller.EditorController;

import java.io.IOException;

/**
 * Represents the view of the text editor in the app
 */
public class EditorView implements PageView {
    private final FXMLLoader loader;

    /**
     * Initializes an EditorView controlled by the given controller
     *
     * @param controller the controller for the editor page
     */
    public EditorView(EditorController controller) {
        this.loader = new FXMLLoader();
        this.loader.setController(controller);
        this.loader.setLocation(getClass().getClassLoader().getResource("editor.fxml"));
    }

    /**
     * Loads the Editor JavaFX page.
     *
     * @return the page's scene
     * @throws IllegalStateException if the scene could not be loaded
     */
    @Override
    public Scene load() {
        try {
            return this.loader.load();
        } catch (IOException exc) {
            throw new IllegalStateException("Unable to load page layout.");
        }
    }
}
