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
public class DataProgressLahan {
    private String tanggal;
    private String progress;
    private String rating;

    public DataProgressLahan(String tanggal, String progress, String rating) {
        this.tanggal = tanggal;
        this.progress = progress;
        this.rating = rating;
    }
     public DataProgressLahan() {
        this.tanggal = "";
        this.progress = "";
        this.rating = "" ;
     }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
 
    @Override
    public String toString() {
        return "DataProgressLahan{" + "tanggal=" + tanggal + ", progress=" + progress + ", rating=" + rating + '}';
    }

    
     
}
