module com.example.pendaftaran_siswa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    opens com.example.pendaftaran_siswa to javafx.fxml;
    exports com.example.pendaftaran_siswa;
}