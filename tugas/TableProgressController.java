/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TableProgressController implements Initializable {

    @FXML
    private TableView<ProgressProperty> tv;
    @FXML
    private TableColumn<ProgressProperty, String> tcTanggal;
    @FXML
    private TableColumn<ProgressProperty, String> tcProgress;
    @FXML
    private TableColumn<ProgressProperty, String> tckemajuan;
    @FXML
    private Button btTambah;
    @FXML
    private Button btHapus;
    @FXML
    private Button btLihatGrafik;
    @FXML
    private Button btNext;
    @FXML
    private Button btBack;
    @FXML
    private DatePicker dptgl;
    @FXML
    private TextField tfprogress;
    @FXML
    private TextField tfrating;
    
    /**
     * Initializes the controller class.
     */
    private ProgressList progressList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        
        progressList = new ProgressList();
        progressList.load();
        tv.setItems(progressList.get());
        
        tcTanggal.setCellValueFactory(cellData -> cellData.getValue().getTanggalProperty());
        tcProgress.setCellValueFactory(cellData -> cellData.getValue().getProgressProperty());
        tckemajuan.setCellValueFactory(cellData -> cellData.getValue().getRatingProperty());
        
        tv.setEditable(true);
        tcTanggal.setCellFactory(TextFieldTableCell.forTableColumn());
        tcProgress.setCellFactory(TextFieldTableCell.forTableColumn());
        tckemajuan.setCellFactory(TextFieldTableCell.forTableColumn());
    }    
    
   
    @FXML
    private void Tambah(ActionEvent event) {
        LocalDate tanggal = null;
        tfprogress.setText(" ");
        dptgl.setValue(tanggal);
        tfrating.setText(" ");
          
    }

    @FXML
    private void hapus(ActionEvent event) {
        int selected = tv.getSelectionModel().getSelectedIndex();
        if (selected >=0){
            tv.getItems().remove(selected);
        }
        progressList.simpan();
    }

    @FXML
    private void editTanggal(TableColumn.CellEditEvent<ProgressProperty, String> editTanggal) {
        ProgressProperty progress = tv.getSelectionModel().getSelectedItem();
        progress.setTanggal(editTanggal.getNewValue());
        
        progressList.simpan();
    }
    
    @FXML
    private void editProgress(TableColumn.CellEditEvent<ProgressProperty, String> editProgress) {
        ProgressProperty progress = tv.getSelectionModel().getSelectedItem();
        progress.setProgress(editProgress.getNewValue());
        progressList.simpan();
    }
    @FXML
    private void editRating(TableColumn.CellEditEvent<ProgressProperty, String> editRating) {
        ProgressProperty progress = tv.getSelectionModel().getSelectedItem();
        progress.setRating(editRating.getNewValue());
        
        progressList.simpan();
    }

    @FXML
    private void lihatgrafik(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Grafik.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
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
    private void ntah(ActionEvent event){
        ProgressProperty progress = new ProgressProperty();    
        progress.setProgress(tfprogress.getText());
        progress.setTanggal(dptgl.getValue().toString());
        progress.setRating(tfrating.getText());    
        
        tv.getItems().add(progress);
        progressList.simpan();
       
 
}
}
