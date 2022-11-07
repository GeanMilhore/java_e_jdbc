package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Connection con = ConnectionFactory.recuperarConexao();
		
		Integer idRemocao = 2;
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, idRemocao);
		
		stm.execute();
		
		// quantas linhas foram modificadas após o stm ser executado
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas que foram modificadas : " + linhasModificadas);
	}

}
