package trabalho1_pt2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import trabalho1_pt2.model.Universitario;

public class MySaxParser extends DefaultHandler{
	
	public static String SAIDA = "/home/yaagocruuz/Documentos/git/Persistence/trabalho1_pt2/"
			+ "trab1_pt2.json";
	
	private Universitario universitario;
	private List<Universitario> universitarios = new ArrayList<>();
	private String tag;
	
	public MySaxParser(String arquivo) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(arquivo, this);
		}catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("INICIANDO DOCUMENTO");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("FINALIZANDO DOCUMENTO");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.tag = "";
		if(qName.equals("Beneficiario")) {
			this.universitario = new Universitario();
			this.universitario.setDeficiente_fisico(attributes.getValue(0));
			this.universitario.setCpf_beneficiario(attributes.getValue(1));
			this.universitario.setDt_nascimento_beneficiario(attributes.getValue(2));
			this.universitario.setRaca_beneficiario_bolsa(attributes.getValue(3));
			this.universitario.setSexo_beneficiario_bolsa(attributes.getValue(4));
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("Beneficiario")) {
			this.universitarios.add(universitario);
		}else if(qName.equals("ANO_CONCESSAO_BOLSA")) {
			universitario.setAno_concessao_bolsa(this.tag);
		}else if(qName.equals("CODIGO_EMEC_IES_BOLSA")) {
			universitario.setCodigo_emec_ies_bolsa(this.tag);
		}else if(qName.equals("NOME_IES_BOLSA")) {
			universitario.setNome_ies_bolsa(this.tag);
		}else if(qName.equals("TIPO_BOLSA")) {
			universitario.setTipo_bolsa(this.tag);
		}else if(qName.equals("MODALIDADE_ENSINO_BOLSA")) {
			universitario.setModalidade_ensino_bolsa(this.tag);
		}else if(qName.equals("NOME_CURSO_BOLSA")) {
			universitario.setNome_curso_bolsa(this.tag);
		}else if(qName.equals("NOME_TURNO_CURSO_BOLSA")) {
			universitario.setNome_curso_bolsa(this.tag);
		}else if(qName.equals("REGIAO_BENEFICIARIO_BOLSA")) {
			universitario.setRegiao_beneficiario_bolsa(this.tag);
		}else if(qName.equals("SIGLA_UF_BENEFICIARIO_BOLSA")) {
			universitario.setSigla_uf_beneficiario_bolsa(this.tag);
		}else if(qName.equals("MUNICIPIO_BENEFICIARIO_BOLSA")) {
			universitario.setMunicipio_beneficiario_bolsa(this.tag);
		}
		
	}
	
	public void getJson() {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File(SAIDA), this.universitarios);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("finalizado json.");
	}
	
	public List<Universitario> getUniversitarios() {
		return universitarios;
	}

	public void setUniversitarios(List<Universitario> universitarios) {
		this.universitarios = universitarios;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.tag = new String(ch, start, length);
	}
}
