package com.solanacrm;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileController extends AppController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField loginField;

    @FXML
    private VBox vboxNavigation;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        navigationBar();
        fillFields();
    }


    public void fillFields() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ResultSet UserResult = dbHandler.getUser(String.valueOf(Auth.id_user));
        UserResult.next();
        firstNameField.setText(UserResult.getString(UserConst.USERS_FIRSTNAME));
        lastNameField.setText(UserResult.getString(UserConst.USERS_LASTNAME));
        loginField.setText(UserResult.getString(UserConst.USERS_LOGIN));

    }
}
