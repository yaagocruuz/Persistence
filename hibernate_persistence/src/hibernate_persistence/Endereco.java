package hibernate_persistence;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dao.Bean;

public class Endereco implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="endereco_id")
	private int id;
	private String rua;
	private int numero;
	
	@OneToOne(mappedBy="endereco")
	private Contato contato;
	
	public Endereco() {}
	
	public Endereco(int id, String rua, int numero, Contato contato) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.setContato(contato);
	}
	
	public Endereco(String rua, int numero, Contato contato) {
		this(0, rua, numero, contato);
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + "]";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
