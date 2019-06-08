package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class telaMenuController {

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoCadastrarProduto;

    @FXML
    private Button botaoNovaVenda;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button botaoEstoque;

    @FXML
    private Button botaoAgendamento;

    @FXML
    private Button botaoListaCliente;

    @FXML
    private Button botaoConfig;

    @FXML
    public void cadastrarClienteClick() throws Exception {
    	
    	Main.mudarTela("cadCliente");
    }

    @FXML
    public void cadastrarProdutoClick() throws Exception {
    	
    	Main.mudarTela("cadProduto");
    }

    @FXML
    public void cadastrarServicoClick() throws Exception {
    	
    	Main.mudarTela("cadServico");

    }

    @FXML
    public void estoqueClick() throws Exception {

    	Main.mudarTela("estoque");
    }

    @FXML
    public void novaVendaClick() throws Exception {

    	Main.mudarTela("venda");
    }
    
    @FXML
    public void agendamentoClick() throws Exception {

    	Main.mudarTela("agenda");
    }
    
    @FXML
    public void listaClienteClick() throws Exception {

    	Main.mudarTela("listaCliente");
    	//telaListaClienteController.atualizaLista();
    }
    
    @FXML
    public void configClick() throws Exception {
    	
    	Main.mudarTela("config");
    }
}
