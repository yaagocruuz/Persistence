package br.ufc.quixada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.ufc.quixada.DAO.Bean;

@Entity
public class Dependente implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dependente_id")
	private int id;
	private String nome;
	private String sexo;
	private String dtAniv;
	private String grauParent;
	
	@ManyToOne
	@JoinColumn(name="func_id", nullable=false)
	private Funcionario funcionario;
	
	public Dependente() {}
	
	public Dependente(String nome, String sexo, String dtAniv, String grauParent, Funcionario func) {
		this(0,nome,sexo,dtAniv,grauParent,func);
	}
	
	public Dependente(int id, String nome, String sexo, String dtAniv, String grauParent, Funcionario func) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dtAniv = dtAniv;
		this.grauParent = grauParent;
		this.funcionario = func;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDtAniv() {
		return dtAniv;
	}
	public void setDtAniv(String dtAniv) {
		this.dtAniv = dtAniv;
	}
	public Funcionario getFunc() {
		return funcionario;
	}
	public void setFunc(Funcionario func) {
		this.funcionario = func;
	}
	@Override
	public int getId() {
		return this.id;
	}
	@Override
	public void setId(int id) {
		this.id=id;
	}

	public String getGrauParent() {
		return grauParent;
	}

	public void setGrauParent(String grauParent) {
		this.grauParent = grauParent;
	}

	@Override
	public String toString() {
		return "Dependente [id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dtAniv=" + dtAniv + ", grauParent="
				+ grauParent + ", funcionario=" + funcionario.getId() + "]";
	}

	
	
	
}
