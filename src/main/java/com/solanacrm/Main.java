package com.solanacrm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SIpage.fxml")));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Solana CRM");

        try {
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("assets/logo.jpeg")).openStream()));
        } catch (Exception e) {
            System.out.println(e);
        }

        stage.setScene(scene);
        stage.show();
    }
}
