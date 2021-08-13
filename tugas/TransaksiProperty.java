/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP
 */
public class TransaksiProperty {
    private StringProperty kode;
    private StringProperty namaBar;
    private IntegerProperty jumlah;
    private IntegerProperty harga;
    private IntegerProperty total;

    public TransaksiProperty(String kode, String namaBar, int jumlah, int harga, int total) {
        this.kode = new SimpleStringProperty (kode);
        this.namaBar = new SimpleStringProperty (namaBar);
        this.jumlah =  new SimpleIntegerProperty (jumlah);
        this.harga = new SimpleIntegerProperty (harga);
        this.total =  new SimpleIntegerProperty (total);
    }
    public TransaksiProperty() {
        this (" ", " ", 0, 0, 0);
    }
    public StringProperty getKodeProperty(){
         return kode;
     }
    public String getKode(){
         return this.kode.get();
     }
    public void setKode(String kode){
        this.kode.set(kode);
    }
    public StringProperty getNamaBarProperty(){
         return namaBar;
     }
    public String getNamaBar(){
         return this.namaBar.get();
     }
    public void setNamaBar(String namaBar){
        this.namaBar.set(namaBar);
    }
    public IntegerProperty getJumlahProperty(){
         return jumlah;
     }
    public int getJumlah(){
         return this.jumlah.get();
     }
    public void setJumlah (int jumlah){
        this.jumlah.set(jumlah);
    }
    public IntegerProperty getHargaProperty(){
         return harga;
     }
    public int getHarga(){
         return this.harga.get();
     }
    public void setHarga (int harga){
        this.harga.set(harga);
    }
    public IntegerProperty getTotalProperty(){
         return total;
     }
    public int getTotal(){
         return this.total.get();
     }
    public void setTotal (int total){
        this.total.set(total);
    }
}
