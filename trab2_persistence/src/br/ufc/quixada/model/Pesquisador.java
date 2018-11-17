package br.ufc.quixada.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("P")
public class Pesquisador extends Funcionario{
	private String areaAtuacao;
	
	@OneToMany(mappedBy="pesquisador")
	private List<PesquisadorProjeto> projetos;
	
	public Pesquisador() {}
	
	public Pesquisador(int id, String nome, String endereco, String sexo, 
			String dtAniv, Double salario, Departamento dept_id, List<Dependente> dependentes,
			String areaAtuacao, List<PesquisadorProjeto> projetos) {
		super(id,nome,endereco,sexo,dtAniv,salario,dept_id,dependentes);
		this.areaAtuacao = areaAtuacao;
		this.projetos = projetos;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public List<PesquisadorProjeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<PesquisadorProjeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return "Pesquisador [areaAtuacao=" + areaAtuacao + ", projetos="
				+ ", id=" + id +", nome=" + nome + ", endereco=" + endereco
				+ ", sexo=" + sexo + ", dtAniv=" + dtAniv + ", salario="
				+ salario + "]";
	}


	
}
