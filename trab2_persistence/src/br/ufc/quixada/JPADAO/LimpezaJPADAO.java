package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.LimpezaDAO;
import br.ufc.quixada.model.Limpeza;

public class LimpezaJPADAO extends GenericJPADAO<Limpeza> implements LimpezaDAO{
	public LimpezaJPADAO() {
		super(Limpeza.class);
	}

}
