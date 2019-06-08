package model.sqlite;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClienteDAO extends SQLiteBase{ // herda a classe Base p abrir o banco

	public ClienteDAO() {
		
		open();
		
		try {
			PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS CLIENTE ("+
					"id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"nome TEXT," +
					"nascimento TEXT," +
					"endereco TEXT," +
					"sexo TEXT," +
					"telefone TEXT);");
				
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void create(Cliente c) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("INSERT INTO CLIENTE (NOME,NASCIMENTO,"
					+ "ENDERECO,SEXO,TELEFONE) VALUES(?,?,?,?,?);");
			
			stm.setString(1, c.getNome());
			stm.setString(2, c.getNascimento());
			stm.setString(3, c.getEndereco());
			stm.setString(4, c.getSexo());
			stm.setString(5, c.getTelefone());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void update(Cliente c) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("UPDATE CLIENTE SET " +
					"nome = ?," +
					"nascimento = ?," +
					"endereco = ?," +
					"sexo = ?," +
					"telefone = ?" +
					"WHERE id = ?;");
			
			stm.setString(1, c.getNome());
			stm.setString(2, c.getNascimento());
			stm.setString(3, c.getEndereco());
			stm.setString(4, c.getSexo());
			stm.setString(5, c.getTelefone());
			stm.setInt(6, c.getId());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	
	public void delete(Cliente c) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("DELETE FROM CLIENTE WHERE id = ?;");

			stm.setInt(1, c.getId());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public List<Cliente>all(){ //++++++++++++++++++++++++++++++++++++++
		
		ArrayList<Cliente> result = new ArrayList<>();
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM CLIENTE;");
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Cliente c = new Cliente(
						rs.getInt(1), // id
						rs.getString(2), // nome
						rs.getString(3), // nasc
						rs.getString(4), // endereco
						rs.getString(5), // sexo
						rs.getString(6)); // telefone
						
				result.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
