package com.example.l_m_s;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class LoginController {

    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField pwfield;

    @FXML
    private TextField usernamefield;

    @FXML
    public void login(ActionEvent e){
        String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
        String mysqluser="root";
        String mysqlpassword="$enujaImeth123";
        String password = pwfield.getText();
        String username = usernamefield.getText();

        String query = ("select Password from admin where user_id='"+username+" '");

        try {

            Connection conn = DriverManager.getConnection(url, mysqluser, mysqlpassword);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            if (rs.next()){
                String realpw= rs.getString("Password");

                if(realpw.equals(password)) {

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();;
                    Scene Scene1 = new Scene(root);
                    stage.setScene(Scene1);
                    stage.setTitle("Dashboard");
                    stage.show();

                }else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("error");
                        alert.setContentText("Incorrect password or username");
                        alert.showAndWait();
                    }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setContentText("Incorrect username");
                alert.showAndWait();
            }


        }catch (Exception eee){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText(eee.getMessage());
            alert.showAndWait();
        }


    }





}
