package com.example.pendaftaran_siswa;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DaftarController implements Initializable {

    @FXML
    private TableView<SiswaModel> tvSiswa;
    @FXML
    private TableColumn<SiswaModel, String> colNomor;
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
    private TextField tfSearch;
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
    private AnchorPane alertUpdate;
    @FXML
    private Button btnAlertUpdate;

    ObservableList<SiswaModel> SiswaList = FXCollections.observableArrayList();

    int index = -1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readTable();
//        searchData();
        tvSiswa.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                SiswaModel siswaModel = (SiswaModel) tvSiswa.getSelectionModel().getSelectedItem();
                tfId.setText(String.valueOf(siswaModel.getId()));
//                tfLolos.setText(String.valueOf(siswaModel.getLolos()));

            }
        });
//        try {
//            Connection conn = Database.getConnect();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
//            int num = 0;
//            while (rs.next()) {
//                num += 1;
//                SiswaList.add(new SiswaModel(
//                        num,
//                        rs.getInt("id"),
//                        rs.getString("lolos"),
//                        rs.getString("nama"),
//                        rs.getString("nisn"),
//                        rs.getString("tempat_lahir"),
//                        rs.getString("tgl_lahir"),
//                        rs.getString("gender"),
//                        rs.getString("kelas"),
//                        rs.getString("alamat")
//                          ));
//                          }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaftarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
//        System.out.println(new PropertyValueFactory<>("lolos"));
//        System.out.println(value);
//        if (value.equals("lolos")){
//            colAction.setCellValueFactory(new PropertyValueFactory<>("lolos"));
//        }else{
//            Callback<TableColumn<SiswaModel, String>, TableCell<SiswaModel, String>> cellFactory
//                    =
//                    new Callback<TableColumn<SiswaModel, String>, TableCell<SiswaModel, String>>() {
//                        @Override
//                        public TableCell call(final TableColumn<SiswaModel, String> param) {
//                            final TableCell<SiswaModel, String> cell = new TableCell<SiswaModel, String>() {
//
//                                Button btnLolos = new Button("Lolos");
//
//
//                                @Override
//                                public void updateItem(String item, boolean empty) {
//                                    super.updateItem(item, empty);
//                                    if (empty) {
//                                        setGraphic(null);
//                                        setText(null);
//                                    } else {
//                                        btnLolos.setOnAction(event -> {
//                                            btnLolos.setStyle("-fx-background-color: #ff0000; ");
//                                            btnLolos.setDisable(true);
//
////                                        System.out.println(SiswaModel.getNama()
////                                                + "   " + SiswaModel.getNisn());
//                                        });
//                                        setGraphic(btnLolos);
//                                        setText(null);
//                                    }
//                                }
//                            };
//                            return cell;
//                        };
//                    };

//            colAction.setCellFactory(cellFactory);
//        }
//        tvSiswa.setItems(SiswaList);
    }
