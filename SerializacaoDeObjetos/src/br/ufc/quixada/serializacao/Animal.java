package br.ufc.quixada.serializacao;

import java.io.Serializable;

public class Animal implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private transient String nome;
	private String especie;
	private String cor;
	private int idade;
	
	public Animal(String nome, String especie, String cor, int idade) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.cor = cor;
		this.idade = idade;
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", cor=" + cor + ", idade=" + idade + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
