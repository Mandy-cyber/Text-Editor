/**
 * Contains all the data used needed to build and use the module.
 */
module textEditor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires org.jetbrains.annotations;

    opens textEditor to javafx.fxml;
    exports textEditor;
}


