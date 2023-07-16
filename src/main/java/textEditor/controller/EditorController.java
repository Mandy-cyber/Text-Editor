package textEditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import textEditor.model.PageFile;


/**
 * Represents a tool for controlling the display and functionality of
 * the 'Editor' page in the Text Editor app
 */
public class EditorController extends PageController {
    // TOOL BAR RELATED
    //-----------------------------
    @FXML
    private ToolBar toolBar;
    @FXML
    private ChoiceBox<String> textCategorySelector;
    @FXML
    private ChoiceBox<Integer> fontSizeSelector;
    @FXML
    private ChoiceBox<String> fontStyleSelector;
    @FXML
    private ColorPicker fontColorSelector;
    @FXML
    private Button boldButton;
    @FXML
    private Button italicButton;
    @FXML
    private Button underlineButton;
    @FXML
    private Button cutButton;
    @FXML
    private Button copyButton;
    @FXML
    private Button pasteButton;
    // TAB PANE RELATED
    //-----------------------------
    @FXML
    private TabPane tabPane;
    // edit text
    @FXML
    private Tab editTextTab;
    @FXML
    private TextArea editArea;
    // preview text
    @FXML
    private Tab previewTextTab;
    @FXML
    private VBox previewArea;



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
        initElements();
    }

    /**
     * Initializes the elements on the page
     */
    @Override
    public void initElements() {

    }
}
