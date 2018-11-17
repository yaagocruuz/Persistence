package br.ufc.quixada.criacaoXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CriarArquivoXML {
	
	public static final String ARQUIVO = "teste.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element raiz = doc.createElement("livraria");
		doc.appendChild(raiz);
		
		Element livro1 = doc.createElement("livro");
		raiz.appendChild(livro1);
		
		Attr anoLivro1 = doc.createAttribute("ano");
		anoLivro1.setValue("2000");
		livro1.setAttributeNode(anoLivro1);
		
		Element tituloLivro1 = doc.createElement("titulo");
		tituloLivro1.appendChild(doc.createTextNode("Meu amigo Flip"));
		livro1.appendChild(tituloLivro1);
		
		Element autoresLivro1 = doc.createElement("autores");
		livro1.appendChild(autoresLivro1);
		
		Element autor1Livro1 = doc.createElement("autor");
		autor1Livro1.appendChild(doc.createTextNode("Elisabete"));
		autoresLivro1.appendChild(autor1Livro1);
		
		Element autor2Livro1 = doc.createElement("autor");
		autor2Livro1.appendChild(doc.createTextNode("Yago"));
		autoresLivro1.appendChild(autor2Livro1);
		
		Element editoraLivro1 = doc.createElement("editora");
		editoraLivro1.appendChild(doc.createTextNode("Ciranda"));
		livro1.appendChild(editoraLivro1);
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer optimusPrime = tFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(ARQUIVO));
		
		optimusPrime.setOutputProperty(OutputKeys.INDENT, "yes");
		optimusPrime.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		optimusPrime.transform(source, result);
	}
}
