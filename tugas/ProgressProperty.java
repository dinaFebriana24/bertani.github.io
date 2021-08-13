/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP
 */
public class ProgressProperty {
    private StringProperty tanggal;
    private StringProperty progress;
    private StringProperty rating;

    public ProgressProperty(String tanggal, String progress, String rating) {
        this.tanggal = new SimpleStringProperty (tanggal);
        this.progress = new SimpleStringProperty (progress);
        this.rating = new SimpleStringProperty (rating);
    }
    public ProgressProperty() {
        this("", "", "");  
    }
    public StringProperty getTanggalProperty(){
         return tanggal;
     }
    public String getTanggal(){
         return this.tanggal.get();
     }
    public void setTanggal(String tanggal){
        this.tanggal.set(tanggal);
    }
    public StringProperty getProgressProperty(){
         return progress;
     }
    public String getProgress(){
         return this.progress.get();
     }
    public void setProgress(String progress){
        this.progress.set(progress);
    }
    public StringProperty getRatingProperty(){
         return rating;
     }
    public String getRating(){
         return this.rating.get();
     }
    public void setRating(String rating){
        this.rating.set(rating);
    }
}
