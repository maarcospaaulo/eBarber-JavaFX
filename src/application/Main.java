package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	private static Stage stage;
	private static Stage newStage;
	
	private static Scene loginScene;
	private static Scene menuScene;
	private static Scene cadClienteScene;
	private static Scene cadProdutoScene;
	private static Scene cadServicoScene;
	private static Scene estoqueScene;
	private static Scene vendaScene;
	private static Scene listaClienteScene;
	private static Scene agendaScene;
	private static Scene configScene;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		primaryStage.setTitle("eBarber - Controle de Acesso");
		
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/telaLogin.fxml"));
		loginScene = new Scene(fxmlLogin);
		
		Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/view/telaMenu.fxml"));
		menuScene = new Scene(fxmlMenu);
		
		Parent fxmlCadCliente = FXMLLoader.load(getClass().getResource("/view/telaCadastrarCliente.fxml"));
		cadClienteScene = new Scene(fxmlCadCliente);
		
		Parent fxmlCadProduto = FXMLLoader.load(getClass().getResource("/view/telaCadastrarProduto.fxml"));
		cadProdutoScene = new Scene(fxmlCadProduto);
		
		Parent fxmlCadServico = FXMLLoader.load(getClass().getResource("/view/telaCadastrarServico.fxml"));
		cadServicoScene = new Scene(fxmlCadServico);
		
		Parent fxmlEstoque = FXMLLoader.load(getClass().getResource("/view/telaEstoque.fxml"));
		estoqueScene = new Scene(fxmlEstoque);
		
		Parent fxmlVenda = FXMLLoader.load(getClass().getResource("/view/telaVenda.fxml"));
		vendaScene = new Scene(fxmlVenda);
		
		Parent fxmlAgenda = FXMLLoader.load(getClass().getResource("/view/telaAgendamento.fxml"));
		agendaScene = new Scene(fxmlAgenda);
		
		Parent fxmlListaCliente = FXMLLoader.load(getClass().getResource("/view/telaListaCliente.fxml"));
		listaClienteScene = new Scene(fxmlListaCliente);
		
		Parent fxmlConfig = FXMLLoader.load(getClass().getResource("/view/telaConfiguracao.fxml"));
		configScene = new Scene(fxmlConfig);
		
		stage.setScene(loginScene); // inicia com a cena de login
		stage.show();
	}
	
	public static void mudarTela(String tela)
	{
		switch (tela) {
		
		case "login":
			stage.setScene(loginScene);
			break;
			
		case "menu":
			stage.setTitle("eBarber - Menu");
			stage.setScene(menuScene);
			break;
			
		case "cadCliente":
			newStage();
			newStage.setScene(cadClienteScene);
			newStage.setTitle("eBarber - Cadastrar Cliente");
			newStage.show();
			break;
			
		case "cadProduto":
			newStage();
			newStage.setScene(cadProdutoScene);
			newStage.setTitle("eBarber - Cadastrar Produto");
			newStage.show();
			break;
			
		case "cadServico":
			newStage();
			newStage.setScene(cadServicoScene);
			newStage.setTitle("eBarber - Cadastrar Servico");
			newStage.show();
			break;
			
		case "estoque":
			newStage();
			newStage.setScene(estoqueScene);
			newStage.setTitle("eBarber - Estoque");
			newStage.show();
			break;
			
		case "venda":
			newStage();
			newStage.setScene(vendaScene);
			newStage.setTitle("eBarber - Venda");
			newStage.show();
			break;
			
		case "agenda":
			newStage = new Stage();
			newStage.setScene(agendaScene);
			newStage.setTitle("eBarber - Agendamento");
			newStage.show();
			break;
			
		case "listaCliente":
			newStage();
			newStage.setScene(listaClienteScene);
			newStage.setTitle("eBarber - Lista de Clientes");
			newStage.show();
			break;
			
		case "config":
			newStage();
			newStage.setScene(configScene);
			newStage.setTitle("eBarber - Configuracoes");
			newStage.show();
			break;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	// metodo para criar o novo stage e bloquear o menu
	public static void newStage() {
		
		newStage = new Stage();
		newStage.initModality(Modality.APPLICATION_MODAL);
	}
}
