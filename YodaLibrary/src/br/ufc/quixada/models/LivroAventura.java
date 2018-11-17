package br.ufc.quixada.models;

public class LivroAventura extends Livros{
	
	private static final long serialVersionUID = 1L;
	private String extra = "ILustrações";
	
	public LivroAventura(String nomeLivro, float valorLivro, int qtdLivro, int isbnLivro) {
		super(nomeLivro, valorLivro, qtdLivro, isbnLivro);
		// TODO Auto-generated constructor stub
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}	
}
