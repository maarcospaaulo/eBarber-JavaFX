package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produto;
import model.sqlite.ProdutoDAO;

public class telaEstoqueController {

    @FXML
    private TableView<Produto> tabelaEstoque;

    @FXML
    private Button bt_excluir;

    @FXML
    private Button bt_editar;

    @FXML
    private TextField txt_buscaProduto;

    @FXML
    private Button bt_busca;
    
    @FXML
    private void initialize() {
    	
    	//atualizaLista(); //atualiza a lista toda vez q abrir a tela listaCliente
    }

    @FXML
    void bt_buscaClick(ActionEvent event) {
    	
    	atualizaLista();

    }

    @FXML
    void bt_excluirClick(ActionEvent event) {

    }

    @FXML
    void bt_editarClick(ActionEvent event) {

    }
    
    @SuppressWarnings("unchecked")
	@FXML
    private void atualizaLista() { // atualiza a lista de Clientes
    	
    	ProdutoDAO data = new ProdutoDAO();
    	tabelaEstoque.setItems(FXCollections.observableArrayList(data.all()));

    	TableColumn<Produto, String> colunaCod = new TableColumn<>("Cod");
    	colunaCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	colunaCod.setMinWidth(20);
    	
    	TableColumn<Produto, String> colunaNome = new TableColumn<>("Nome");
    	colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	colunaNome.setMinWidth(135);
    	
    	TableColumn<Produto, String> colunaMarca = new TableColumn<>("Marca");
    	colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    	colunaMarca.setMinWidth(130);
    	
        TableColumn<Produto, String> colunaValid = new TableColumn<>("Validade");
        colunaValid.setCellValueFactory(new PropertyValueFactory<>("validade"));
        colunaValid.setMinWidth(80);
        
        TableColumn<Produto, String> colunaFornecedor = new TableColumn<>("Preco Pago");
        colunaFornecedor.setCellValueFactory(new PropertyValueFactory<>("precoFornecedor"));
        colunaFornecedor.setMinWidth(40);
        
        TableColumn<Produto, String> colunaPrecoVenda = new TableColumn<>("Preco Venda");
        colunaPrecoVenda.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
        colunaPrecoVenda.setMinWidth(40);
        
        tabelaEstoque.getColumns().addAll(colunaCod, colunaNome, colunaMarca, colunaValid, colunaFornecedor, colunaPrecoVenda);
	}
}
