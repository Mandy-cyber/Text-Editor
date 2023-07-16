package textEditor;

import javafx.application.Application;
import javafx.stage.Stage;
import textEditor.controller.EditorController;
import textEditor.model.PageFile;
import textEditor.view.EditorView;
import textEditor.view.PageView;

public class Driver extends Application {

    public static void main(String[] args) {
        launch();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param stage        the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
        EditorController controller = new EditorController(new PageFile(), stage);
        PageView view = new EditorView(controller);

        try {
            stage.setScene(view.load());
            stage.setTitle("Testing 123");
            controller.run();
            stage.show();
        } catch (IllegalStateException exc) {
            System.err.println("oh dear... we're unable to load the GUI!");
            System.out.println("----------------------------------------------");
            throw exc;
        }
    }
}
