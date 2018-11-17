package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("L")
public class Limpeza extends Funcionario {
	
	private String cargo;
	private int jornada;
	
	@OneToMany(cascade=CascadeType.ALL, targetEntity=Limpeza.class, mappedBy="gerente")
	private List<Limpeza> limpeza;
	
	@ManyToOne
	@JoinColumn(name="gerente_id", nullable=true)
	private Limpeza gerente;
	
	public Limpeza() {}

	public Limpeza (String nome, String endereco, String sexo, String dtAniv, 
			Double salario, Departamento dept_id, List<Dependente> dependentes,
			String cargo, int jornada, Limpeza gerente, List<Limpeza> limpeza) {
		this(0,nome,endereco,sexo,dtAniv,salario,dept_id,dependentes,cargo,jornada,gerente,limpeza);
	}
	
	public Limpeza(int id, String nome, String endereco, String sexo, String dtAniv, 
			Double salario, Departamento dept_id, List<Dependente> dependentes,
			String cargo, int jornada, Limpeza gerente, List<Limpeza> limpeza) {
		super(id,nome,endereco,sexo,dtAniv,salario,dept_id,dependentes);
		this.cargo = cargo;
		this.jornada = jornada;
		this.gerente = gerente;
		this.limpeza = limpeza;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public Limpeza getGerente() {
		return gerente;
	}

	public void setGerente(Limpeza gerente) {
		this.gerente = gerente;
	}

	public List<Limpeza> getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(List<Limpeza> limpeza) {
		this.limpeza = limpeza;
	}

	@Override
	public String toString() {
		return "Limpeza [cargo=" + cargo + ", jornada=" + jornada + 
				", gerente=" + gerente.getId() + ", id=" + id + ", nome=" + nome + 
				", endereco=" + endereco + ", sexo=" + sexo + ", dtAniv="
				+ dtAniv + ", salario=" + salario + "]";
	}

}
