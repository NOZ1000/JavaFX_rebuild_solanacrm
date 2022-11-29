package com.solanacrm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyGroupController extends AppController {
    @FXML
    private AnchorPane AnchorPane;

//    @FXML
//    private TableColumn<Student, String> firstNameColumn;
//
//    @FXML
//    private TableColumn<Student, String> idColumn;
//
//    @FXML
//    private TableColumn<Student, String> lastNameColumn;
//
//    @FXML
//    private TableColumn<Student, String> loginColumn;

    @FXML
    private TableView<Student> table;

    @FXML
    private VBox vboxNavigation;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        navigationBar();
        constructTable();


        table.getItems().add( new Student("1", "John", "Sina", "johnSina@mail.ru"));
        fillTable();
    }

    private void constructTable() {
        TableColumn<Student, String> firstNameColumn =
                new TableColumn<>("First Name");
        TableColumn<Student, String> lastNameColumn =
                new TableColumn<>("Last Name");
        TableColumn<Student, String> idColumn =
                new TableColumn<>("ID");
        TableColumn<Student, String> loginColumn =
                new TableColumn<>("Login");

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        loginColumn.setCellValueFactory(
                new PropertyValueFactory<>("login"));

        table.getColumns().add(idColumn);
        table.getColumns().add(firstNameColumn);
        table.getColumns().add(lastNameColumn);
        table.getColumns().add(loginColumn);


    }

    private void fillTable() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ResultSet UserResult = dbHandler.getAllStudents();
        while(UserResult.next()) {
            table.getItems().add(new Student(UserResult.getString(UserConst.USERS_ID), UserResult.getString(UserConst.USERS_FIRSTNAME), UserResult.getString(UserConst.USERS_LASTNAME), UserResult.getString(UserConst.USERS_LOGIN)));
        }
    }
}