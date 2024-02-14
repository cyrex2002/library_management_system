package com.example.l_m_s;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private Button BooksAvailablebtn;

    @FXML
    private Button StaffDetailsbtn;

    @FXML
    private Button addStaffbtn;

    @FXML
    private Button editadminbtn;

    @FXML
    private Button removebooksbtn;

    @FXML
    private Button removestaffbtn;
@FXML
public void booksA(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("books_available.fxml"));
    Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();;
    Scene Scene1 = new Scene(root);
    stage.setScene(Scene1);
    stage.setTitle("Books Available");
    stage.show();

}@FXML
public void booksAdd(ActionEvent e) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("add_books.fxml"));
    Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();;
    Scene Scene1 = new Scene(root);
    stage.setScene(Scene1);
    stage.setTitle("Add books");
    stage.show();

}

}



