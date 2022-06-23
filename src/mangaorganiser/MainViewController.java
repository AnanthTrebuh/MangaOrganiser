/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mangaorganiser;

import java.awt.AWTException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import mangaorganiser.model.Menu;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class MainViewController {//implements Initializable {

    @FXML
    private CheckBox rename;
    @FXML
    private TextField chapB;
    @FXML
    private TextField chapE;
    @FXML
    private Text textArea;
    @FXML
    private Button launch;
    @FXML
    private Button quit;
    
    private Menu menu;

    public MainViewController() throws AWTException {
        this.menu = new Menu();
    }

    
    /**
     * Initializes the controller class.
     */
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } */   

    //lance l'application 
    @FXML
    private void launch(ActionEvent event) {
        String textChapB = chapB.getText();
        String textChapE = chapE.getText();
        if(textChapB.equals("") || textChapE.equals("")){
            textArea.setText("Un numéro est attendu pour chaque chapitre");
        }else{
            if(validate(textChapB)){
                if(validate(textChapE)){
                    int intChapB = Integer.parseInt(textChapB);
                    int intChapE = Integer.parseInt(textChapE);
                    if(intChapB < intChapE ){
                        System.out.println("All validate");
                        textArea.setText("");
                        chapB.setStyle("-fx-text-fill: black;");
                        chapE.setStyle("-fx-text-fill: black;");
                        menu.launch(intChapB,intChapE, rename.isSelected());
                    }else{
                        textArea.setText("Chapitre début doit être inférieur à Chapitre fin ");
                        chapB.setStyle("-fx-text-fill: red;");
                        chapE.setStyle("-fx-text-fill: red;");
                    }
                }else {
                    textArea.setText("chapitre fin non valide");
                    chapE.setStyle("-fx-text-fill: red;");
                }            
            }else{
                textArea.setText("chapitre début non valide");
                chapB.setStyle("-fx-text-fill: red;");
            }
        }
    }
    //permet de quitter l'application
    @FXML
    private void quit(ActionEvent event) {
        menu.quit();
    }    
    
    
    //verifie que le text est bien un nombre
    private boolean validate(String text){
        return text.matches("[0-9]*");
    }
}
