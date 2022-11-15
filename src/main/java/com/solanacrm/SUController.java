package com.solanacrm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SUController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String isTeacher = "false";
    public String errorMsg;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField confirmPassFieldSU;

    @FXML
    private Label errorField;

    @FXML
    private TextField firstNameFieldSU;

    @FXML
    private RadioButton imTeacher;

    @FXML
    private TextField lastNameFieldSU;

    @FXML
    private TextField loginFieldSU;

    @FXML
    private PasswordField passFieldSU;

    @FXML
    void submitSUButton(ActionEvent event) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        boolean sqlErrors = false;

        if (validation()) {
            try {
                dbHandler.SUUser(firstNameFieldSU.getText(), lastNameFieldSU.getText(), loginFieldSU.getText(), passFieldSU.getText(), isTeacher);
            } catch (SQLIntegrityConstraintViolationException duplicate) {
                sqlErrors = true;
                triggerError("User with same login already exist");
            }
            catch (ClassNotFoundException | SQLException e) {
                sqlErrors = true;
            }

            if (!sqlErrors) {
                Auth.SUSuccess = true;
                SwitchScene.switchToSignIn(stage, scene, root, event);

            }
        } else {
            triggerError(errorMsg);
        }

    }

    @FXML
    void switchToSignIn(ActionEvent event) throws IOException {
        SwitchScene.switchToSignIn(stage,scene,root,event);
    }

    public Boolean validation() {
        if(imTeacher.isSelected()) {
            this.isTeacher = "true";
        }

        if (passFieldSU.getText().length() < 3) {
            this.errorMsg = "Password can not be less than 3";
            return false;
        }

        if (loginFieldSU.getText().length() < 3) {
            this.errorMsg = "LOGIN can not be less than 3";
            return false;
        }

        if (!Objects.equals(confirmPassFieldSU.getText(), passFieldSU.getText())) {
            this.errorMsg = "Password doesn't match";
            return false;
        }


        return true;
    }

    public void triggerError(String message) {
        this.errorField.setText(message);
        this.errorField.setVisible(true);
    }
}
