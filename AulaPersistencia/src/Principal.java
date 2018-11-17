import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Principal {
	public static String ARQUIVO = "/home/yaagocruuz/Área de Trabalho/Persistencia/" 
								+ "livraria.xml";
	 
	public static void recursao(Node node, String tab) {
		if (node.getNodeType() == Node.TEXT_NODE) return;
		String s = node.getNodeName();
		if(node.getChildNodes().getLength() == 1 && node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
			s += "=" + node.getFirstChild().getNodeValue() + " ";
		}
		String atr = " ";
		if(node.hasAttributes()) {
			for(int k=0; k<node.getAttributes().getLength();k++) {
				Node atributo = node.getAttributes().item(k);
				atr += atributo.getNodeName() + "=" +
						atributo.getNodeValue() + " ";
			}
		}
		
		s += atr;
		System.out.println(tab+s);
		for (int k=0; k <node.getChildNodes().getLength(); k++) {
			recursao(node.getChildNodes().item(k), tab+"\t");
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		File xmlFile = new File(ARQUIVO);
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		Element raiz = doc.getDocumentElement();
		
		recursao(raiz, "");
//		System.out.println("Nome: " + raiz.getNodeName());
//		
//		NodeList nomes = doc.getElementsByTagName("autor");
//		for(int k=0, t=nomes.getLength(); k<t; k++) {
//			//System.out.println(nomes.item(k).getFirstChild().getNodeValue());
//			Node autor = nomes.item(k);
//			NamedNodeMap mapa = autor.getAttributes();
//			for (int i=0; i<mapa.getLength(); i++) {
//				Node att = mapa.item(i);
//				System.out.println(att.getNodeName() + " " + att.getNodeValue());
//			}
//		}
	}



}
