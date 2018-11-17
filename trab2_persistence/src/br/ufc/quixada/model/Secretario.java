package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Secretario extends Funcionario{

	private String grauEscolaridade;

	public Secretario() {}
		
	public Secretario(int id, String nome, String endereco, String sexo, String dtAniv, 
			Double salario, Departamento dept_id, List<Dependente> dependentes, 
			String grauEscolaridade) {
		super(id,nome,endereco,sexo,dtAniv,salario,dept_id,dependentes);
		this.grauEscolaridade = grauEscolaridade;
	}

	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}

	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}

	@Override
	public String toString() {
		return "Secretario [grauEscolaridade=" + grauEscolaridade + ", id=" + id + ", nome=" + nome + ", endereco="
				+ endereco + ", sexo=" + sexo + ", dtAniv=" + dtAniv + ", salario=" + salario + "]";
	}
	
	
}
