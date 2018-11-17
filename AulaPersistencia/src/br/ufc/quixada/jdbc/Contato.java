package br.ufc.quixada.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Contato {
	private int id;
	private String nome;
	private int idade;
	private String telefone;
	private String endereco;
	
	public Contato(int id, String nome, int idade, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Contato(ResultSet rs) {
		try {
			this.id = rs.getInt("id");
			this.nome = rs.getString("nome");
			this.idade = rs.getInt(idade);
			this.telefone = rs.getString(telefone);
			this.endereco = rs.getString("endereco");
		}catch(SQLException e) {
			e.printStackTrace();
		}
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", idade=" + idade + ", telefone=" + telefone + ", endereço="
				+ endereco + "]";
	}
	
	

}
