package br.ufc.quixada.teste;

import java.util.ArrayList;

import br.ufc.quixada.DAO.*;
import br.ufc.quixada.JPADAO.*;
import br.ufc.quixada.model.*;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		//add Dept
		DepartamentoDAO dep = new DepartamentoJPADAO();
		Departamento d1 = new Departamento("CC",1,new ArrayList<>(),new ArrayList<>());
		dep.beginTransaction();
		dep.save(d1);
		dep.commit();
		dep.close();
		
		//add Projeto
		ProjetoDAO proj = new ProjetoJPADAO();
		Projeto pj1 = new Projeto(0, "Persis", 1, 30, d1, new ArrayList<>());
		proj.beginTransaction();
		proj.save(pj1);
		proj.commit();
		proj.close();
		
		//add secretario
		FuncionarioDAO func = new FuncionarioJPADAO();
		Secretario s1 = new Secretario(0, "a", "a", "a", "1.1.1", 1000.0, d1, new ArrayList<>(), "sup");
		func.beginTransaction();
		func.save(s1);
		
		Pesquisador p1 = new Pesquisador(0, "teste", "teste", "a", "1.1.1", 3000.0, d1, new ArrayList<>(), "FBD", new ArrayList<>());
		func.save(p1);
		func.commit();
		func.close();
		
		PesquisadorProjetoDAO ppDao = new PesquisadorProjetoJPADAO();
		PesquisadorProjeto pp = new PesquisadorProjeto(10, p1, pj1);
		ppDao.beginTransaction();
		ppDao.save(pp);
		ppDao.commit();
		ppDao.close();
		
//		//add Dependente
//		DependenteDAO dpd = new DependenteJPADAO(); 
//		Dependente dp1 = new Dependente("teste", "teste", "1.1.1", "irmao", p1);
//		dpd.beginTransaction();
//		dpd.save(dp1);
//		dpd.commit();
		
	}

}
