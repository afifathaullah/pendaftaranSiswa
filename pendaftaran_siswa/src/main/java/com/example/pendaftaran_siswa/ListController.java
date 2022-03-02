//package com.example.pendaftaran_siswa;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.sql.*;
//
//public class ListController {
//    //connection acc
//    @FXML
//    private TableView<Siswa> tb_siswa;
//    @FXML
//    private TableColumn<Siswa ,String> colNama;
//    @FXML
//    private TableColumn<Siswa ,String> colKelas;
//    @FXML
//    private TableColumn<Siswa ,String> colNisn;
//    @FXML
//    private TableColumn<Siswa ,String> colGender;
//    @FXML
//    private TableColumn<Siswa ,String> colTempatTgl;
//    @FXML
//    private TableColumn<Siswa ,String> colAlamat;
//
//    public java.sql.Connection getConnection(){
//        Connection conn;
//        try{
//            conn = DriverManager.getConnection(db_url,dbName,dbPass);
//            return conn;
//        } catch (Exception ex) {
//            System.out.println("Error : " + ex.getMessage());
//            return null;
//        }
//    }
//    //call Siswa
//    Siswa siswa = new Siswa();
//    //show table
//    public ObservableList<Siswa> getSiswaList(){
//        ObservableList<Siswa> siswalist = FXCollections.observableArrayList();
//        Connection conn = getConnection();
//        String query = "SELECT * FROM tb_siswa";
//        Statement st;
//        ResultSet rs;
//
//        try{
//            st = conn.createStatement();
//            rs = st.executeQuery(query);
//            Siswa siswa = new Siswa();
//            while(rs.next()){
//                siswa = new Siswa(rs.getString("nama"),rs.getString("nisn"),rs.getString("tempat_lahir"),rs.getString("gender"),rs.getString("kelas"),rs.getString("alamat"));
//                siswalist.add(siswa);
//            }
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return siswalist;
//    }
//    public void showSiswa(){
//        ObservableList<Siswa> list = getSiswaList();
//
//        colNama.setCellValueFactory(new PropertyValueFactory<Siswa, String>("nama"));
//        colNisn.setCellValueFactory(new PropertyValueFactory<Siswa, String>("nisn"));
//        colTempatTgl.setCellValueFactory(new PropertyValueFactory<Siswa, String>("tempat_lahir"));
//        colGender.setCellValueFactory(new PropertyValueFactory<Siswa, String>("gender"));
//        colKelas.setCellValueFactory(new PropertyValueFactory<Siswa, String>("kelas"));
//        colAlamat.setCellValueFactory(new PropertyValueFactory<Siswa, String>("alamat"));
//
//        tb_siswa.setItems(list);
//    }
//    private static String db_url = "jdbc:mysql://localhost:3306/pendaftaran_siswa";
//    private static String dbName = "root";
//    private static String dbPass = "";
//}
