package controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;
import model.sqlite.ClienteDAO;

public class telaCadastrarClienteController {

	@FXML
    private TextField txt_nome;
	
    @FXML
    private DatePicker txt_dataNasc;

    @FXML
    private TextField txt_endereco;
    
    @FXML
    private TextField txt_sexo;

    @FXML
    private TextField txt_telefone;
    
    @FXML
    private Button btn_limpar;

    @FXML
    private Button bt_salvar;

    @FXML
    private void btn_limparClick(ActionEvent event) {
    	
    	txt_nome.setText("");
    	txt_endereco.setText("");
    	txt_sexo.setText("");
    	txt_telefone.setText("");
    }

    @FXML
    private void bt_salvarClick(ActionEvent event) {
    	
    	try {
    		
    		if(txt_nome.getText().isEmpty()) {
    			throw new RuntimeException("O campo nome não pode ser vazio !");
    		}
    		if(txt_endereco.getText().isEmpty()) {
    			throw new RuntimeException("O campo endereco não pode ser vazio !");
    		}
    		if(txt_sexo.getText().isEmpty()) {
    			throw new RuntimeException("O campo sexo não pode ser vazio !");
    		}
    		
	    	LocalDate ld = txt_dataNasc.getValue(); // pega o valor da data
	        Cliente c = new Cliente( // cria um obj cliente
	        		txt_nome.getText(),
	        		ld.toString(),
	        		txt_endereco.getText(),
	        		txt_sexo.getText(),
	        		txt_telefone.getText());
	        	
	        ClienteDAO database = new ClienteDAO(); // cria o obj clienteDAO
	    	database.create(c); // insere no banco
	    	
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Cadastro Realizado");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Cliente cadastrado com sucesso !!!");
	    	alert.showAndWait();
    	
    	}catch (RuntimeException ex) {
    		
    		Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("ERRO");
	    	alert.setHeaderText("ERRO AO CRIAR CLIENTE");
	    	alert.setContentText(ex.getMessage());
	    	alert.showAndWait();
    	}
    }
}
