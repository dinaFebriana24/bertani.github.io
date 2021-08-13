/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GrafikController implements Initializable {

    private ProgressList progressList;
    @FXML
    private LineChart < ?, ?> progressChart;
    @FXML
    private NumberAxis y;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.chart();
    }    
     private void chart(){
        XYChart.Series chart = new XYChart.Series<>();
        int rate = 0;
        
        Iterator<DataProgressLahan>dpl;
        List<DataProgressLahan> data = new ArrayList();
        progressList = new ProgressList() ;
        progressList.load();
        
        data = Arrays.asList(progressList.getArray());
        dpl = data.iterator();
            while(dpl.hasNext() == true){
                DataProgressLahan dp = dpl.next();
                if (dp.getRating().length() >= 0 ){
                    rate ++;
            }
            chart.getData().add(new XYChart.Data(" " + dp.getTanggal() ,rate));
            progressChart.getData().addAll(chart);
    }
       }

    @FXML
    private void backAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TableProgress.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        
 }
}
