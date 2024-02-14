package com.example.l_m_s;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BooksAvailable  implements Initializable {

    @FXML
    private TableColumn<Book, String> CategoryCol;

    @FXML
    private TableColumn<Book, Integer> CopiesCol;

    @FXML
    private TableColumn<Book, String> authorCol;

    @FXML
    private TableColumn<Book, Integer> bookIDcol;

    @FXML
    private TableView<Book> bookTable;


    @FXML
    private TableColumn<Book, String> nameCol;


    ObservableList<Book> bookList = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoryCol.setCellValueFactory(new PropertyValueFactory<Book, String>("cat"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        bookIDcol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        CopiesCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("copies"));
        refreshtable();
    }



    @FXML
    public void refreshtable(){

        bookList.clear();

        String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
        String mysqluser="root";
        String mysqlpassword="$enujaImeth123";
        String query = "select*from books";

        try {
            Connection conn = DriverManager.getConnection(url, mysqluser, mysqlpassword);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()){
                bookList.add(new Book(rs.getInt("book_id"),
                                        rs.getString("name"),
                                        rs.getString("category"),
                                        rs.getString("author"),
                                        rs.getInt("copies")));

                bookTable.setItems(bookList);

            }


        }
        catch (Exception e){
            System.out.println("err");
        }
    }

    @FXML
    public void back(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();;
        Scene Scene1 = new Scene(root);
        stage.setScene(Scene1);
        stage.setTitle("Dashboard");
        stage.show();
    }





    }


