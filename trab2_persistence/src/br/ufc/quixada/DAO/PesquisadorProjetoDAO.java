package br.ufc.quixada.DAO;

import br.ufc.quixada.model.PesquisadorProjeto;

public interface PesquisadorProjetoDAO extends GenericDAO<PesquisadorProjeto>{
	public PesquisadorProjeto findPesqProjById(int id_1, int id_2);
	public PesquisadorProjeto findPesqProjByProjId(int id);
}
