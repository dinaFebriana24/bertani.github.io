/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

/**
 *
 * @author HP
 */
public class Transaksi {
    String kode;
    String namaBar;
    Integer jumlah;
    Integer harga;
    Integer total;

    public Transaksi(String kode, String namaBar, Integer jumlah, Integer harga, Integer total) {
        this.kode = kode;
        this.namaBar = namaBar;
        this.jumlah = jumlah;
        this.harga = harga;
        this.total = total;
    }
    public Transaksi() {
        this.kode = " ";
        this.namaBar = " ";
        this.jumlah = 0;
        this.harga = 0;
        this.total = 0;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaBar() {
        return namaBar;
    }

    public void setNamaBar(String namaBar) {
        this.namaBar = namaBar;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
}
