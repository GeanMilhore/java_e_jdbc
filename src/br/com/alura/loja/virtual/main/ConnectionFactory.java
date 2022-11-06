package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection recuperarConexao() throws SQLException  {
		return DriverManager
		.getConnection(
			"jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimezone=UTC",
			"root",
			"beija!4minha"); 
	}
}
