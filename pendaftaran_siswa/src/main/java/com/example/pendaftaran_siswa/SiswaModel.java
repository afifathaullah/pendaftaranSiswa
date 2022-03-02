package com.example.pendaftaran_siswa;

import javafx.beans.property.StringProperty;

public class SiswaModel {
    private int id, nomer;
    private String lolos, nama, nisn, tempat_lahir, tgl_lahir, gender, kelas, alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public String getLolos() {
        return lolos;
    }

    public void setLolos(String lolos) {
        this.lolos = lolos;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public SiswaModel(int id, int nomer, String lolos, String nama, String nisn, String tempat_lahir, String tgl_lahir, String gender, String kelas, String alamat) {
        this.id = id;
        this.nomer = nomer;
        this.lolos = lolos;
        this.nama = nama;
        this.nisn = nisn;
        this.tempat_lahir = tempat_lahir;
        this.tgl_lahir = tgl_lahir;
        this.gender = gender;
        this.kelas = kelas;
        this.alamat = alamat;
    }
}