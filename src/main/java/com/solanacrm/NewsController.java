package com.solanacrm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NewsController extends AppController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private VBox vboxNews;

    @FXML
    void clickAddPost(ActionEvent event) throws IOException {
        SwitchScene.switchToCreatePost(stage, scene, root, event);
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        navigationBar();
        newsBoard();

    }

    public void newsBoard() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        for (int i = 1; i < dbHandler.countOfPosts(); i++) {
            ResultSet postResult = dbHandler.getPost(String.valueOf(i));
            postResult.next();
            try {
                Button postbutton = new Button();
                postbutton.setId(String.valueOf(i));
                String buttontext = "Post id: " + String.valueOf(i) + " | Title: " + postResult.getString("title");
                postbutton.setText(buttontext);
                int finalI = i;
                postbutton.setOnAction(event -> {
                    Auth.id_post = finalI;
                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ViewPost.fxml")));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                });
                vboxNews.getChildren().add(postbutton);
            } catch (SQLException e) {
//                System.out.println(e);
            }

        }
    }
}
