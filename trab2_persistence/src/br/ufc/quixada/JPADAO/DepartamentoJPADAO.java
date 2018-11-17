package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.DepartamentoDAO;
import br.ufc.quixada.model.Departamento;
import br.ufc.quixada.model.JPAUtil;

public class DepartamentoJPADAO extends GenericJPADAO<Departamento> implements DepartamentoDAO{
	public DepartamentoJPADAO() {
		super(Departamento.class);
	}
	
	@Override
	public Departamento findDeptById(int id_1) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Departamento.findDeptById", Departamento.class)
				.setParameter("id", id_1)
				.getSingleResult();
	}

}
