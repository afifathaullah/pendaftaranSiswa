package com.example.pendaftaran_siswa;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TambahController implements Initializable {

    @FXML
    private TextField tfNisn;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfTempat;
    @FXML
    private DatePicker dpTgl;
    @FXML
    ToggleGroup tgGender;
    //I called it right in SceneBuilder.
    @FXML
    private RadioButton rbLakiLaki;
    @FXML
    private RadioButton rbPerempuan;
    @FXML
    private ComboBox cbKelas;
    @FXML
    private TextField tfAlamat;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfLolos;
    @FXML
    private Button btnDataSiswa;
    @FXML
    private Button btnManageSiswa;
    @FXML
    private Button btnManageJurusan;
    @FXML
    private Button btnLogOut;


    @FXML
    private TextField tfSearch;

    @FXML
    private TableColumn<SiswaModel, String> colNomer;

    @FXML
    private TableView<SiswaModel> tvSiswa;
    @FXML
    private TableColumn<SiswaModel, String> colNama;
    @FXML
    private TableColumn<SiswaModel, String> colNisn;
    @FXML
    private TableColumn<SiswaModel, String> colGender;
    @FXML
    private TableColumn<SiswaModel, String> colTempatTgl;
    @FXML
    private TableColumn<SiswaModel, String> colKelas;
    @FXML
    private TableColumn<SiswaModel, String> colAlamat;
    @FXML
    private TableColumn<SiswaModel, String> colAction;
    @FXML
    public TableColumn<SiswaModel, String> colNomor;

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
    @FXML
    private Text alertNama;
    @FXML
    private Text alertNisn;



    ObservableList<SiswaModel> SiswaList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readTable();
        comboBox();
//        searchData();
//        tfLolos = new TextField("0");
        tvSiswa.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                SiswaModel siswaModel = (SiswaModel) tvSiswa.getSelectionModel().getSelectedItem();
                tfId.setText(String.valueOf(siswaModel.getId()));
//                tfLolos.setText(String.valueOf(siswaModel.getId()));
                tfNama.setText(String.valueOf(siswaModel.getNama()));
                tfNisn.setText(String.valueOf(siswaModel.getNisn()));
                tfTempat.setText(String.valueOf(siswaModel.getTempat_lahir()));

                String get_gender = String.valueOf(siswaModel.getGender());
                switch (get_gender) {
                    case "Laki-laki":
                        rbLakiLaki.setSelected(true);

                        break;
                    case "Perempuan":
                        rbPerempuan.setSelected(true);

                        break;
                    default:
                        System.out.println("Bencong");
                        break;
                }
                cbKelas.setValue(String.valueOf(siswaModel.getKelas()));
                tfAlamat.setText(String.valueOf(siswaModel.getAlamat()));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(siswaModel.getTgl_lahir(),formatter);
                dpTgl.setValue(localDate);
            }
        });
    }

    public void insertSiswa() throws IOException,SQLException {

//        String nama = tfNama.getText();
//        String nisn = tfNisn.getText();
//        alertNisn.setVisible(false);
//        alertNama.setVisible(false);
//
//        if (nama == nama ) {
////            System.out.println("Data Sama");
//            alertNama.setVisible(true);
//            alertNisn.setVisible(false);
//        }else if(nisn == nisn) {
//            alertNama.setVisible(false);
//            alertNisn.setVisible(true);
//        }else if(nisn == nisn || nama == nama) {
//            alertNama.setVisible(true);
//            alertNisn.setVisible(true);
//        }else {
            try {
                String output_gender = "tidak diketahui";
                if(rbPerempuan.isSelected() == true) {
                    output_gender = rbPerempuan.getText();

                }else if (rbLakiLaki.isSelected() == true) {
                    output_gender = rbLakiLaki.getText();
                }
                Connection conn = Database.getConnection();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO tb_siswa(nama, nisn, tempat_lahir,tgl_lahir,gender,kelas,alamat,lolos) VALUES (?,?,?,?,?,?,?,'')" );
                pst.setString(1, tfNama.getText());
                pst.setString(2, tfNisn.getText());
                pst.setString(3, tfTempat.getText());
                pst.setString(4, String.valueOf(dpTgl.getValue()));
                pst.setString(5, output_gender);
                pst.setString(6, String.valueOf(cbKelas.getValue()));
                pst.setString(7, tfAlamat.getText());
//            pst.setString(8, tfLolos.getText());
                pst.execute();

                alertTambah.setVisible(true);

//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("SUKSES");
//            alert.setHeaderText("Kategori");
//            alert.setContentText("Berhasil Menambahkan Data");
//            alert.showAndWait();
//            clearForm();
//            readTable();
            } catch (SQLException ex) {
                Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);

            }
