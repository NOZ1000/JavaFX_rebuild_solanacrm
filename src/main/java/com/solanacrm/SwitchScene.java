package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SwitchScene {

    public static void switchToSignUp(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("SUpage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToSignIn(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("SIpage.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToApp(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("App.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToNews(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("News.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToCreatePost(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("CreatePost.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void switchToProfile(Stage stage, Scene scene, Parent root, ActionEvent event) throws IOException {
        root  = FXMLLoader.load(Objects.requireNonNull(SwitchScene.class.getResource("Profile.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
