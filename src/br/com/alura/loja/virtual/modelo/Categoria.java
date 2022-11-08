package br.com.alura.loja.virtual.modelo;

public class Categoria {
	
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
	private Integer id;
	private String nome;
	
	@Override
	public String toString() {
		return "[ ID: "+this.id+", NOME: "+this.nome+" ]";
	}
}
