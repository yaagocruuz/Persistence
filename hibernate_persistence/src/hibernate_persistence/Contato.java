package hibernate_persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import dao.Bean;

@Entity
@NamedQueries({
	@NamedQuery(name="Contato.findById", query = "select c from Contato where c.id between :id_1 and :id_2"),
	@NamedQuery(name="Contato.findAll", query = "select * from contato"),
	@NamedQuery(name="Contato.findByName", query = "select c from Contato c where c.nome = :nome")
})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_contato", discriminatorType=DiscriminatorType.STRING, length=1)
@DiscriminatorValue("C")
public class Contato implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contato_id")
	private int id;
	private String nome;
	private String email;
	
	@OneToOne
	@JoinColumn(name="endereco_id", unique=true, nullable=false, updatable=false)
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="contato")
	private List<Telefone> telefones;

	public Contato() {}
	
	public Contato(String nome, String email, Endereco endereco, List<Telefone> telefones) {
		this(0,nome,email,endereco,telefones);
	}

	public Contato(int id, String nome, String email, Endereco endereco, List<Telefone> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.setEndereco(endereco);
		this.telefones = telefones;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}