//    public void searchData(){
//        //        search / filter
//        FilteredList<SiswaModel> filteredData = new  FilteredList<>(SiswaList, b -> true);
//        tfSearch.textProperty().addListener((observable, newValue, oldValue) -> {
//            filteredData.setPredicate(tvSiswa -> {
//
//                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
//                    return true;
//                }
//
//                String seachKeyword = newValue.toLowerCase();
//
//                if (tvSiswa.getNama().toLowerCase().indexOf(seachKeyword) > - 1) {
//                    return true;
//                }else {
//                    return false;
//                }
//
//            });
//        });
//
//        SortedList<SiswaModel> sortedData = new SortedList<>(filteredData);
//
//        sortedData.comparatorProperty().bind(tvSiswa.comparatorProperty());
//
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
//    @FXML
//    private void handleMenuButtonAction (ActionEvent event) throws IOException {
//        Stage stage = null;
//        Parent myNewScene = null;
//
//        if (event.getSource() == btnDataSiswa){
//            stage = (Stage) btnDataSiswa.getScene().getWindow();
//            myNewScene = FXMLLoader.load(getClass().getResource("daftar_siswa.fxml"));
//            stage.setMaximized(true);
//        } else if (event.getSource() == btnManageSiswa){
//            stage = (Stage) btnManageSiswa.getScene().getWindow();
//            myNewScene = FXMLLoader.load(getClass().getResource("edit_data.fxml"));
//            stage.setMaximized(true);
//        } else if (event.getSource() == btnManageJurusan) {
//            stage=(Stage) btnManageJurusan.getScene().getWindow();
//            myNewScene = FXMLLoader.load(getClass().getResource("edit_jurusan.fxml"));
//            stage.setMaximized(true);
//        }
//        else if (event.getSource() == btnLogOut) {
//            myNewScene = FXMLLoader.load(getClass().getResource("login.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setMaximized(true);
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

    public void readTable(){

        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
            int num = 0;
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

    public void loloskan() throws IOException {
        try {
            Connection conn = Database.getConnection();
            String valueId = tfId.getText();
//            String valueLolos = tfLolos.getText();

            String sql = "UPDATE tb_siswa set lolos = 'Lolos' WHERE id= '" + valueId + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Data Berhasil Diupdate");
            alert.showAndWait();
            alertUpdate.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(TambahController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tvSiswa.getItems().clear();
        btnAlertUpdate.setOnAction(e -> alertUpdate.setVisible(false));
        readTable();
    }

    public void printLaporan(ActionEvent event) throws ClassNotFoundException {
        JasperPrint jp;
        HashMap parameters = new HashMap();
        try {
            jp = JasperFillManager.fillReport("report/print.jasper",parameters,Database.getConnection());
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setVisible(true);
        }catch (JRException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void printLaporan(ActionEvent actionEvent) {
//        JasperPrint jp;
//        HashMap parameters = new HashMap();
//        try {
//            jp = JasperFillManager.fillReport("report/invoice.jasper",parameters,Database.getConnection());
//            JasperViewer viewer = new JasperViewer(jp, false);
//            viewer.setVisible(true);
//        }catch (JRException e){
//            System.out.println(e.getMessage());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//@FXML
//    public void printLaporan() {
//    Task<Void> task = new Task<Void>(){
//            @Override
//            protected Void call() throws Exception {
//
//                    HashMap params = new HashMap();
////                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\afif\\IdeaProjects\\pendaftaran_siswa\\report\\invoice.jrxml");
////                    String query = "select * from tb_siswa";
////                    JRDesignQuery updateQuery = new JRDesignQuery();
////                    updateQuery.setText(query);
////                    jdesign.setQuery(updateQuery);
////                    JasperReport jReport = JasperCompileManager.compileReport(jdesign);
//
//                    JasperPrint jp = JasperFillManager.fillReport("report/invoice.jasper",params,Database.getConnection());
//                    JasperViewer viewer = new JasperViewer(jp,false);
//                    viewer.setVisible(true);
//                    return null;
//    }
//    };
//
//    ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(task);
//        service.shutdown();
//    }

//    public void printLaporan(ActionEvent actionEvent) {
//        try {
//            InputStream inputStream = new FileInputStream("./report/transactionReprot.jrxml");
//
//            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
//
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            HashMap parameter = new HashMap();
//
//            JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(Si.getTransactionList());
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, beanDataSource);
//
//            if (jasperPrint != null) {
//                JasperViewer.viewReport(jasperPrint);
//                System.out.println("Printed");
//            } else
//                System.out.println("Not able to print");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
//    }





//    @FXML
//    private void  printLaporan(ActionEvent event){
//        Task<Void> task = new Task<Void>(){
//            @Override
//            protected Void call() throws Exception {
//                try{
//                    HashMap params = new HashMap();
//                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\afif\\IdeaProjects\\pendaftaran_siswa\\report\\invoice.jrxml");
//                    String query = "select * from tb_siswa";
//                    JRDesignQuery updateQuery = new JRDesignQuery();
//                    updateQuery.setText(query);
//                    jdesign.setQuery(updateQuery);
//                    JasperReport jReport = JasperCompileManager.compileReport(jdesign);
//
//                    JasperPrint jp = JasperFillManager.fillReport(jReport,params,Database.getConnection());
//                    JasperViewer.viewReport(jp);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        };
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.execute(task);
//        service.shutdown();
//
//    }


}

