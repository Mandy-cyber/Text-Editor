package textEditor.view;

import javafx.scene.Scene;

/**
 * Represents a GUI view in the text editor app
 */
public interface PageView {

    /**
     * Loads the appropriate JavaFX page.
     *
     * @return the page's scene
     * @throws IllegalStateException if the scene could not be loaded
     */
    Scene load();
}
