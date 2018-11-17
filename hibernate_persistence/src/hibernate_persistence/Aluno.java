package hibernate_persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("A")
public class Aluno extends Contato{
	private String matricula;
	
	@ManyToMany(mappedBy="alunos")
	private List<Disciplina> disciplinas;

	public Aluno() {}
	
	public Aluno (int id, String nome, String email, Endereco endereco,
			List<Telefone> telefones, String matricula) {
		super(id, nome, email, endereco, telefones);
		this.matricula = matricula;
		this.disciplinas = new ArrayList<>();
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
