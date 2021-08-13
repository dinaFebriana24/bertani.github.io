/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Daftar {
    private String nama;
    private LocalDate tanggal;
    private String alamat;
    private String jenis;
    private String profesi;
    private Integer ktp;
    private String email;
    private String password;

    public Daftar(String nama, LocalDate tanggal, String alamat, String jenis, String profesi, int ktp, String email, String password) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.alamat = alamat;
        this.jenis = jenis;
        this.profesi = profesi;
        this.ktp = ktp;
        this.email = email;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }

    public int getKtp() {
        return ktp;
    }

    public void setKtp(int ktp) {
        this.ktp = ktp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}
