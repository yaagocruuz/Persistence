package br.ufc.quixada.teste;

import com.datastax.driver.core.exceptions.AlreadyExistsException;

import br.ufc.quixada.client.SimpleClient;

public class Principal {

	public static void main(String args[]) {
		SimpleClient client = new SimpleClient();
		client.Connect("127.0.0.1");
		
		try {
		//client.createSchema();
		} catch (AlreadyExistsException e) {
			System.out.println("Banco já existe.");
		}
		client.loadData();
		client.querySchema();
		client.insertDataPreparedStatement();
		client.close();
		
		System.out.println("FIM");
	}

}
