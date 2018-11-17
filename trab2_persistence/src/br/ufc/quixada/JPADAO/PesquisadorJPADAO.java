package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.PesquisadorDAO;
import br.ufc.quixada.model.Pesquisador;

public class PesquisadorJPADAO extends GenericJPADAO<Pesquisador> implements PesquisadorDAO{

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
	}

}
