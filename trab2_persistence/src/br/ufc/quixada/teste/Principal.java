package br.ufc.quixada.teste;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufc.quixada.DAO.*;
import br.ufc.quixada.JPADAO.*;
import br.ufc.quixada.model.*;

public class Principal {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		String opt = "-1";

		String opt2 = "-1";
		Scanner aux_text = new Scanner(System.in);
		Scanner aux_int = new Scanner(System.in);

		while(!opt.equals("0")) {
			System.out.println("-----INÍCIO-----");
			System.out.println("1.Adicionar."); //FEITO
			System.out.println("2.Remover."); //FEITO
			System.out.println("3.Consultar."); //FEITO
			System.out.println("0.Sair");
			System.out.println("----------------");
			opt = scanner.nextLine();

			switch(opt) {
			case "1":{
				while(!opt2.equals("0")) {
					System.out.println("-----ADICIONAR-----");
					System.out.println("1.Departamento"); //FEITO
					System.out.println("2.Projeto."); //FEITO
					System.out.println("3.Pesquisador."); //FEITO
					System.out.println("4.Secretario."); //FEITO
					System.out.println("5.Limpeza."); //FEITO
					System.out.println("6.Dependente"); // FEITO
					System.out.println("7.Adicionar Projetos à Pesquisadores");//FEITO
					System.out.println("8.Adicionar Gerente à Limpeza");
					System.out.println("0.Voltar.");
					System.out.println("-------------------");
					opt2 = scanner2.next();

					switch(opt2) {
						case "1":{ //Adicionar Departamento
							DepartamentoDAO dep = new DepartamentoJPADAO();
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o numero do Departamento:");
							int numDept = Integer.parseInt(aux_int.next());
							Departamento d1 = new Departamento(nome, numDept, null, null);
							dep.beginTransaction();
							dep.save(d1);
							dep.commit();
							break;
						}case "2":{	//Adicionar Projeto
							ProjetoDAO proj = new ProjetoJPADAO();
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o numero do projeto:");
							int numProj = Integer.parseInt(aux_int.next());
							System.out.println("Digite o tempo:");
							int tempo = Integer.parseInt(aux_int.next());
	
							System.out.println("Digite o id do departamento:");
							DepartamentoDAO dDao = new DepartamentoJPADAO();
							Departamento dept = dDao.findDeptById(Integer.parseInt(aux_int.next()));
	
							Projeto p1 = new Projeto(0, nome, numProj, tempo, dept, null);
							proj.beginTransaction();
							proj.save(p1);
							proj.commit();
							break;
						}case "3":{ //Add Pesquisador
							FuncionarioDAO func = new FuncionarioJPADAO();
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o endereco:");
							String endereco = aux_text.nextLine();
							System.out.println("Digite o sexo:");
							String sexo = aux_text.nextLine();
							System.out.println("Digite o data de aniversario:");
							String dtAniv = aux_text.nextLine();
							System.out.println("Digite o salario:");
							Double salario = aux_int.nextDouble();
							System.out.println("Digite a area de atuacao:");
							String areaAtuacao = aux_text.nextLine();
							System.out.println("Digite o id do departamento:");
							DepartamentoDAO dDao = new DepartamentoJPADAO();
							Departamento dept = dDao.findDeptById(Integer.parseInt(aux_int.next()));
	
							Pesquisador p1 = new Pesquisador(0, nome, endereco, sexo, dtAniv, salario,
									dept, null, areaAtuacao, null);
							func.beginTransaction();
							func.save(p1);
							func.commit();
							break;
						}case "4":{ //secretario
							FuncionarioDAO func = new FuncionarioJPADAO();
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o endereco:");
							String endereco = aux_text.nextLine();
							System.out.println("Digite o sexo:");
							String sexo = aux_text.nextLine();
							System.out.println("Digite o data de aniversario:");
							String dtAniv = aux_text.nextLine();
							System.out.println("Digite o salario:");
							Double salario = aux_int.nextDouble();
							System.out.println("Digite o grau de escolaridade:");
							String grauEscolaridade = aux_text.nextLine();
	
							System.out.println("Digite o id do departamento:");
							DepartamentoDAO dDao = new DepartamentoJPADAO();
							Departamento dept = dDao.findDeptById(Integer.parseInt(aux_int.next()));
	
							Secretario s1 = new Secretario(0, nome, endereco, sexo, 
									dtAniv, salario, dept, null, grauEscolaridade);
							func.beginTransaction();
							func.save(s1);
							func.commit();
							break;
						}case "5":{ //limpeza
							LimpezaDAO func = new LimpezaJPADAO();
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o endereco:");
							String endereco = aux_text.nextLine();
							System.out.println("Digite o sexo:");
							String sexo = aux_text.nextLine();
							System.out.println("Digite o data de aniversario:");
							String dtAniv = aux_text.nextLine();
							System.out.println("Digite o salario:");
							Double salario = aux_int.nextDouble();
							System.out.println("Digite o cargo:");
							String cargo = aux_text.nextLine();
							System.out.println("Digite a jornada em horas:");
							int jornada = Integer.parseInt(aux_int.next());
	
							System.out.println("Digite o id do departamento:");
							DepartamentoDAO dDao = new DepartamentoJPADAO();
							Departamento dept = dDao.findDeptById(Integer.parseInt(aux_int.next()));
	
							Limpeza l1 = new Limpeza(0, nome, endereco, sexo, dtAniv, salario, 
									dept, null, cargo, jornada, null, new ArrayList<>());
							func.beginTransaction();
							func.save(l1);
							func.commit();
							break;
						}case "6":{
							System.out.println("Digite o nome:");
							String nome = aux_text.nextLine();
							System.out.println("Digite o sexo:");
							String sexo = aux_text.nextLine();
							System.out.println("Digite o data de aniversario:");
							String dtAniv = aux_text.nextLine();
							System.out.println("Digite o id do Funcionario:");
							FuncionarioDAO fDao = new FuncionarioJPADAO();
							fDao.beginTransaction();
							Funcionario func = fDao.find(Integer.parseInt(aux_int.next()));
							fDao.close();
							System.out.println("Digite o grau de parentesco com o funcionario:");
							String grauParent = aux_text.nextLine();
							DependenteDAO dDao = new DependenteJPADAO();
							dDao.beginTransaction();
							Dependente d1 = new Dependente(nome, sexo, dtAniv, grauParent, func);
							dDao.save(d1);
							dDao.commit();
							dDao.close();
							break;
						}case "7":{ //projeto à pesquisadores
							System.out.println("Digite o id do Pesquisador");
							PesquisadorDAO psD = new PesquisadorJPADAO(); 
							psD.beginTransaction();
							Pesquisador p1 = psD.find(Integer.parseInt(aux_int.next()));
							psD.close();
							
							System.out.println("Digite o id do Projeto");
							ProjetoDAO pjD = new ProjetoJPADAO();
							pjD.beginTransaction();
							Projeto pj1 = pjD.find(Integer.parseInt(aux_int.next()));
							pjD.close();
	
							System.out.println("Digite a carga horária");
							PesquisadorProjetoDAO ppD = new PesquisadorProjetoJPADAO();
							ppD.beginTransaction();
							PesquisadorProjeto pp1 = new PesquisadorProjeto(Integer.parseInt(aux_int.next()), p1, pj1);
							ppD.save(pp1);
							ppD.commit();
							ppD.close();
							break;
						}case "8":{
							LimpezaDAO ldao = new LimpezaJPADAO();
							ldao.beginTransaction();
							System.out.println("Digite o seu id:");
							Limpeza func = ldao.find(Integer.parseInt(aux_int.next()));
							System.out.println("Digite o id do Gerente");
							Limpeza gerente = ldao.find(Integer.parseInt(aux_int.next()));
							func.setGerente(gerente);
							ldao.save(func);
							ldao.commit();
							break;
						}default :{
							opt2 = "-1";
							break;
						}
						}
						break;
					}
					opt = "-1";
					break;
				}case "2":{ // REMOVER
					while(!opt2.equals("0")) {
						System.out.println("-----REMOVER-----");
						System.out.println("1.Departamento"); //FEITO
						System.out.println("2.Projeto."); //FEITO
						System.out.println("3.Funcionário."); //FEITO
						System.out.println("4.Dependente");
						System.out.println("0.Voltar.");
						System.out.println("-----------------");
						opt2 = scanner2.next();
						switch(opt2) {
						case "1":{
							System.out.println("Digite o id do departamento:");
							DepartamentoDAO dDao = new DepartamentoJPADAO();
							dDao.beginTransaction();
							dDao.delete(Integer.parseInt(aux_int.next()));
							dDao.close();
							break;
						}case "2":{
							System.out.println("Digite o id do Projeto:");
							ProjetoDAO pDao = new ProjetoJPADAO();
							pDao.beginTransaction();
							pDao.delete(Integer.parseInt(aux_int.next()));
							pDao.close();
							break;
						}case "3":{
							System.out.println("Digite o id do Funcionario: ");
							FuncionarioDAO fDao = new FuncionarioJPADAO();
							fDao.beginTransaction();
							fDao.delete(Integer.parseInt(aux_int.next()));
							fDao.close();
							break;
						}case "4": {
							System.out.println("Digite o id do Dependente: ");
							DependenteDAO dDao = new DependenteJPADAO();
							dDao.beginTransaction();
							dDao.delete(Integer.parseInt(aux_int.next()));
							dDao.close();
							break;
						}default :{
							opt2 = "-1";
							break;
						}
						}
						break;
					}
					opt = "-1";
					break;
	
				}case "3":{ //CONSULTAR
					while(!opt2.equals("0")) {
						System.out.println("-----CONSULTAR-----");
						System.out.println("1.Departamento"); //FEITO
						System.out.println("2.Projeto."); //FEITO
						System.out.println("3.Funcionário."); //FEITO
						System.out.println("4.Dependente");
						System.out.println("0.Voltar.");
						System.out.println("-------------------");
						opt2 = scanner2.next();
	
						switch(opt2) {
							case "1":{
								System.out.println("Digite o id do departamento:");
								DepartamentoDAO dDao = new DepartamentoJPADAO();
								dDao.beginTransaction();
								System.out.println(dDao.find(Integer.parseInt(aux_int.next())));
								dDao.close();
								break;
							}case "2":{
								System.out.println("Digite o id do Projeto:");
								ProjetoDAO pDao = new ProjetoJPADAO();
								pDao.beginTransaction();
								System.out.println(pDao.findProjById(Integer.parseInt(aux_int.next())));
								pDao.close();
								break;
							}case "3":{
								System.out.println("Digite o id do Funcionario: ");
								FuncionarioDAO fDao = new FuncionarioJPADAO();
								fDao.beginTransaction();
								System.out.println(fDao.findFuncById(Integer.parseInt(aux_int.next())));
								fDao.close();
								break;
							}case "4":{ //dependente
								System.out.println("Digite o id do Dependente: ");
								DependenteDAO dDao = new DependenteJPADAO();
								dDao.beginTransaction();
								System.out.println(dDao.find(Integer.parseInt(aux_int.next())));
								dDao.close();
								break;
							}default :{
								opt2 = "-1";
								break;
							}
						}
					}
				}case "0":{
					scanner.close();
					scanner2.close();
					aux_int.close();
					aux_text.close();
					return;
				}default:{
					opt = "-1";
					break;
				}
			}
		}
		scanner.close();
		scanner2.close();
		aux_int.close();
		aux_text.close();
		return;
	}


}
