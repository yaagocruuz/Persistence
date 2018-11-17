package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.PesquisadorProjetoDAO;
import br.ufc.quixada.model.JPAUtil;
import br.ufc.quixada.model.PesquisadorProjeto;

public class PesquisadorProjetoJPADAO extends GenericJPADAO<PesquisadorProjeto> implements PesquisadorProjetoDAO{

	public PesquisadorProjetoJPADAO() {
		super(PesquisadorProjeto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PesquisadorProjeto findPesqProjById(int id_pesq, int id_proj) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("PesquisadorProjeto.findPesqProjById", PesquisadorProjeto.class)
				.setParameter("id_1", id_pesq)
				.setParameter("id_2", id_proj)
				.getSingleResult();
	}
	
	@Override
	public PesquisadorProjeto findPesqProjByProjId(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("PesquisadorProjeto.findPesqProjByProjId", PesquisadorProjeto.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
