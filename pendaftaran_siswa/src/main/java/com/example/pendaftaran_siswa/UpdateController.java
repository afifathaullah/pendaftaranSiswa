//package com.example.pendaftaran_siswa;
//
//import javafx.beans.binding.Bindings;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//
//public class UpdateController implements Initializable {
//    @FXML
//    private TableView<SiswaModel> tvSiswa;
//    @FXML
//    private TableColumn<SiswaModel, String> colNama;
//    @FXML
//    private TableColumn<SiswaModel, String> colNisn;
//    @FXML
//    private TableColumn<SiswaModel, String> colGender;
//    @FXML
//    private TableColumn<SiswaModel, String> colTempatTgl;
//    @FXML
//    private TableColumn<SiswaModel, String> colKelas;
//    @FXML
//    private TableColumn<SiswaModel, String> colAlamat;
//    ObservableList<SiswaModel> SiswaList = FXCollections.observableArrayList();
//    int index = -1;
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//        try {
//            Connection conn = Database.getConnect();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
//            while (rs.next()) {
//                SiswaList.add(new SiswaModel(
//                        rs.getInt("id"),
//                        rs.getInt("lolos"),
//                        rs.getString("nama"),
//                        rs.getString("nisn"),
//                        rs.getString("tempat_lahir"),
//                        rs.getString("tgl_lahir"),
//                        rs.getString("gender"),
//                        rs.getString("kelas"),
//                        rs.getString("alamat")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DaftarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
//        colNisn.setCellValueFactory(new PropertyValueFactory<>("nisn"));
//        colTempatTgl.setCellValueFactory(cellData -> Bindings.createStringBinding(
//                () -> cellData.getValue().getTempat_lahir() + ", " + cellData.getValue().getTgl_lahir()
//        ));
//        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        colKelas.setCellValueFactory(new PropertyValueFactory<>("kelas"));
//        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
//        tvSiswa.setItems(SiswaList);
//
//    }
//
//
//}
