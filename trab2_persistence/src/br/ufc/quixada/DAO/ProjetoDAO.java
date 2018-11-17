package br.ufc.quixada.DAO;

import br.ufc.quixada.model.Projeto;

public interface ProjetoDAO extends GenericDAO<Projeto>{

	public Projeto findProjById(int id_1);
}
