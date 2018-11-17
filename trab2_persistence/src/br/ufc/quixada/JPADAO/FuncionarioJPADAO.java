package br.ufc.quixada.JPADAO;

import br.ufc.quixada.DAO.FuncionarioDAO;
import br.ufc.quixada.model.Funcionario;
import br.ufc.quixada.model.JPAUtil;

public class FuncionarioJPADAO extends GenericJPADAO<Funcionario> implements FuncionarioDAO{
	public FuncionarioJPADAO() {
		super(Funcionario.class);
	}

	@Override
	public Funcionario findFuncById(int id) {
		return JPAUtil.getEntityManager()
				.createNamedQuery("Funcionario.findFuncById", Funcionario.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	
}
