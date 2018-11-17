package br.ufc.quixada.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.models.Livros;
import br.ufc.quixada.models.Pessoa;
import br.ufc.quixada.models.Venda;

public class Livraria {
	
	List<Pessoa> listaPessoas = new ArrayList<>();
	List<Livros> listaLivros = new ArrayList<>();
	List<Venda> listaVendas = new ArrayList<>();
	
	String livrotxt = "livro.txt";
	String pessoatxt = "pessoa.txt";
	String vendatxt = "venda.txt";
	
	public boolean addCliente(Pessoa cliente) {
		for (Pessoa p : this.listaPessoas) {
			if ( p.getCpf() == cliente.getCpf() ) {
				return false;
			}
		}
		//fazer a adicao no arquivo txt
		//return listaPessoas.add(cliente);
		try {
			OutputStream os = new FileOutputStream(pessoatxt, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(cliente.toString());
			bw.newLine();
			bw.close();
			osw.close();
			os.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean rmCliente(int cpf) {
		System.out.println("Entrei na funcao");
		
		List<Pessoa> aux = new ArrayList<>();
		aux = this.buscarCliente(false);
		for (int i=0; i<aux.size();i++) {
			System.out.println("Entrei no for");
			if (aux.get(i).getCpf() == cpf) {
				aux.remove(i);
				
				System.out.println("Entrei no if");
				
				File file = new File(pessoatxt);
				if (file.exists()) {
					file.delete();
				}
				try {
					OutputStream os = new FileOutputStream(pessoatxt, true);
					OutputStreamWriter osw = new OutputStreamWriter(os);
					BufferedWriter bw = new BufferedWriter(osw);
					
					for (Pessoa pessoa : aux) {
						bw.write(pessoa.toString());
					}
					bw.close();
					osw.close();
					os.close();
					return true;
				}catch(IOException e) {
					e.printStackTrace();
				}
				return false;
			}
		}
		return false;
	}
	
	public List<Pessoa> buscarCliente(boolean cond) {
		try {
			List<Pessoa> aux = new ArrayList<>();
			
			InputStream is = new FileInputStream(pessoatxt);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine();
			
			String nome, end, nasc;
			
			while(linha!=null) {
				Pessoa pessoa = new Pessoa(linha, Integer.parseInt(br.readLine()), 
						br.readLine(), br.readLine());
				aux.add(pessoa);
				linha = br.readLine();
			}
			if(cond) {
				for (Pessoa p : aux) {
					System.out.println(p.toString());
				}
			}
			return aux;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addLivro (Livros livro) {
		//SALVAR NO ARQUIVO
		try {
			//List<Livros> aux = new ArrayList<>();
			//aux = this.buscarLivro(false);
			//}
			OutputStream os = new FileOutputStream(livrotxt, true);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(livro);
			
			oos.close();
			os.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Livros> buscarLivro (boolean cond) {
		List<Livros> aux = new ArrayList<>();
		try {
			InputStream is = new FileInputStream(livrotxt);
			
			while(true) {
				ObjectInputStream ois = new ObjectInputStream(is);
				aux.add((Livros) ois.readObject());
			}
		}  catch (EOFException e2) {
			for(Livros ll : aux) {
				System.out.println(ll.toString());
			}
			return aux;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erro.");
		}
		return aux;
	}
	
	public boolean realizarVenda(Venda venda) {
		try {
			OutputStream os = new FileOutputStream(vendatxt, true);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(venda.toString());
			bw.newLine();
			bw.close();
			osw.close();
			os.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
