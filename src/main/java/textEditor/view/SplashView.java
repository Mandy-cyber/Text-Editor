package textEditor.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import textEditor.controller.SplashController;

import java.io.IOException;

/**
 * Represents the view of the splash screen in the app
 */
public class SplashView implements PageView {
    private final FXMLLoader loader;

    /**
     * Initializes a SplashView controlled by the given controller
     *
     * @param controller the controller for the 'open file' page
     */
    public SplashView(SplashController controller) {
        this.loader = new FXMLLoader();
        this.loader.setController(controller);
        this.loader.setLocation(getClass().getClassLoader().getResource("splash.fxml"));
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
