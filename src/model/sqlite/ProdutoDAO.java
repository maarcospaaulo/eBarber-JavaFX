package model.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Produto;

public class ProdutoDAO extends SQLiteBase{ // herda base para abrir e fechar o banco
	
	public ProdutoDAO() {
		
		open();
		
		try {
			PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS PRODUTO ("+
					"codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
					"nome TEXT," +
					"marca TEXT," +
					"validade DATE," +
					"precoFornecedor REAL," +
					"precoVenda REAL);");
				
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void create(Produto p) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome,marca,"
					+ "validade,precoFornecedor,precoVenda) VALUES(?,?,?,?,?);");
			
			stm.setString(1, p.getNome());
			stm.setString(2, p.getMarca());
			stm.setString(3, p.getValidade());
			stm.setDouble(4, p.getPrecoFornecedor());
			stm.setDouble(5, p.getPrecoVenda());

			stm.executeUpdate();
			
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Cadastro Realizado");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Produto cadastrado com sucesso !!!");
	    	alert.showAndWait();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("ERRO");
	    	alert.setHeaderText("ERRO AO SALVAR");
	    	alert.setContentText("Produto não cadastrado !!!");
	    	alert.showAndWait();
		} finally {
			close();
		}
	}
	
	public void update(Produto p) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("UPDATE PRODUTO SET " +
					"nome = ?," +
					"marca = ?," +
					"validade = ?," +
					"precoFornecedor = ?," +
					"precoVenda = ?" +
					"WHERE codigo = ?;");
			
			stm.setString(1, p.getNome());
			stm.setString(2, p.getMarca());
			stm.setString(3, p.getValidade());
			stm.setDouble(4, p.getPrecoFornecedor());
			stm.setDouble(5, p.getPrecoVenda());
			stm.setInt(6, p.getCodigo());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void delete(Produto p) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("DELETE FROM PRODUTO WHERE codigo = ?;");

			stm.setInt(1, p.getCodigo());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
public ArrayList<Produto> all(){
		
		ArrayList<Produto> result = new ArrayList<>();
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM PRODUTO;");
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Produto p = new Produto(
						rs.getInt(1), // id
						rs.getString(2), // nome
						rs.getString(3), // marca
						rs.getString(4), // validade
						rs.getFloat(5), // precoForcedor
						rs.getFloat(6)); // precoVenda
						
				result.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
