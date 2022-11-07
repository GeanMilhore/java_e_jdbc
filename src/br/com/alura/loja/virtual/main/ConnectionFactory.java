package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory(){
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("beija!4minha");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource; // com a utilização do pool de conexões o método close() não é mais eficaz/necessário
		
		/**
		 *  não temos o custo de abrir e fechar uma conexão sempre que uma requisição é feita.
		 *   Teremos um número x de conexões abertas no pool e quando vier uma requisição,
		 *    é utilizada uma dessas conexões e na finalização da requisição, a conexão é 
		 *    devolvida para o pool.
		 */
	}
	
	public Connection recuperarConexao() throws SQLException  {
		return this.dataSource.getConnection();
	}
}
