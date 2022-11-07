package br.com.alura.loja.virtual.main;

import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for ( int i = 0; i < 20; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}
		
		/**
		 * O restante das requisições espera o processamento
		 * da conexões que já ocupam um espaço no Pool de cnxes
		 */
		
	}

}
