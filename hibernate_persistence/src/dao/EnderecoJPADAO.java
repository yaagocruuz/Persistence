package dao;

import hibernate_persistence.Endereco;

public class EnderecoJPADAO extends GenericJPADAO<Endereco> implements EnderecoDAO{
	public EnderecoJPADAO() {
		super(Endereco.class);
	}

}
