package br.ufc.quixada.teste;


import br.ufc.quixada.DAO.PesquisadorDAO;
import br.ufc.quixada.JPADAO.PesquisadorJPADAO;
import br.ufc.quixada.model.Pesquisador;

public class testando_listas {

	public static void main(String[] args) {
		PesquisadorDAO pd = new PesquisadorJPADAO();
		pd.beginTransaction();
		Pesquisador p = pd.find(2);
		System.out.println(p.toString());
	}

}
