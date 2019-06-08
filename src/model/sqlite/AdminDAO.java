package model.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Admin;

public class AdminDAO extends SQLiteBase{ // herda sqlitebase
	
	public AdminDAO() {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("CREATE TABLE IF NOT EXISTS ADM ("+
					"id INTEGER PRIMARY KEY AUTOINCREMENT," +
					"usuario TEXT," +
					"senha TEXT);");
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void create(Admin a) {
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("INSERT INTO ADM (USUARIO,SENHA)VALUES(?,?);");
			
			stm.setString(1, a.getUsuario());
			stm.setString(2, a.getSenha());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public ArrayList<Admin> all(){
		
		ArrayList<Admin> result = new ArrayList<>();
		
		open(); // abre o banco
		
		try {
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM ADM;");
			
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				
				Admin a = new Admin(
						rs.getInt(1), // id
						rs.getString(2), // usuario
						rs.getString(3)); // senha
						
				result.add(a);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

}
