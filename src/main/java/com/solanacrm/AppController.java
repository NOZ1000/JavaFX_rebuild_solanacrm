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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public AnchorPane AnchorPane;


    @FXML
    public VBox vboxNavigation;

    @FXML
    void clickLogOut(ActionEvent event) throws IOException {
        SwitchScene.switchToSignIn(stage,scene,root,event);
    }

    @FXML
    void clickMyProfile(ActionEvent event) {

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        navigationBar();

    }

    public void navigationBar() {
        Button newsButton = new Button();
        newsButton.setText("News");
        newsButton.setPrefSize(230,35);
        newsButton.setOnAction(event -> {
            try {
                SwitchScene.switchToNews(stage,scene,root,event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        this.vboxNavigation.getChildren().add(newsButton);



        Button profileButton = new Button();
        profileButton.setText("Profile");
        profileButton.setPrefSize(230,35);
        profileButton.setOnAction(event -> {
            try {
                SwitchScene.switchToSignUp(stage,scene,root,event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        this.vboxNavigation.getChildren().add(profileButton);
    }

}
