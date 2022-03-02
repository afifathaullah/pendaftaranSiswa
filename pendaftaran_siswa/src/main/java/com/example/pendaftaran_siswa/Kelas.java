package com.example.pendaftaran_siswa;

public class Kelas {
    int id;
    String Kelas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKelas() {
        return Kelas;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public Kelas(int id, String kelas) {
        this.id = id;
        Kelas = kelas;
    }
}
