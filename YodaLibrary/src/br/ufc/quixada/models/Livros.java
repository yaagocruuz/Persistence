package br.ufc.quixada.models;

import java.io.Serializable;

public abstract class Livros implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nomeLivro;
	private float valorLivro;
	private int qtdLivro;
	private int isbnLivro;
		
	public Livros(String nomeLivro, float valorLivro, int qtdLivro, int isbnLivro) {
		super();
		this.nomeLivro = nomeLivro;
		this.valorLivro = valorLivro;
		this.qtdLivro = qtdLivro;
		this.isbnLivro = isbnLivro;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public float getValorLivro() {
		return valorLivro;
	}
	public void setValorLivro(float valorLivro) {
		this.valorLivro = valorLivro;
	}
	public int getQtdLivro() {
		return qtdLivro;
	}
	public void setQtdLivro(int qtdLivro) {
		this.qtdLivro = qtdLivro;
	}
	public int getIsbnLivro() {
		return isbnLivro;
	}
	public void setIsbnLivro(int isbnLivro) {
		this.isbnLivro = isbnLivro;
	}
	@Override
	public String toString() {
		return nomeLivro + "\n" + 
				valorLivro + "\n" + 
				qtdLivro + "\n" + 
				isbnLivro;
	}
	
	
}
