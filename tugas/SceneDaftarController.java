/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SceneDaftarController implements Initializable {

    ArrayList<Daftar> list;
    XStream xstream;
    FileOutputStream output;
    FileInputStream input;
    File d;
    
    @FXML
    private TextField nama1;
    @FXML
    private TextField alamat1;
    @FXML
    private DatePicker dptgl;
    @FXML
    private RadioButton rblaki1;
    @FXML
    private RadioButton rbpr1;
    @FXML
    private ChoiceBox cbprofesi1;
    @FXML
    private TextField tfktp1;
    @FXML
    private TextField tfemail1;
    @FXML
    private TextField tfbpass1;
    @FXML
    private TextField tfkpass1;
    @FXML
    private Button btSignIn;
    
    public boolean isValid() {
        String errorMessage = "";
        
        if (nama1.getText() == null || nama1.getText().length() < 1) {
            errorMessage += "Masukan nama tidak valid \n";
        }
        if (dptgl.getValue() == null ) {
            errorMessage += "Masukan tanggal tidak valid \n";
        }
        if (alamat1.getText() == null || alamat1.getText().length() < 1) {
            errorMessage += "Masukan alamat tidak valid \n";
        }
        if (tfemail1.getText() == null || tfemail1.getText().length() < 1) {
            errorMessage += "Masukan email tidak valid \n";
        }
        if (tfbpass1.getText().equalsIgnoreCase(tfkpass1.getText())) {
        }
        else{
          errorMessage += "Masukan password tidak valid \n";}
        
        if (cbprofesi1.getValue() == null || cbprofesi1.getValue().toString().length() < 1) {
            errorMessage += "Masukan profesi tidak valid \n";
        }
        if (tfktp1.getText() == null || Integer.parseInt(tfktp1.getText()) <= 0) {
            errorMessage += "Masukkan KTP tidak valid \n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Masukan Salah");
            alert.setHeaderText("Masukkan Data dengan Benar!!");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            return false;
        }
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        cbprofesi1.getItems().addAll("Petani", "Guru", "PNS");
        cbprofesi1.setValue("Petani");
        
        list = new ArrayList<>();
        xstream = new XStream(new StaxDriver());
        output = null;
        input = null;
        d = new File("Daftar.xml");
        boolean exist = d.exists();
        if(exist){
            try{
                input = new FileInputStream("Daftar.xml");
                int isi;
                char c;
                String sxml = "";
                while((isi = input.read()) != -1){
                    c = (char) isi;
                    sxml = sxml + c;
                }
                list = (ArrayList<Daftar>) xstream.fromXML(sxml);
            }catch(Exception e){
            }       
             
    }
  
    }
    @FXML
    private void signUp(ActionEvent event){
        if (isValid()){
        String sxml;
        String nama = nama1.getText();
        String alamat = alamat1.getText();
        int ktp = Integer.parseInt(tfktp1.getText());
        String profesi = cbprofesi1.getValue().toString(); 
        LocalDate tanggal = dptgl.getValue() ;
        String jenis = " ";
        if(rblaki1.isSelected()) jenis = " Laki - Laki";
        else if(rbpr1.isSelected()) jenis = " Perempuan "; 
        String email = tfemail1.getText();
        String password, konf;
        password = tfbpass1.getText();
        konf = tfkpass1.getText();
    
        list.add(new Daftar(nama, tanggal, alamat, jenis, profesi, ktp, email, password));
        try{
            output = new FileOutputStream("Daftar.xml");
            sxml = xstream.toXML(list);
            byte[] bytes = sxml.getBytes("UTF-8");
            output.write(bytes);
        }catch(Exception e){
            
        }
        konfirmasiDaftar();
    }
    }
    private void konfirmasiDaftar(){
        Alert confirm = new Alert(Alert.AlertType.INFORMATION);
        confirm.setTitle("Perhatian");
        confirm.setHeaderText("Pendaftaran suksess!!");
        confirm.setContentText("Anda bisa sign in sekarang");
        confirm.showAndWait();
    }

    @FXML
    private void signIn(ActionEvent event) throws IOException {
        Parent beranda = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) btSignIn.getScene().getWindow();
        Scene scene = new Scene(beranda);
        stage.setScene(scene);
        stage.show();
    }
}
        
   


