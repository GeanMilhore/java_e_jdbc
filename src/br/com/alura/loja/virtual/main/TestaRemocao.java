package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = ConnectionFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		// quantas linhas foram modificadas após o stm ser executado
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas que foram modificadas : " + linhasModificadas);
	}

}
