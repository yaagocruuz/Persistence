package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.DependenteDAO;
import br.ufc.quixada.model.Dependente;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO{
	public DependenteJPADAO() {
		super(Dependente.class);
	}

}
