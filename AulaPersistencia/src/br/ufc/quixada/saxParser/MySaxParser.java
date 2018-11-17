package br.ufc.quixada.saxParser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxParser extends DefaultHandler{
	
	private int tab;
	
	public MySaxParser(String arquivo) {
		this.tab = 0;
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
		String s = getTab() + "Abrindo: " + qName;
		if(attributes.getLength() > 0) {
			s += "[ ";
			for(int k=0; k <attributes.getLength();k++) {
				s+=attributes.getQName(k)+"="+
				   attributes.getValue(k) + " ";
			}
			s+= "]";
		}
		System.out.println(s);
		this.tab++;
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		this.tab--;
		System.out.println(getTab() + "Fechando: " + qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length);
		if (s.isEmpty()) return;
		System.out.println(this.getTab() + s);
	}
	
	private String getTab() {
		String s = "";
		for(int k = 0; k < this.tab; k++) s += "\t";
		return s;
	}
}
