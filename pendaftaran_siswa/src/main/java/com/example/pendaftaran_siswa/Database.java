//package com.example.pendaftaran_siswa;
//
//import javafx.beans.binding.Bindings;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.scene.control.cell.PropertyValueFactory;
//
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Database {
//
//    // Replace below database url, username and password with your actual database credentials
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pendaftaran_siswa";
//    private static final String DATABASE_USERNAME = "root";
//    private static final String DATABASE_PASSWORD = "";
////    private static final String INSERT_ACCOUNT_QUERY = "INSERT INTO account (id, username, password, level) VALUES (?, ?, ?, ?)";
//public static final String SELECT_ACCOUNT_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
//
//    public static Connection getConnect() throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pendaftaran_siswa", "root", "");
//        return connection;
//    }
//
//    public int validate (String name, String password) throws SQLException {
////        List<User> users = new ArrayList<>();
//        // Step 1: Establishing a Connection and
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnect();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_QUERY)) {
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            User user = new User();
//
//            if (resultSet.next()) {
//                user.setId(resultSet.getInt(1));
//                user.setUsername(resultSet.getString(2));
//                user.setPassword(resultSet.getString(3));
//                user.setLevel(resultSet.getInt(4));
//            }
//            System.out.println(user.getUsername());
//            if(user.getLevel() == 1){
//                return 1;
//            } else if(user.getLevel() == 2) {
//                return 2;
//            } else {
//                System.out.println("User does not Exists");
//                return 0;
//            }
//        }
//        catch (SQLException e) {
//            printSQLException(e);
//        }
//        return 0;
//    }
//
//    public static Connection getConnection() throws SQLException {
//        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
//        return connection;
//    }
//
//
//
//    public static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                System.out.println("1");
//                e.printStackTrace(System.err);
//                System.out.println("1");
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.out.println("1");
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.out.println("1");
//                System.err.println("Message: " + e.getMessage());
//                System.out.println("1");
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//    public static ObservableList<SiswaModel> getDataSiswa(){
//        ObservableList<SiswaModel> SiswaList = FXCollections.observableArrayList();
//        try {
//            Connection conn = Database.getConnect();
//            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM tb_siswa");
//            while (rs.next()) {
//
//                SiswaList.add(new SiswaModel(
//                        rs.getInt("id"),
//                        rs.getString("nama"),
//                        rs.getString("nisn"),
//                        rs.getString("tempat_lahir"),
//                        rs.getString("tgl_lahir"),
//                        rs.getString("gender"),
//                        rs.getString("kelas"),
//                        rs.getString("alamat")));
//            }
//        } catch (Exception e) {
////            Logger.getLogger(DaftarController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return SiswaList;
//
//
//
//
//
//    }
//}

//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Database {
//        public static Connection getConnect() throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pendaftaran_siswa", "root", "");
//        return connection;
//    }
//    // Replace below database url, username and password with your actual database credentials
//    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pendaftaran_siswa?useSSL=false";
//    private static final String DATABASE_USERNAME = "root";
//    private static final String DATABASE_PASSWORD = "";
//    private static final String SELECT_QUERY = "SELECT * FROM user WHERE username = ? and password = ?";
//
//    public static boolean validate(String username, String password) throws SQLException {
//
//        // Step 1: Establishing a Connection and
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = DriverManager
//                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//
//            System.out.println(preparedStatement);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return true;
//            }
//
//
//        } catch (SQLException e) {
//            // print SQL exception information
//            printSQLException(e);
//        }
//        return false;
//    }
//
//    public static void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//}


package com.example.pendaftaran_siswa;

import java.sql.*;

public class Database {

    // Replace below database url, username and password with your actual database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pendaftaran_siswa?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    //    private static final String INSERT_ACCOUNT_QUERY = "INSERT INTO account (id, username, password, level) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ACCOUNT_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";



    public int login (String username, String password) throws SQLException {
//        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();

            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setLevel(resultSet.getInt(4));
            }
            System.out.println(user.getUsername());
            if(user.getId() == 1){
                return 1;
            } else if(user.getId() == 2) {
                return 2;
            } else {
                System.out.println("User does not Exists");
                return 0;
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

        public static boolean validate(String username, String password) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return false;
    }




    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        return connection;
    }



    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                System.out.println("1");
                e.printStackTrace(System.err);
                System.out.println("1");
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.out.println("1");
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.out.println("1");
                System.err.println("Message: " + e.getMessage());
                System.out.println("1");
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

