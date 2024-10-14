package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.JavaBeans;

public class DAO {

	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/bdagenda";
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
	
	public void inseriContato(JavaBeans jb) {
		String create = "insert into contatos (nome,fone,email) values (?,?,?)";
		try {
			
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, jb.getNome());
			pst.setString(2, jb.getFone());
			pst.setString(3, jb.getEmail());
			
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> contatos =  new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			//o laço abaixo executado enquanto houver contatos
			while(rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			
			con.close();
			return contatos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
}