//            Parent root = FXMLLoader.load(getClass().getResource("daftar_siswa.fxml"));
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setMinWidth(600);
//            stage.setMinHeight(400);
//            stage.setFullScreen(true);
//            stage.show();
//            stage.setScene(scene);
//        }

        btnAlertTambah.setOnAction(e -> alertTambah.setVisible(false));
        tvSiswa.getItems().clear();
        readTable();
    }

    public void updateDataUser() throws IOException {
        try {
            Connection conn = Database.getConnection();
            String valueId = tfId.getText();
            String valueNama = tfNama.getText();
            String valueNisn = tfNisn.getText();
            String valuetempatLahir = tfTempat.getText();
            String valueTglLahir = String.valueOf(dpTgl.getValue());
            String valueGender = rbPerempuan.getText();
            String valueKelas = String.valueOf(cbKelas.getValue());
            String valueAlamat = tfAlamat.getText();
            String sql = "UPDATE tb_siswa set nama= '" + valueNama + "', nisn= '" + valueNisn + "', tempat_lahir ='"+ valuetempatLahir+ "', tgl_lahir ='"+ valueTglLahir + "', gender ='"+ valueGender+"', kelas ='"+ valueKelas + "', alamat ='"+ valueAlamat + "' WHERE id= '" + valueId + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            alertUpdate.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAlertUpdate.setOnAction(e -> alertUpdate.setVisible(false));
        tvSiswa.getItems().clear();
        readTable();
    }

    public void deleteData() throws IOException {

        try {
            Connection conn = Database.getConnection();
            String sql = "DELETE FROM tb_siswa WHERE nama = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tfNama.getText());
            pst.execute();

//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText("Data Berhasil Dihapus");
//            alert.showAndWait();
            alertDelete.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAlertDelete.setOnAction(e -> alertDelete.setVisible(false));
        tvSiswa.getItems().clear();
        readTable();
    }
    public void clearForm(){
        tfNama.clear();
        tfNisn.clear();
        tfTempat.clear();
        tfAlamat.clear();
        dpTgl.setValue(null);
        cbKelas.getSelectionModel().select(null);
        rbPerempuan.setSelected(false);
        rbLakiLaki.setSelected(false);
        tvSiswa.getSelectionModel().select(null);

    }
    private void comboBox() {

        Statement st;
//        connect = connectDb();
        ObservableList<String> Kelaslist = FXCollections.observableArrayList();

        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_jurusan");
            while (rs.next()) {
                Kelaslist.add(rs.getString("jurusan"));

            }
        } catch (Exception ex) {

        }

        cbKelas.setItems(null);
        cbKelas.setItems(Kelaslist);

        //To change body of generated methods, choose Tools | Templates.
    }

    public void readTable(){

        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
            int num = 0;
            {
                while (rs.next()) {
                    num += 1;
                    SiswaList.add(new SiswaModel(
                            rs.getInt("id"),
                            num,
                            rs.getString("lolos"),
                            rs.getString("nama"),
                            rs.getString("nisn"),
                            rs.getString("tempat_lahir"),
                            rs.getString("tgl_lahir"),
                            rs.getString("gender"),
                            rs.getString("kelas"),
                            rs.getString("alamat")));
                }
            }
//            tvSiswa.setItems(SiswaList);
//            searchData();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        colNomor.setCellValueFactory(new PropertyValueFactory<>("nomer"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colNisn.setCellValueFactory(new PropertyValueFactory<>("nisn"));
        colTempatTgl.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getTempat_lahir() + ", " + cellData.getValue().getTgl_lahir()
        ));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colKelas.setCellValueFactory(new PropertyValueFactory<>("kelas"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("lolos"));

        tvSiswa.setItems(SiswaList);
    }
//    public void readTable(){
//
//        try {
//            Connection conn = Database.getConnection();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
//            int num = 0;
//            while (rs.next()) {
//                num += 1;
//                SiswaList.add(new SiswaModel(
//                        rs.getInt("id"),
//                        num,
//                        rs.getString("lolos"),
//                        rs.getString("nama"),
//                        rs.getString("nisn"),
//                        rs.getString("tempat_lahir"),
//                        rs.getString("tgl_lahir"),
//                        rs.getString("gender"),
//                        rs.getString("kelas"),
//                        rs.getString("alamat")));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//
//        colNomor.setCellValueFactory(new PropertyValueFactory<>("nomer"));
//        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
//        colNisn.setCellValueFactory(new PropertyValueFactory<>("nisn"));
//        colTempatTgl.setCellValueFactory(cellData -> Bindings.createStringBinding(
//                () -> cellData.getValue().getTempat_lahir() + ", " + cellData.getValue().getTgl_lahir()
//        ));
//        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        colKelas.setCellValueFactory(new PropertyValueFactory<>("kelas"));
//        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
//        colAction.setCellValueFactory(new PropertyValueFactory<>("lolos"));
//
//
//        FilteredList<SiswaModel> filteredData = new FilteredList<>(SiswaList, b -> true);
//        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(kategori -> {
//                if (newValue == null || newValue.isEmpty()){
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (kategori.getNama().toLowerCase().indexOf(lowerCaseFilter) != -1){
//                    return true;
//                }else if(String.valueOf(kategori.getNisn()).indexOf(lowerCaseFilter)!=-1)
//                    return true;
//                else
//                    return false;
//
//            });
//        });
//        SortedList<SiswaModel> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tvSiswa.comparatorProperty());
//        tvSiswa.setItems(sortedData);
//    }
//
//    public void searchData(){
//        FilteredList<SiswaModel> filteredData = new FilteredList<>(SiswaList, b -> true);
//        tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(kategori -> {
//                if (newValue == null || newValue.isEmpty()){
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (kategori.getNama().toLowerCase().indexOf(lowerCaseFilter) != -1){
//                    return true;
//                }else if(String.valueOf(kategori.getNisn()).indexOf(lowerCaseFilter)!=-1)
//                    return true;
//                else
//                    return false;
//
//            });
//        });
//        SortedList<SiswaModel> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(tvSiswa.comparatorProperty());
//        tvSiswa.setItems(sortedData);
//    }
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

}
