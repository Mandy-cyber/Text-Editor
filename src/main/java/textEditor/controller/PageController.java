package textEditor.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import textEditor.model.PageFile;
import textEditor.view.PageView;

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
    private MenuBar menuBar;
    // FILE DROPDOWN
    //---------------
    @FXML
    private Menu fileButton;
    @FXML
    private MenuItem newButton;
    @FXML
    private MenuItem openButton;
    @FXML
    private MenuItem saveButton;
    @FXML
    private MenuItem saveAsButton;
    @FXML
    private MenuItem preferencesButton;
    @FXML
    private MenuItem quitButton;
    // EDIT DROPDOWN
    //---------------
    @FXML
    private Menu editButton;
    @FXML
    private MenuItem undoButton;
    @FXML
    private MenuItem redoButton;
    @FXML
    private MenuItem selectAllButton;
    // HELP DROPDOWN
    //---------------
    @FXML
    private Menu helpButton;
    @FXML
    private MenuItem aboutButton;


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
     * Initializes the menu bar of the page
     */
    public void initMenuBar() {
        // TODO: write this
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
