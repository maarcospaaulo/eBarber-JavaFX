package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

public class telaLoginController {

    @FXML
    private TextField usuario;

    @FXML
    private TextField senha;
    
    @FXML
    private Button botaoEntrar;

    @FXML
    private Hyperlink esqueci;

    @FXML
    public void entrarClick() throws Exception {
    	
    		Main.mudarTela("menu");
    }

    @FXML
    void esqueciClick(ActionEvent event) {

    }

}
