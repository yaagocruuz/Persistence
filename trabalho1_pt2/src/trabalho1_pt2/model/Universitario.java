package trabalho1_pt2.model;

public class Universitario {
	
	private String deficiente_fisico;
	private String cpf_beneficiario;		
	private String dt_nascimento_beneficiario;
	private String raca_beneficiario_bolsa;
	private String sexo_beneficiario_bolsa;
	private String ano_concessao_bolsa;
	private String codigo_emec_ies_bolsa;
	private String nome_ies_bolsa;
	private String tipo_bolsa;
	private String modalidade_ensino_bolsa;
	private String nome_curso_bolsa;
	private String nome_turno_curso_bolsa;
	private String regiao_beneficiario_bolsa;
	private String sigla_uf_beneficiario_bolsa;
	private String municipio_beneficiario_bolsa;
	
	public Universitario() {}
	
	public Universitario(String deficiente_fisico, String cpf_beneficiario, String dt_nascimento_beneficiario,
			String raca_beneficiario_bolsa, String sexo_beneficiario_bolsa, String ano_concessao_bolsa,
			String codigo_emec_ies_bolsa, String nome_ies_bolsa, String tipo_bolsa, String modalidade_ensino_bolsa,
			String nome_curso_bolsa, String nome_turno_curso_bolsa, String regiao_beneficiario_bolsa,
			String sigla_uf_beneficiario_bolsa, String municipio_beneficiario_bolsa) {
		super();
		this.deficiente_fisico = deficiente_fisico;
		this.cpf_beneficiario = cpf_beneficiario;
		this.dt_nascimento_beneficiario = dt_nascimento_beneficiario;
		this.raca_beneficiario_bolsa = raca_beneficiario_bolsa;
		this.sexo_beneficiario_bolsa = sexo_beneficiario_bolsa;
		this.ano_concessao_bolsa = ano_concessao_bolsa;
		this.codigo_emec_ies_bolsa = codigo_emec_ies_bolsa;
		this.nome_ies_bolsa = nome_ies_bolsa;
		this.tipo_bolsa = tipo_bolsa;
		this.modalidade_ensino_bolsa = modalidade_ensino_bolsa;
		this.nome_curso_bolsa = nome_curso_bolsa;
		this.nome_turno_curso_bolsa = nome_turno_curso_bolsa;
		this.regiao_beneficiario_bolsa = regiao_beneficiario_bolsa;
		this.sigla_uf_beneficiario_bolsa = sigla_uf_beneficiario_bolsa;
		this.municipio_beneficiario_bolsa = municipio_beneficiario_bolsa;
	}
	public String getDeficiente_fisico() {
		return deficiente_fisico;
	}
	public void setDeficiente_fisico(String deficiente_fisico) {
		this.deficiente_fisico = deficiente_fisico;
	}
	public String getCpf_beneficiario() {
		return cpf_beneficiario;
	}
	public void setCpf_beneficiario(String cpf_beneficiario) {
		this.cpf_beneficiario = cpf_beneficiario;
	}
	public String getDt_nascimento_beneficiario() {
		return dt_nascimento_beneficiario;
	}
	public void setDt_nascimento_beneficiario(String dt_nascimento_beneficiario) {
		this.dt_nascimento_beneficiario = dt_nascimento_beneficiario;
	}
	public String getRaca_beneficiario_bolsa() {
		return raca_beneficiario_bolsa;
	}
	public void setRaca_beneficiario_bolsa(String raca_beneficiario_bolsa) {
		this.raca_beneficiario_bolsa = raca_beneficiario_bolsa;
	}
	public String getSexo_beneficiario_bolsa() {
		return sexo_beneficiario_bolsa;
	}
	public void setSexo_beneficiario_bolsa(String sexo_beneficiario_bolsa) {
		this.sexo_beneficiario_bolsa = sexo_beneficiario_bolsa;
	}
	public String getAno_concessao_bolsa() {
		return ano_concessao_bolsa;
	}
	public void setAno_concessao_bolsa(String ano_concessao_bolsa) {
		this.ano_concessao_bolsa = ano_concessao_bolsa;
	}
	public String getCodigo_emec_ies_bolsa() {
		return codigo_emec_ies_bolsa;
	}
	public void setCodigo_emec_ies_bolsa(String codigo_emec_ies_bolsa) {
		this.codigo_emec_ies_bolsa = codigo_emec_ies_bolsa;
	}
	public String getNome_ies_bolsa() {
		return nome_ies_bolsa;
	}
	public void setNome_ies_bolsa(String nome_ies_bolsa) {
		this.nome_ies_bolsa = nome_ies_bolsa;
	}
	public String getTipo_bolsa() {
		return tipo_bolsa;
	}
	public void setTipo_bolsa(String tipo_bolsa) {
		this.tipo_bolsa = tipo_bolsa;
	}
	public String getModalidade_ensino_bolsa() {
		return modalidade_ensino_bolsa;
	}
	public void setModalidade_ensino_bolsa(String modalidade_ensino_bolsa) {
		this.modalidade_ensino_bolsa = modalidade_ensino_bolsa;
	}
	public String getNome_curso_bolsa() {
		return nome_curso_bolsa;
	}
	public void setNome_curso_bolsa(String nome_curso_bolsa) {
		this.nome_curso_bolsa = nome_curso_bolsa;
	}
	public String getNome_turno_curso_bolsa() {
		return nome_turno_curso_bolsa;
	}
	public void setNome_turno_curso_bolsa(String nome_turno_curso_bolsa) {
		this.nome_turno_curso_bolsa = nome_turno_curso_bolsa;
	}
	public String getRegiao_beneficiario_bolsa() {
		return regiao_beneficiario_bolsa;
	}
	public void setRegiao_beneficiario_bolsa(String regiao_beneficiario_bolsa) {
		this.regiao_beneficiario_bolsa = regiao_beneficiario_bolsa;
	}
	public String getSigla_uf_beneficiario_bolsa() {
		return sigla_uf_beneficiario_bolsa;
	}
	public void setSigla_uf_beneficiario_bolsa(String sigla_uf_beneficiario_bolsa) {
		this.sigla_uf_beneficiario_bolsa = sigla_uf_beneficiario_bolsa;
	}
	public String getMunicipio_beneficiario_bolsa() {
		return municipio_beneficiario_bolsa;
	}
	public void setMunicipio_beneficiario_bolsa(String municipio_beneficiario_bolsa) {
		this.municipio_beneficiario_bolsa = municipio_beneficiario_bolsa;
	}

	@Override
	public String toString() {
		return "Universitario [deficiente_fisico=" + deficiente_fisico + ", cpf_beneficiario=" + cpf_beneficiario
				+ ", dt_nascimento_beneficiario=" + dt_nascimento_beneficiario + ", raca_beneficiario_bolsa="
				+ raca_beneficiario_bolsa + ", sexo_beneficiario_bolsa=" + sexo_beneficiario_bolsa
				+ ", ano_concessao_bolsa=" + ano_concessao_bolsa + ", codigo_emec_ies_bolsa=" + codigo_emec_ies_bolsa
				+ ", nome_ies_bolsa=" + nome_ies_bolsa + ", tipo_bolsa=" + tipo_bolsa + ", modalidade_ensino_bolsa="
				+ modalidade_ensino_bolsa + ", nome_curso_bolsa=" + nome_curso_bolsa + ", nome_turno_curso_bolsa="
				+ nome_turno_curso_bolsa + ", regiao_beneficiario_bolsa=" + regiao_beneficiario_bolsa
				+ ", sigla_uf_beneficiario_bolsa=" + sigla_uf_beneficiario_bolsa + ", municipio_beneficiario_bolsa="
				+ municipio_beneficiario_bolsa + "]";
	}
	
	
}
