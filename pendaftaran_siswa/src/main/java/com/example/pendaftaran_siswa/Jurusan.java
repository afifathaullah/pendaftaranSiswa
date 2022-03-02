package com.example.pendaftaran_siswa;

public class Jurusan {
    int id,nomor;
    String jurusan,waktu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public Jurusan(int id, int nomor, String jurusan, String waktu) {
        this.id = id;
        this.nomor = nomor;
        this.jurusan = jurusan;
        this.waktu = waktu;
    }
}
