package com.example.pendaftaran_siswa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAppplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainAppplication.class.getResource("login.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(MainAppplication.class.getResource("edit_jurusan.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        /*stage.initStyle(StageStyle.UNDECORATED);*/
        stage.setTitle("Pendaftaran Siswa Offline");
        stage.setScene(scene);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch();
    }
}