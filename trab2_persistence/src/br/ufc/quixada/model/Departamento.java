package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.ufc.quixada.DAO.Bean;

@Entity
@NamedQueries({
	@NamedQuery(name="Departamento.findDeptById", query="SELECT d FROM Departamento d WHERE d.id = :id"),
})
public class Departamento implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	private int id;
	
	private String nome;
	private int numDept;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departamento")
	private List<Projeto> projetos;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departamento")
	private List<Funcionario> funcionarios;
	
	public Departamento() {}
	
	public Departamento(String nome, int numDept, List<Projeto> projetos, List<Funcionario> funcionarios) {
		this(0,nome,numDept,projetos,funcionarios);
	}
	
	public Departamento(int id, String nome, int numDept, List<Projeto> projetos, List<Funcionario> funcionarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.numDept = numDept;
		this.projetos = projetos;
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumDept() {
		return numDept;
	}

	public void setNumDept(int numDept) {
		this.numDept = numDept;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", numDept=" + numDept + ", projetos=" + projetos.toString()
				+ ", funcionarios=" + funcionarios.toString() + "]";
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
