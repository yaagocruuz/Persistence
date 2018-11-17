package hibernate_persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

import dao.Bean;

@Entity
public class Telefone implements Bean{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="telefone_id")
	private int id;
	@Length(min=2, max=2)
	private String ddd;
	@Length(min=9, max=9)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="contato_id", nullable=false)
	private Contato contato;
	
	public Telefone() {}
	
	public Telefone(String ddd, String numero, Contato contato) {
		this(0,ddd,numero,contato);
	}

	public Telefone(int id, String ddd, String numero, Contato contato) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.contato = contato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero + ", contato=" + contato + "]";
	}
	
}
