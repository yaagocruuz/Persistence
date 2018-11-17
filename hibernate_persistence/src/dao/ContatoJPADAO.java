package dao;

import java.util.List;

import hibernate_persistence.Contato;
import hibernate_persistence.JPAUtil;

public class ContatoJPADAO extends GenericJPADAO<Contato> implements ContatoDAO{
	public ContatoJPADAO() {
		super(Contato.class);
	}

	@Override
	public List<Contato> findById(int id_1, int id_2) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Contato.findById", Contato.class)
				.setParameter("id_1", id_1).setParameter("id_2", id_2)
				.getResultList();
	}
}