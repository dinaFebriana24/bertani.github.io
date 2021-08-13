/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TokoController implements Initializable {

    @FXML
    private Button chatt3;
    @FXML
    private Button chatt31;
    @FXML
    private Button chatt32;
    @FXML
    private Pane pane2;
    @FXML
    private Button kirim;
    @FXML
    private TextField tfpesan; 
    @FXML
    private Button kirim1;
    @FXML
    private Button btBack;
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane2.setVisible(false);
        // TODO
    }    


    @FXML
    private void chatt(ActionEvent event) {
        pane2.setVisible(true);
    }

    @FXML
    private void aksiKirim(ActionEvent event) {
        try {
            String pesan = tfpesan.getText();
            if(tfpesan.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle ("Maaf!");
            alert.setHeaderText("Tidak ada pesan yang diketik untuk dikirim!");
            alert.setContentText("Ketik dulu suatu pesan baru kirim");
            alert.showAndWait();
       
       }else{
            JOptionPane.showMessageDialog(null, "Pesan telah dikirim");
            }
        }       
       catch (Exception e){
            e.printStackTrace();
            }
        }
    @FXML
    private void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMenu.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    

    @FXML
    private void closeChatt(ActionEvent event) {
         pane2.setVisible(false);
    }

    
}
