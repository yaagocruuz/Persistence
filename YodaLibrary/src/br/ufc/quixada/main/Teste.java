package br.ufc.quixada.main;

import java.util.Scanner;

import br.ufc.quixada.controllers.Livraria;
import br.ufc.quixada.models.LivroAventura;
import br.ufc.quixada.models.LivroComedia;
import br.ufc.quixada.models.LivroDrama;
import br.ufc.quixada.models.Pessoa;
import br.ufc.quixada.models.Venda;

public class Teste {

	public static void main(String[] args) {
		// Iniciar uma biblioteca
		Livraria l1 = new Livraria();
		
/*		//Iniciar os livros
		LivroAventura la = new LivroAventura("aventura agora", 10, 1, 1234);
		LivroComedia lc = new LivroComedia("comedia comedia", 5, 2, 1123);
		LivroDrama ld = new LivroDrama("shakespeare", 30, 10, 1);
		
		//Iniciar pessoas
		Pessoa p1 = new Pessoa("yago", 1234, "16.09", "rua oscar");
		Pessoa p2 = new Pessoa("Gi", 1234, "31.03", "Rua Baia");*/
		
		//TODO switch case para adc/rmv pessoas && adc/rmv livro && salvar em arquivo
		
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		String opt = "-1";
		
		while(!opt.equals("0")) {
			System.out.println("1.Cadastrar um novo Livro de Aventura."); //FEITO
			System.out.println("2.Cadastrar um novo Livro de Comédia."); //FEITO
			System.out.println("3.Cadastrar um novo Livro de Drama."); //FEITO
			System.out.println("4.Buscar Clientes"); //FEITO
			System.out.println("5.Buscar Livros."); //FEITO
			System.out.println("7.Realizar Venda.");
			System.out.println("8.Cadastrar Cliente."); //FEITO
			System.out.println("9.Excluir um Cliente."); //FEITO
			System.out.println("0.Sair.");
			
			opt = scanner.next();
			
			switch(opt) {
			case "1":{
				int isbn; 
				String titulo; 
				float valor;
				
				System.out.println("titulo do livro:");
				titulo = scanner.next();
				System.out.println("valor do livro:");
				valor = scanner2.nextFloat();
				System.out.println("isbn do livro:");
				isbn = scanner.nextInt();
				
				LivroAventura livro = new LivroAventura(titulo, valor, 1, isbn);				
				if(l1.addLivro(livro)) {
					System.out.println("\nLivro cadastrado.\n");
				}else {
					System.out.println("\nErro.\n");
				}				
				break;
			
			}case "2":{
				int isbn; 
				String titulo; 
				float valor;
				
				System.out.println("titulo do livro:");
				titulo = scanner.next();
				System.out.println("valor do livro:");
				valor = scanner.nextFloat();
				System.out.println("isbn do livro:");
				isbn = scanner.nextInt();
				
				LivroComedia livro = new LivroComedia(titulo, valor, 1, isbn);
				if(l1.addLivro(livro)) {
					System.out.println("\nLivro cadastrado.\n");
				}else {
					System.out.println("\nErro.\n");
				}							
				break;
			
			}case "3":{
				int isbn; 
				String titulo; 
				float valor;
				
				System.out.println("titulo do livro:");
				titulo = scanner.next();
				System.out.println("valor do livro:");
				valor = scanner.nextFloat();
				System.out.println("isbn do livro:");
				isbn = scanner.nextInt();
				
				LivroDrama livro = new LivroDrama(titulo, valor, 1, isbn);
				if(l1.addLivro(livro)) {
					System.out.println("\nLivro cadastrado.\n");
				}else {
					System.out.println("\nErro.\n");
				}
				break;
			
			}case "5":{
				l1.buscarLivro(true);
				break;
			
			}case "7":{
				int isbn, id;
				String nome;
				
				System.out.println("codigo da venda: ");
				id = scanner.nextInt();
				System.out.println("nome do cliente: ");
				nome= scanner.next();
				System.out.println("isbn do livro: ");
				isbn = scanner.nextInt();
				
				Venda venda = new Venda(id, nome, isbn);
				if(l1.realizarVenda(venda)) 
					System.out.println("\nVenda realizada com sucesso.\n");
				else
					System.out.println("\nError ao realizar venda !!\n");
				break;
				
			}case "8":{
				String nome, end, nasc;
				int cpf;

				System.out.println("nome do cliente:");
				nome = scanner.next();
				System.out.println("data de nascimento do cliente:");
				nasc = scanner.next();
				System.out.println("endereço do cliente:");
				end = scanner.next();
				System.out.println("CPF do cliente:");
				cpf = scanner.nextInt();
				
				Pessoa pessoa = new Pessoa(nome, cpf, nasc, end);
				if(l1.addCliente(pessoa))
					System.out.println("\ncadastrado\n");
				else
					System.out.println("\nErro\n");
				break;
				
			}case "9":{
				int cpf;
				System.out.println("CPF do cliente:");
				cpf = scanner.nextInt();
				if(l1.rmCliente(cpf)) {
					System.out.println("\nCliente excluido\n");
				}else {
					System.out.println("\nErro\n");
				}break;
				
			}case "4":{
				l1.buscarCliente(true);
				break;
			}default :
				opt = "";
				break;
			}	
		}
	}

}
