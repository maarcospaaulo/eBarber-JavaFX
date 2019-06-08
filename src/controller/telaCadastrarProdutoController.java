package controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Produto;
import model.sqlite.ProdutoDAO;

public class telaCadastrarProdutoController {

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_marca;

    @FXML
    private DatePicker dt_validade;

    @FXML
    private TextField txt_precoPago;

    @FXML
    private TextField txt_precoVenda;

    @FXML
    private Button bt_limpar;

    @FXML
    private Button bt_concluir;

    @FXML
    void bt_concluirClick(ActionEvent event) {
    	
    	LocalDate ld = dt_validade.getValue();
    	
    	Produto p = new Produto(
    			txt_nome.getText(),
    			txt_marca.getText(),
    			ld.toString(),
    			Double.parseDouble(txt_precoPago.getText()),
    			Double.parseDouble(txt_precoVenda.getText()));
    	
    	ProdutoDAO data = new ProdutoDAO();
    	data.create(p);
    }

    @FXML
    void bt_limparClick(ActionEvent event) {

    }

}
