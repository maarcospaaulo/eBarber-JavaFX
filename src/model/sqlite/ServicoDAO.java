package model.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Servico;

public class ServicoDAO extends SQLiteBase{ // herda base para abrir e fechar o banco
	
	public ServicoDAO() {
		
		open();
		
		try {
			PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS SERVICO ("+
					"codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
					"nome TEXT," +
					"preco REAL);");
				
			stm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void create(Servico s) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("INSERT INTO SERVICO (nome, preco) VALUES(?,?);");
			
			stm.setString(1, s.getNome());
			stm.setDouble(2, s.getPreco());

			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void update(Servico s) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("UPDATE SERVICO SET " +
					"nome = ?," +
					"preco = ?" +
					"WHERE codigo = ?;");
			
			stm.setString(1, s.getNome());
			stm.setDouble(2, s.getPreco());
			stm.setInt(3, s.getCodigo());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void delete(Servico s) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("DELETE FROM SERVICO WHERE codigo = ?;");

			stm.setInt(1, s.getCodigo());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
public ArrayList<Servico> all(){
		
		ArrayList<Servico> result = new ArrayList<>();
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM SERVICO;");
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Servico s = new Servico(
						rs.getInt(1), // codigo
						rs.getString(2), // nome
						rs.getFloat(3)); // preco
						
				result.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
