package br.com.alura.loja.virtual.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.loja.virtual.dao.CategoriaDAO;
import br.com.alura.loja.virtual.modelo.Categoria;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listarComProdutos();
			categorias.forEach(ct -> {
				System.out.println(ct.getNome());
				
				ct.getProdutos().forEach(p -> System.out.println(ct.getNome() + " - " + p.getNome()));
			});
		}

	}

}
