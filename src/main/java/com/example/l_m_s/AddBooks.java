package com.example.l_m_s;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class AddBooks {

    @FXML
    private TextField aut_field;

    @FXML
    private TextField cat_field;

    @FXML
    private TextField cop_field;

    @FXML
    private TextField name_field;

    @FXML
    public void addBook(ActionEvent e){
        String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
        String mysqluser="root";
        String mysqlpassword="$enujaImeth123";
        String query = "insert into books(category,name,Author,copies) values(?,?,?,?)";
        String category = cat_field.getText();
        String name = name_field.getText();
        String author = aut_field.getText();
        int copies = Integer.parseInt(cop_field.getText() );
        String checkquery = "update books set copies="+copies+" where name='"+name+"' and category='"+category+ "' and author='"+author+"';";

        try {
            Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpassword);
            Statement stmt = conn.createStatement();
            int row = stmt.executeUpdate(checkquery);

            if (row>0){
                Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
                informationAlert.setTitle("Success!");
                informationAlert.setContentText("number of copies updated!");
                informationAlert.showAndWait();

            }else {
                PreparedStatement stm = conn.prepareCall(query);
                stm.setString(1,name);
                stm.setString(2,category);
                stm.setString(3,author);
                stm.setInt(4,copies);
                stm.execute();

                Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
                informationAlert.setTitle("Success!");
                informationAlert.setContentText("updated!");
                informationAlert.showAndWait();

                cop_field.clear();
                name_field.clear();
                cop_field.clear();
                cat_field.clear();


            }



        }catch (Exception ee){
            System.out.println(ee);
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
