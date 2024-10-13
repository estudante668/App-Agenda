package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/dbagenda";
	private String user = "postgres";
	private String password = "1cbt89q";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//teste
	
	public void texte() {
		try {
			Connection con = conectar();
			System.out.println("Conectado: "+ con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
