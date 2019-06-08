package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import model.sqlite.ClienteDAO;

public class telaListaClienteController {

    @FXML
    private TextField txt_buscaCliente;

    @FXML
    private Button bt_buscarCliente;
    
    @FXML
    private TableView<Cliente> tb_Clientes;
    
    @FXML
    private void initialize() {
    	
    	//System.out.println("ATUALIZEI A LISTA");
    	//atualizaLista(); //atualiza a lista toda vez q abrir a tela listaCliente
    }
    // BOTAO BUSCAR CLIENTE
    @FXML
    private void bt_buscarClienteClick(ActionEvent event) {
    	atualizaLista();
    }
    // BOTAO EXCLUIR CLIENTE
    @FXML
    void bt_excluirClick(ActionEvent event) {

    }
    // BOTAO EDITAR CLIENTE
    @FXML
    void bt_editarClick(ActionEvent event) {

    }
    
    @SuppressWarnings("unchecked")
	@FXML
    public void atualizaLista() { // atualiza a lista de Clientes
    	
    	ClienteDAO data = new ClienteDAO();
    	tb_Clientes.setItems(FXCollections.observableArrayList(data.all()));

    	TableColumn<Cliente, String> colunaID = new TableColumn<>("ID");
    	colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaID.setMinWidth(20);
    	
    	TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaNome.setMinWidth(135);
    	
    	TableColumn<Cliente, String> colunaNasc = new TableColumn<>("Data Nasc.");
    	colunaNasc.setCellValueFactory(new PropertyValueFactory<>("nascimento"));
    	colunaNasc.setMinWidth(100);
    	
        TableColumn<Cliente, String> colunaEnd = new TableColumn<>("Endereco");
        colunaEnd.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaEnd.setMinWidth(135);
        
        TableColumn<Cliente, String> colunaSexo = new TableColumn<>("Sexo");
        colunaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colunaSexo.setMinWidth(20);
        
        TableColumn<Cliente, String> colunaTel = new TableColumn<>("Telefone");
        colunaTel.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaTel.setMinWidth(90);
        
        tb_Clientes.getColumns().addAll(colunaID, colunaNome, colunaNasc, colunaEnd, colunaSexo, colunaTel);
	}
}
