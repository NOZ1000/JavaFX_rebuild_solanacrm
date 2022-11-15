package com.solanacrm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PostController extends AppController{
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String errorMsg = "Something was Wrong";

    @FXML
    private TextArea contentField;

    @FXML
    private TextField titleField;

    @FXML
    private Label errorField;


    @FXML
    void clickPublish(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        if (validation()) {
            try {
                dbHandler.CreatePost(titleField.getText(), contentField.getText(), Auth.login);
            } catch (SQLException e) {
                System.out.println("In posts controller something was wrong");
            }
            errorField.setVisible(false);
            SwitchScene.switchToNews(stage, scene, root, event);
        } else {
            triggerError(errorMsg);
        }
    }

    public Boolean validation() {
        if (titleField.getText().length() == 0 ) {
            errorMsg = "Title can not be empty";
            return false;
        }

        if (contentField.getText().length() == 0) {
            errorMsg = "Content can not be empty";
            return false;
        }

        if (contentField.getText().length() > 499) {
            errorMsg = "Content length can't be more 500 characters";
            return false;
        }
        return true;
    }

    public void triggerError(String message) {
        this.errorField.setText(message);
        this.errorField.setVisible(true);
    }
}
