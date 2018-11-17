package br.ufc.quixada.json;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrincipalJson {
	
	public static final String ARQUIVO = "/home/yaagocruuz/Área de Trabalho/Persistencia/arquivo.json";
	
	public static void main(String[] args) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		
//		List<Contato> contatos = new LinkedList<>();
//		contatos.add(new Contato(1, "Lara", "lara@hotmail.com"));
//		contatos.add(new Contato(2, "Maria", "marihta@yahoo.com.br"));
//		contatos.add(new Contato(3, "Luiza", "luiza@bol.br"));
//		mapper.writeValue(new File(ARQUIVO), contatos);
//			
		TypeReference<List<Contato>> mapType = new TypeReference<List<Contato>>() {};
		List<Contato> contatos = mapper.readValue(new File(ARQUIVO), mapType);
		for (Contato c : contatos) System.out.println(c);
		System.out.println("FIM");
	}
}
