package br.ufc.quixada.models;

public class LivroDrama extends Livros{
	private static final long serialVersionUID = 1L;
	private String capa = "Dura";
	
	public LivroDrama(String nomeLivro, float valorLivro, int qtdLivro, int isbnLivro) {
		super(nomeLivro, valorLivro, qtdLivro, isbnLivro);
		// TODO Auto-generated constructor stub
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}
	
}
