package com.example.pendaftaran_siswa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnLogin;

    @FXML
    private TextField fldUsername;

    @FXML
    private PasswordField fldPassword;
    @FXML
    private Text alertLogin;
    @FXML
    private Text alertSalah;

//    Database database = new Database();
//    public static final String SELECT_ACCOUNT_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
    public void login(ActionEvent event) throws IOException, SQLException {
        Window owner = btnLogin.getScene().getWindow();

        System.out.println(fldUsername.getText());
        System.out.println(fldPassword.getText());

        if (fldUsername.getText().isEmpty()) {
            alertLogin.setVisible(true);
            alertSalah.setVisible(false);
            return;
        }
        if (fldPassword.getText().isEmpty()) {
            alertLogin.setVisible(true);
            alertSalah.setVisible(false);
            return;
        }

        String username = fldUsername.getText();
        String password = fldPassword.getText();

        Database database = new Database();
        boolean flag = Database.validate(username, password);

        if (!flag) {
            alertSalah.setVisible(true);
            alertLogin.setVisible(false);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("daftar_siswa.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinWidth(600);
            stage.setMinHeight(400);
            stage.setFullScreen(true);
            stage.show();
            stage.setScene(scene);
        }
    }

















//        int leveluser = database.login(fldUsername.getText(),fldPassword.getText());
//        if(leveluser== 3 && fldUsername.getText()==null || fldPassword.getText() == null){
//            alertLogin.setVisible(true);
//        } else if(leveluser== 1 ){
//            Parent root = FXMLLoader.load(getClass().getResource("daftar_siswa.fxml"));
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setMinWidth(600);
//            stage.setMinHeight(400);
//            stage.setMaximized(true);
//            stage.show();
//            stage.setScene(scene);
//        }
//        try {
//            Connection conn = Database.getConnect();
//            ResultSet tables = conn.getMetaData(null, null, "employee", null);
//            if (tables.next()) {
//
//            }
//            else {
//                alertLogin.setVisible(true);
//            }
//        }catch (Exception ex){
//            Logger.getLogger(DaftarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
////            Connection conn = Database.getConnect();
////            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
////            while (rs.next()) {
////                User.add(new User(
////                        rs.getInt("id"),
////                        rs.getString("username"),
////                        rs.getString("password")
////                        ));
//            Connection conn = Database.getConnect();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = conn.prepareStatement(rs.next()) {
//                preparedStatement.setString(1, useename);
//                preparedStatement.setString(2, password);
//                System.out.println(preparedStatement);
//                // Step 3: Execute the query or update query
//
//                ResultSet resultSet = preparedStatement.executeQuery();
//                User user = new User();
//            }
//                if (username.equals(rs.getString("username"))) {
//                    if (password.equals(rs.getString("password"))) {
//                        switchScreen(createOverview());
//                    } else{
//                        alert.showAndWait();
//                    }
//                } else{
//                    alert.showAndWait();
//                }
//                alert.showAndWait();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//






//    @FXML
//    private void User(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("hapus_siswa.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setMinWidth(600);
//        stage.setMinHeight(400);
//        stage.setMaximized(true);
//        stage.show();
//        stage.setScene(scene);
//
//    }

}