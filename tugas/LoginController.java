/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    XStream xstream;
    FileInputStream input;
    ArrayList<Daftar> list;
    
    @FXML
    private TextField tfemail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btSignIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      xstream = new XStream(new StaxDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypesByWildcard(new String[]{
            "tugas.*"
        });
        try{
            input = new FileInputStream("Daftar.xml");
            try{
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
        }catch(Exception e){
            
        }
    }    
    

    @FXML
    private void signInAction(ActionEvent event) throws IOException {
        int user = 0;
        boolean cek = false;
        for(Daftar arr:list){
            if(arr.getEmail().equals(tfemail.getText()) && arr.getPassword().equals(tfPassword.getText())){
                Ntah ntah = new Ntah(user);
                Parent beranda = FXMLLoader.load(getClass().getResource("SceneMenu.fxml"));
                Stage stage = (Stage)  btSignIn.getScene().getWindow();
                Scene scene = new Scene(beranda);
                stage.setScene(scene);
                stage.show();
                cek = true;
            }
            user++;
        }
        if(!cek){
            
            Alert warn = new Alert(Alert.AlertType.WARNING);
            warn.setTitle("Salah Lurr!!!!");
            warn.setHeaderText("Email dan password tidak sesuai!");
            warn.setContentText("Ketik yang benerr!!! \nAtau anda belom daftar ????");
            warn.showAndWait();
       
        
        }
    
    }

    @FXML
    private void signUpAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneDaftar.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();   
    }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();   
    }
    }
    
   
    

    

    
    
    
   

