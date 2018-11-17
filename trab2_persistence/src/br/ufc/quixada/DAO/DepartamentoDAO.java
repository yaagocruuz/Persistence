package br.ufc.quixada.DAO;

import br.ufc.quixada.model.Departamento;

public interface DepartamentoDAO extends GenericDAO<Departamento>{
	
	public Departamento findDeptById(int id_1);
}
