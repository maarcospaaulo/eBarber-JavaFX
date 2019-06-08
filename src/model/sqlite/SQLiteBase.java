package model.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteBase { // classe criada somente para abrir e fechar o banco
	
	protected Connection conn;
	
	public Connection open() { // metodo para abrir o banco
		
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() { // metodo para fechar o banco
		
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
