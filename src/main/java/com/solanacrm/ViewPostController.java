package com.solanacrm;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewPostController extends PostController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private TextArea contentField;

    @FXML
    private Label dateField;

    @FXML
    private Label errorField;

    @FXML
    private TextField titleField;

    @FXML
    private VBox vboxNavigation;

    @FXML
    private Label loginField;


    @Override
    void initialize() throws SQLException, ClassNotFoundException {
        navigationBar();
        fillPostContent();
    }

    public void fillPostContent() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet postResult = dbHandler.getPost(String.valueOf(Auth.id_post));
        postResult.next();

        titleField.setText(postResult.getString("title"));
        contentField.setText(postResult.getString("content"));
        dateField.setText(String.valueOf(postResult.getDate("date")));
        loginField.setText(postResult.getString("author"));
        Auth.id_post = 0;
    }
}
