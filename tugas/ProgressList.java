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
public class ProgressList {
    private ObservableList<ProgressProperty> list;
    private String progressFile;
    
    public ProgressList(){
        list = FXCollections.observableArrayList();
        progressFile = " ProgressData.xml";
    }
    public ObservableList<ProgressProperty> get(){
        return list;
    }
    public void setArray(DataProgressLahan[] array){
        list = FXCollections.observableArrayList();
        
        for (DataProgressLahan d : array){
            list.add(new ProgressProperty(d.getTanggal(), d.getProgress(), d.getRating()));
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
            DataProgressLahan[] array = (DataProgressLahan[]) xstream.fromXML(s);
            this.setArray(array);
        }catch (Exception e){
            System.err.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
       
        System.out.println("Data diload");
    }
        
     public DataProgressLahan[] getArray(){
         ProgressProperty data = new ProgressProperty();
         
         DataProgressLahan[] array = new DataProgressLahan[list.size()];
         for (int i = 0 ; i < list.size(); i++){
             String tanggal = list.get(i).getTanggal();
             String progress = list.get(i).getProgress();
             String rating = list.get(i).getRating();
             array[i] = new DataProgressLahan(tanggal, progress, rating);
         }
         return array;
     }
    public void simpan(){
        //ProgressList  array = new ProgressList();
        DataProgressLahan[] array = this.getArray();
        XStream xstream = new XStream(new StaxDriver()); 
        String sxml = xstream.toXML(array);
       // System.out.println(array);
   
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

   

    
      
    

