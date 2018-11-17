package dao;

import hibernate_persistence.Disciplina;

public class DisciplinaJPADAO extends GenericJPADAO<Disciplina> implements DisciplinaDAO {

	public DisciplinaJPADAO() {
		super(Disciplina.class);
	}

}
