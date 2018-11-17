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
	@NamedQuery(name="Projeto.findProjById", query = "SELECT p FROM Projeto p WHERE p.id = :id"),
})
public class Projeto implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projeto_id")
	private int id;
	private String nome;
	private int numProj;
	private int tempo;
	
	@ManyToOne
	@JoinColumn(name="dept_id", nullable=false)
	private Departamento departamento;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="projeto")
	private List<PesquisadorProjeto> pesquisadores;
	
	public Projeto() {}

	public Projeto(String nome, int numProj, int tempo, Departamento dept_id, 
			List<PesquisadorProjeto> pesquisadores) {
		this(0,nome,numProj,tempo,dept_id,pesquisadores);
	}

	public Projeto(int id, String nome, int numProj, int tempo, Departamento dept_id, 
			List<PesquisadorProjeto> pesquisadores) {
		this.id = id;
		this.nome = nome;
		this.numProj = numProj;
		this.tempo = tempo;
		this.departamento = dept_id;
		this.pesquisadores = pesquisadores;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumProj() {
		return numProj;
	}
	public void setNumProj(int numProj) {
		this.numProj = numProj;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<PesquisadorProjeto> getPesquisadores() {
		return pesquisadores;
	}

	public void setPesquisadores(List<PesquisadorProjeto> pesquisadores) {
		this.pesquisadores = pesquisadores;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", numProj=" + numProj + ", tempo=" + tempo + ", departamento="
				+ departamento.getId() + ", pesquisadores=" + pesquisadores.toString() + "]";
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
