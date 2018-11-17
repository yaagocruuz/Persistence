package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.ProjetoDAO;
import br.ufc.quixada.model.JPAUtil;
import br.ufc.quixada.model.Projeto;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO{
	public ProjetoJPADAO() {
		super(Projeto.class);
	}
	
	@Override
	public Projeto findProjById(int id_1) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Projeto.findProjById", Projeto.class)
				.setParameter("id", id_1)
				.getSingleResult();
	}
}
