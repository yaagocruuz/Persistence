package hibernate_persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import dao.Bean;


public class Disciplina implements Bean{

	private int id;
	private String nome;
	private int ch;
	
	@ManyToMany
	@JoinTable(
			name = "aluno_disciplinas",
			joinColumns=@JoinColumn(name="disciplina_id", referencedColumnName="disciplina_id"),
			inverseJoinColumns=@JoinColumn(name="aluno_id", referencedColumnName="contato_id"))
	private List<Aluno> alunos;
	
	public Disciplina() {}
	
	public Disciplina(int id, String nome, int ch) {
		super();
		this.id = id;
		this.nome = nome;
		this.ch = ch;
		this.alunos = new ArrayList<>();
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
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
}
