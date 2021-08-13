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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TransaksiController implements Initializable {

    @FXML
    private TableView<TransaksiProperty> tvTransaksi;
    @FXML
    private TableColumn<TransaksiProperty, String> tcKode;
    @FXML
    private TableColumn<TransaksiProperty, String> tcNama;
    @FXML
    private TableColumn<TransaksiProperty, Integer> tcJumlah;
    @FXML
    private TableColumn<TransaksiProperty, Integer> tcHarga;
    @FXML
    private TableColumn<TransaksiProperty, Integer> tcTotal;
    @FXML
    private TextField tfKode;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfJumlah;
    @FXML
    private TextField tfHarga;
    @FXML
    private Button btBeli;
    

   
    private TransaksiList transaksiList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        transaksiList = new TransaksiList();
        transaksiList.load();
        tvTransaksi.setItems(transaksiList.get());
        
        tcKode.setCellValueFactory(cellData -> cellData.getValue().getKodeProperty());
        tcNama.setCellValueFactory(cellData -> cellData.getValue().getNamaBarProperty());
        tcJumlah.setCellValueFactory(cellData -> cellData.getValue().getJumlahProperty().asObject());
        tcHarga.setCellValueFactory(cellData -> cellData.getValue().getHargaProperty().asObject());
        tcTotal.setCellValueFactory(cellData -> cellData.getValue().getTotalProperty().asObject());
        
    }
    public int setTotal() {
        int jumlah = Integer.parseInt(tfJumlah.getText());
        int total ;
        int harga = Integer.parseInt(tfHarga.getText());
        
        total = jumlah * harga;
        
        return total;
    }
 
    @FXML
    private void remove(ActionEvent event) {
        
        int selected = tvTransaksi.getSelectionModel().getSelectedIndex();
        if (selected >=0){
            tvTransaksi.getItems().remove(selected);
        transaksiList.simpan();
    }
    }
    @FXML
    private void Beli(ActionEvent event) {

        TransaksiProperty transaksi = new TransaksiProperty(); 
        transaksi.setKode(tfKode.getText());
        transaksi.setNamaBar(tfNama.getText());
        transaksi.setJumlah(Integer.parseInt(tfJumlah.getText()));
        transaksi.setHarga(Integer.parseInt(tfHarga.getText()));
        transaksi.setTotal(setTotal());
        if(tfKode.getText().equals("") || tfNama.getText().equals("")|| tfHarga.getText().equals(0)|| tfJumlah.getText().equals(0)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle ("Maaf!");
            alert.setHeaderText("Tidak boleh ada satu datapun yang kosong");
            alert.showAndWait();
       
       }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle ("Perhatian!!");
            alert.setHeaderText("Bayar secepatnya!!!!");
            alert.setContentText("Total yang harus dibayar sudah tertera di table kolom total");
            alert.showAndWait();
            }
        
        tvTransaksi.getItems().add(transaksi);
        transaksiList.simpan();
           }
     @FXML
    private void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneMenu.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    
    }
}
