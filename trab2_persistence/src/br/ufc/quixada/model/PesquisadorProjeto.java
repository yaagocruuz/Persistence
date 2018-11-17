package br.ufc.quixada.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.ufc.quixada.DAO.Bean;

@Entity
@NamedQueries({
	@NamedQuery(name="PesquisadorProjeto.findPesqProjById", 
			query = "SELECT pp FROM PesquisadorProjeto pp WHERE pp.pesquisador = :id_1 AND pp.projeto = :id_2"),
	@NamedQuery(name="PesquisadorProjeto.findPesqProjByProjId", 
	query = "SELECT pp FROM PesquisadorProjeto pp WHERE pp.projeto = :id")
})
public class PesquisadorProjeto implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProjPesq_id")
	private int id;
	
	private int horasTrab;
	
	@ManyToOne
	@JoinColumn(name="pesquisador_id", nullable=false)
	private Pesquisador pesquisador;
	
	@ManyToOne
	@JoinColumn(name="projeto_id", nullable=false)
	private Projeto projeto;

	public PesquisadorProjeto() {}
	
	public PesquisadorProjeto(int horasTrab, Pesquisador pesquisador, Projeto projeto) {
		this(0, horasTrab, pesquisador, projeto);
	}
	public PesquisadorProjeto(int id, int horasTrab, Pesquisador pesquisador, Projeto projeto) {
		this.id = id;
		this.horasTrab = horasTrab;
		this.pesquisador = pesquisador;
		this.projeto = projeto;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorasTrab() {
		return horasTrab;
	}

	public void setHorasTrab(int horasTrab) {
		this.horasTrab = horasTrab;
	}

	public Pesquisador getPesquisador() {
		return this.pesquisador;
	}

	public void setPesquisador(Pesquisador funcionario) {
		this.pesquisador = funcionario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public String toString() {
		return "PesquisadorProjeto [id=" + id + ", horasTrab=" + horasTrab + ", pesquisador=" + pesquisador.getId()
				+ ", projeto=" + projeto.getId() + "]";
	}
	
	
}
