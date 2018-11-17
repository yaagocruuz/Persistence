package br.ufc.quixada.models;

public class Venda {
	private int id;
	private String nome;
	private int isbn;
	private float valor;
	private String livro;
	
	public Venda(int id, String nome, int isbn) {
		super();
		this.id = id;
		this.nome = nome;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", nome=" + nome + ", isbn=" + isbn + ", valor=" + valor + "]";
	}
	
	

}
