package com.example.pendaftaran_siswa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JurusanController implements Initializable {
    @FXML
    TextField tfId;
    @FXML
    TextField tfJurusan;
    @FXML
    DatePicker dpWaktu;
    @FXML
    private TableView<Jurusan> tvJurusan;
    @FXML
    private TableColumn<Jurusan, String> colJurusan;
    @FXML
    private TableColumn<Jurusan, String> colWaktu;
    @FXML
    private TableColumn<Jurusan, String> colId;
    @FXML
    private TableColumn<Jurusan, String> colNomor;
    @FXML
    private AnchorPane alertTambah;
    @FXML
    private Button btnAlertTambah;
    @FXML
    private AnchorPane alertUpdate;
    @FXML
    private Button btnAlertUpdate;
    @FXML
    private AnchorPane alertDelete;
    @FXML
    private Button btnAlertDelete;

    ObservableList<Jurusan> JurusanList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        readTable();
        dpWaktu.setValue(LocalDate.now());
        tvJurusan.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Jurusan jurusan = (Jurusan) tvJurusan.getSelectionModel().getSelectedItem();
                tfJurusan.setText(String.valueOf(jurusan.getJurusan()));
                tfId.setText(String.valueOf(jurusan.getId()));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(jurusan.getWaktu(),formatter);
                dpWaktu.setValue(localDate);
            }
    });
    }

    @FXML
    public void dataSiswa(ActionEvent event) throws IOException, SQLException {
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

    @FXML
    public void editData(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("edit_data.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setFullScreen(true);
        stage.show();
        stage.setScene(scene);
    }

    @FXML
    public void editJurusan(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("edit_jurusan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setFullScreen(true);
        stage.show();
        stage.setScene(scene);
    }

    @FXML
    public void logOut (ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.setFullScreen(true);
        stage.show();
        stage.setScene(scene);
    }

    public void readTable(){
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = (ResultSet) conn.createStatement().executeQuery("SELECT * FROM tb_jurusan");
            int num = 0;
            while (rs.next()) {
                num += 1;
                JurusanList.add(new Jurusan(
                        rs.getInt("id"),
                        num,
                        rs.getString("jurusan"),
                        rs.getString("waktu")
                        ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        colNomor.setCellValueFactory(new PropertyValueFactory<>("nomor"));
        colJurusan.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        colWaktu.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tvJurusan.setItems(JurusanList);
    }
       public void insertJurusan() throws IOException {

            try {
                Connection conn = Database.getConnection();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_jurusan(jurusan,waktu) VALUES (?,?)");

                pst.setString(1, tfJurusan.getText());
                pst.setString(2, String.valueOf(dpWaktu.getValue()));

                pst.execute();
                alertTambah.setVisible(true);

//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("SUKSES");
//                alert.setHeaderText("Kategori");
//                alert.setContentText("Berhasil Menambahkan Data");
//                alert.showAndWait();
            } catch (SQLException ex) {
                Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnAlertTambah.setOnAction(e -> alertTambah.setVisible(false));
           tvJurusan.getItems().clear();
            readTable();
        }
        @FXML
    public void updateJurusan(ActionEvent event)  {
        String valueId = tfId.getText();
        String valueJurusan = tfJurusan.getText();
        String valueWaktu = String.valueOf(dpWaktu.getValue());

        try {
            Connection conn = Database.getConnection();
            String sql = "UPDATE tb_jurusan SET jurusan = '" + valueJurusan + "',waktu = '" + valueWaktu + "' WHERE id = '" + valueId + "'";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.executeUpdate();
            alertUpdate.setVisible(true);



//            App.setRoot("dashboard_userAdmin");
        } catch (SQLException ex) {
            Logger.getLogger(JurusanController.class.getName()).log(Level.SEVERE, null, ex);
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText("Data Gagal");
//            alert.showAndWait();
        }
        btnAlertUpdate.setOnAction(e -> alertUpdate.setVisible(false));
        tvJurusan.getItems().clear();
        readTable();
    }
    public void deleteJurusan() throws IOException {
        readTable();
        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM tb_jurusan WHERE jurusan = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tfJurusan.getText());
            pst.execute();

            alertDelete.setVisible(true);


        } catch (SQLException ex) {
            Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAlertDelete.setOnAction(e -> alertDelete.setVisible(false));
        tvJurusan.getItems().clear();
        readTable();
    }

//    @FXML
//    private void handleMenuButtonAction (ActionEvent event) throws IOException {
//        Stage stage = null;
//        Parent myNewScene = null;
//
//        if (event.getSource() == btnDataSiswa){
//                Parent root = FXMLLoader.load(getClass().getResource("info_admin.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setMinWidth(600);
//                stage.setMinHeight(400);
//                stage.setFullScreen(true);
//                stage.show();
//                stage.setScene(scene);
//        } else if (event.getSource() == btnManageSiswa){
//            Parent root = FXMLLoader.load(getClass().getResource("info_admin.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setMinWidth(600);
//            stage.setMinHeight(400);
//            stage.setFullScreen(true);
//            stage.show();
//            stage.setScene(scene);
//        } else if (event.getSource() == btnManageJurusan) {
//            Parent root = FXMLLoader.load(getClass().getResource("info_admin.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setMinWidth(600);
//            stage.setMinHeight(400);
//            stage.setFullScreen(true);
//            stage.show();
//            stage.setScene(scene);
//        }
//        else if (event.getSource() == btnLogOut) {
//            stage = (Stage) btnLogOut.getScene().getWindow();
//             myNewScene = FXMLLoader.load(getClass().getResource("login.fxml"));
////            Scene scene = new Scene(root);
//            stage.setMinWidth(600);
//            stage.setMinHeight(400);
//            stage.setFullScreen(true);
//            stage.show();
//
//        }
//
//        Scene scene = new Scene(myNewScene);
//
//        stage.setScene(scene);
//        stage.setTitle("My New Scene");
//        stage.show();
//        stage.setMaximized(true);
//
//    }
    @FXML
    public void logout(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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




