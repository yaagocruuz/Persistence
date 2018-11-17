package dao;

import hibernate_persistence.Telefone;

public class TelefoneJPADAO extends GenericJPADAO<Telefone> implements TelefoneDAO{

	public TelefoneJPADAO() {
		super(Telefone.class);
		// TODO Auto-generated constructor stub
	}

}
