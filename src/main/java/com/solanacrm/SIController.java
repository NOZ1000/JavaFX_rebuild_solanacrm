package com.solanacrm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SIController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label errorField;

    @FXML
    private TextField loginFieldSI;

    @FXML
    private PasswordField passFieldSI;

    @FXML
    private Label successField;

    @FXML
    void submitSIButton(ActionEvent event) {

    }

    @FXML
    void switchToSignUp(ActionEvent event) throws IOException {
        SwitchScene.switchToSignUp(stage,scene,root,event);
    }

    @FXML
    void initialize() {
        if (Auth.SUSuccess) {
            successField.setVisible(true);
            Auth.SUSuccess = false;
        }

    }
}
