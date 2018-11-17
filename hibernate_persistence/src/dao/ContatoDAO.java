package dao;

import java.util.List;

import hibernate_persistence.Contato;

public interface ContatoDAO extends GenericDAO<Contato>{
	
	public List<Contato> findById(int id_1, int id_2);
}
