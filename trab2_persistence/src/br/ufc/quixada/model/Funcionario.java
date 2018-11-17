package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.ufc.quixada.DAO.Bean;

@Entity
@NamedQueries({
	@NamedQuery(name="Funcionario.findFuncById", query = "SELECT f FROM Funcionario f WHERE f.id = :id")
})
public class Funcionario implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="func_id")
	protected int id;
	
	protected String nome;
	protected String endereco;
	protected String sexo;
	protected String dtAniv;
	protected Double salario;
	
	@ManyToOne
	@JoinColumn(name="dept_id", nullable=false)
	private Departamento departamento;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="funcionario")
	private List<Dependente> dependentes;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String endereco, String sexo, 
			String dtAniv, Double salario, Departamento dept_id, 
			List<Dependente> dependentes) {
		this(0,nome,endereco,sexo,dtAniv,salario,dept_id, dependentes);
	}
	
	public Funcionario(int id, String nome, String endereco, String sexo, 
			String dtAniv, Double salario, Departamento dept_id, 
			List<Dependente> dependentes) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dtAniv = dtAniv;
		this.salario = salario;
		this.departamento = dept_id;
		this.dependentes = dependentes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", sexo=" + sexo + ", dtAniv="
				+ dtAniv + ", salario=" + salario + ", departamento=" + departamento.getId() + ", dependentes=" + dependentes.toString()
				+ "]";
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
