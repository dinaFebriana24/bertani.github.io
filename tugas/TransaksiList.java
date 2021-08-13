/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class TransaksiList {
    private ObservableList<TransaksiProperty> list;
    private String progressFile;
    
    public TransaksiList(){
        list = FXCollections.observableArrayList();
        progressFile = " Transaksi.xml";
    }
    public ObservableList<TransaksiProperty> get(){
        return list;
    }
    public void setArray(Transaksi[] array){
        list = FXCollections.observableArrayList();
        
        for (Transaksi t : array){
            list.add(new TransaksiProperty(t.getKode(), t.getNamaBar(), t.getJumlah(), t.getHarga(), t.getTotal()));
        }
    }
    public void load(){
        try{
            XStream xstream = new XStream(new StaxDriver());
            FileInputStream dataMasuk = new FileInputStream(progressFile);
           int isi;
           char c; 
           String s = "";
           while((isi = dataMasuk.read()) != -1){
                c = (char) isi;
                s = s + c;
        }
            Transaksi[] array = (Transaksi[]) xstream.fromXML(s);
            this.setArray(array);
        }catch (Exception e){
            System.err.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
       
        System.out.println("Data diload");
    }
        
     public Transaksi[] getArray(){
         TransaksiProperty data = new TransaksiProperty();
         
         Transaksi[] array = new Transaksi[list.size()];
         for (int i = 0 ; i < list.size(); i++){
             String kode = list.get(i).getKode();
             String namaBar = list.get(i).getNamaBar();
             int jumlah = list.get(i).getJumlah();
             int harga = list.get(i).getHarga();
             int total = list.get(i).getTotal();
             array[i] = new Transaksi(kode, namaBar, jumlah, harga, total);
         }
         return array;
     }
    public void simpan(){
        //TransaksiList  array = new TransaksiList();
        Transaksi[] array = this.getArray();
        XStream xstream = new XStream(new StaxDriver()); 
        String sxml = xstream.toXML(array);
        System.out.println(array);
   
        try {
            FileOutputStream dataKeluar = new FileOutputStream(progressFile);
            byte[] data = sxml.getBytes("UTF-8");
            dataKeluar.write(data);
            dataKeluar.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println("Tersimpan");
        
    }
    }

