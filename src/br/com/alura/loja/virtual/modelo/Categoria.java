package br.com.alura.loja.virtual.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@Override
	public String toString() {
		return "[ ID: "+this.id+", NOME: "+this.nome+" ]";
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}
}
