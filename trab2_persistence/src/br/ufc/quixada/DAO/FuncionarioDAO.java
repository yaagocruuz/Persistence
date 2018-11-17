package br.ufc.quixada.DAO;

import br.ufc.quixada.model.Funcionario;

public interface FuncionarioDAO extends GenericDAO<Funcionario>{

	public Funcionario findFuncById(int id);
}
