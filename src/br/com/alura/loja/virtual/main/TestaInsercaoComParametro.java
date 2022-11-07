package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = ConnectionFactory.recuperarConexao();) {

			connection.setAutoCommit(false);
			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
				adicionarVariavel("SmartTv", "45 polegadas", stm);
				adicionarVariavel("Rádio", "rádio de bateria", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback Executado");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		if (nome.equals("Rádio")) {
			throw new RuntimeException("Não foi possível adicionar o seu produto");
		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}
	}

}
