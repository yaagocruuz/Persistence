package br.ufc.quixada.models;

public class Pessoa {
	private String nome;
	private int cpf;
	private String dtNasc;
	private String end;

	public Pessoa(String nome, int cpf, String dtNasc, String end) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dtNasc = dtNasc;
		this.end = end;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return nome + "\n" + 
				cpf + "\n" + 
				dtNasc + "\n" + 
				end;
	}
	
}
