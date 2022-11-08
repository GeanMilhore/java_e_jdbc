package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.loja.virtual.dao.CategoriaDAO;
import br.com.alura.loja.virtual.dao.ProdutoDAO;
import br.com.alura.loja.virtual.modelo.Categoria;
import br.com.alura.loja.virtual.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listar();
			categorias.forEach(ct -> {
				System.out.println(ct.getNome());
				
				try {
					for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}

	}

}
