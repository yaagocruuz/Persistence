package br.ufc.quixada.serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Teste {

	public static final String ARQUIVO = "/home/yaagocruuz/Área de Trabalho/persistencia/animal.txt";
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		/*Animal a = new Animal("Wendeu", "ser humano", "preto", 21);
		OutputStream os = new FileOutputStream(ARQUIVO);
		ObjectOutputStream out = new ObjectOutputStream(os);
		out.writeObject(a);
		out.close();
		os.close();
		System.out.println("Objeto serializado"); */
		
		InputStream is = new FileInputStream(ARQUIVO);
		ObjectInputStream in = new ObjectInputStream(is);
		
		Animal a = (Animal) in.readObject();
		in.close();
		is.close();
		System.out.println(a);
		System.out.println("Objeto Deserializado");
	}

}
