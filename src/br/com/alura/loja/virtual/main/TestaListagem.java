package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager
				.getConnection(
					"jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC",
					"root",
					"beija!4minha"); 
		
		Statement stm = con.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
