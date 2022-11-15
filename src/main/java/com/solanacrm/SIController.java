package com.solanacrm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private Label errorField;

    @FXML
    private TextField loginFieldSI;

    @FXML
    private PasswordField passFieldSI;

    @FXML
    private Label successField;

    @FXML
    void submitSIButton(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if (SignInValidation(loginFieldSI.getText(), passFieldSI.getText())) {
            SwitchScene.switchToApp(stage,scene,root,event);
        }
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

    private boolean SignInValidation(String login, String pass) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet UserResult = dbHandler.SIUser(loginFieldSI.getText(), passFieldSI.getText());

        int counter = 0;
        while (UserResult.next()) {
            counter++;
        }

        if (counter==1) {
//            System.out.println("User exist");
            Auth.login = UserResult.getString("login");
            return true;
        } else {
            triggerError("User doesn't exist");
            return false;
        }

    }

    public void triggerError(String message) {
        this.errorField.setText(message);
        this.errorField.setVisible(true);
    }
}
