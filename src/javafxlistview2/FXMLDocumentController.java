/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlistview2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Sagar
 */
public class FXMLDocumentController implements Initializable {
    
 @FXML
    private ListView<String> listview1;

 @FXML
    private ListView<String> listview2;
 
 @FXML
    private Button ltor;
 
 @FXML
    private Button rtol;
 
 @FXML
    private Label label;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private ChoiceBox choicebox;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        //System.out.println("You clicked me!");
        label.setText("Clicked Left to Right...");
    }
    
}
