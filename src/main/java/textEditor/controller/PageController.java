package textEditor.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import textEditor.model.PageFile;
import textEditor.view.EditorView;
import textEditor.view.OpenView;
import textEditor.view.PageView;
import textEditor.view.SettingsView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Represents a tool for controlling the display and functionality of
 * a page in the Text Editor app
 */
public abstract class PageController {
    // GENERAL
    //-----------------------------
    protected PageFile pageFile;
    protected Stage stage;
    @FXML
    protected Scene scene;
    @FXML
    protected VBox fullBody;
    @FXML
    protected VBox mainBody;
    @FXML
    protected HBox footerBody;
    // MENU BAR RELATED
    //-----------------------------
    @FXML
    protected MenuBar menuBar;
    // FILE DROPDOWN
    //---------------
    @FXML
    protected Menu fileButton;
    @FXML
    protected MenuItem newButton;
    @FXML
    protected MenuItem openButton;
    @FXML
    protected MenuItem saveButton;
    @FXML
    protected MenuItem saveAsButton;
    @FXML
    protected MenuItem settingsButton;
    @FXML
    protected MenuItem quitButton;
    // EDIT DROPDOWN
    //---------------
    @FXML
    protected Menu editButton;
    @FXML
    protected MenuItem undoButton;
    @FXML
    protected MenuItem redoButton;
    @FXML
    protected MenuItem selectAllButton;
    // HELP DROPDOWN
    //---------------
    @FXML
    protected Menu helpButton;
    @FXML
    protected MenuItem aboutButton;


    /**
     * Initializes a new PageController with the given page on the given stage
     *
     * @param pageFile a page file
     * @param stage the stage that will be loaded
     */
    public PageController(PageFile pageFile, Stage stage) {
        this.pageFile = pageFile;
        this.stage = stage;
        this.scene = stage.getScene();
    }

    /**
     * Runs the controller
     */
    public abstract void run();

    /**
     * Initializes the elements on the page
     */
    public abstract void initElements();

    /**
     * Initializes the menu bar of the page, only adding functionality to the menu buttons
     * that can be clicked even if a file has not yet been opened
     */
    public void initMenuBar() {
        newButton.setOnAction(e -> {
            EditorController controller = new EditorController(new PageFile(), this.stage);
            switchScene("Untitled", new EditorView(controller), controller);
        });

        openButton.setOnAction(e -> {
            OpenController controller = new OpenController(this.pageFile, this.stage);
            switchScene("Open File", new OpenView(controller), controller);
        });

        settingsButton.setOnAction(e -> {
            SettingsController controller = new SettingsController(this.pageFile, this.stage);
            switchScene("Settings", new SettingsView(controller), controller);
        });

        quitButton.setOnAction(e -> stage.close());
        aboutButton.setOnAction(e -> openWebPage("https://github.com/Mandy-cyber/Text-Editor"));
    }

    /**
     * Opens the given webpage in the user's browser.
     *
     * @param url the url for the webpage being visited
     * @throws RuntimeException if the user's default browser is not found/fails to be launched
     *                          or if the given url could not be parsed as a URI reference.
     */
    protected void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("This was ran");
        } catch (IOException | URISyntaxException ex) {
            System.out.println("This was not ran");
            throw new RuntimeException(ex);
        }
    }


    /**
     * Switches to the scene represented in the given view and sets a new title
     * for the new stage.
     *
     * @param stageTitle the new title of the stage
     * @param view the new view for the stage
     * @param controller the new controller for the stage
     */
    public void switchScene(String stageTitle, PageView view, PageController controller) {
        // update stage
        Scene newScene = view.load();
        this.stage.setScene(newScene);
        this.stage.setTitle(stageTitle);
        // update controller
        controller.setPageFile(this.pageFile);
        controller.run();
    }

    /**
     * Sets the PageFile of this controller to the given one
     *
     * @param pageFile the new page file to be used
     */
    public void setPageFile(PageFile pageFile) {
        this.pageFile = pageFile;
    }
}
