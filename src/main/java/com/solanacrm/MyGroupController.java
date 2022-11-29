package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MyGroupController extends AppController {
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TableColumn<?, ?> firstNameColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> lastNameColumn;

    @FXML
    private TableColumn<?, ?> loginColumn;

    @FXML
    private TableView<?> table;

    @FXML
    private VBox vboxNavigation;

    @FXML
    void initialize() {
        navigationBar();
        Label rowId = new Label();
        rowId.setText("1ID");
    }
}
