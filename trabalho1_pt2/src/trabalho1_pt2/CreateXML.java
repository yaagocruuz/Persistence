package trabalho1_pt2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {

	public static final String ARQUIVO_SAIDA = "trab1_pt2.xml";
	//239263 linhas
	public static final String ARQUIVO_ENTRADA = "/home/yaagocruuz/Documentos/git/Persistence/trabalho1_pt2/PDA_PROUNI_2016_CSV.csv";
	public static String delim = ";";

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			BufferedReader leitorCSV = new BufferedReader(new FileReader(ARQUIVO_ENTRADA));
			
			//contador pra quantidade de elementos
			int contador = 0;
			
			//Elementos da linha do csv
			String[] elementosCSV = null;
			
			StringTokenizer sTokenizer = null;
			
			//criar o documento
			Document doc = builder.newDocument();
			
			//começar pela raiz
			Element raiz = doc.createElement("ProUni");
			doc.appendChild(raiz);

			
			//pegar a primeira linha do csv e transformar em tokens
			String linhaCSV = leitorCSV.readLine();
			if (linhaCSV != null) {
				sTokenizer = new StringTokenizer(linhaCSV, delim);
				contador = sTokenizer.countTokens();
				if (contador > 0) {
					elementosCSV = new String[contador];	
					int i = 0;
					while (sTokenizer.hasMoreTokens()) {
						elementosCSV[i++] = String.valueOf(sTokenizer.nextElement());
					}
					int l = elementosCSV.length-1;
					while (l >= 0) {
						System.out.println(elementosCSV[l]);
						l--;
					}
				}
			}
			System.out.println("passei do tokenizer");
			//239263
			//int teste = 0;
			linhaCSV = leitorCSV.readLine();
			//while(teste < 3) {
			while (linhaCSV != null) {
				sTokenizer = new StringTokenizer(linhaCSV, delim);
				contador = sTokenizer.countTokens();
				if (contador > 0) {
					Element rowElement = doc.createElement("Beneficiario");
					int i = 0;
					while (sTokenizer.hasMoreElements()) {
						if(i == 7 || i == 8 || i == 9 || i == 10 || i == 11) {
							Attr attrElement = doc.createAttribute(elementosCSV[i++]);
							attrElement.setValue(String.valueOf(sTokenizer.nextElement()));
							rowElement.setAttributeNode(attrElement);
						}else {
							String curValue = String.valueOf(sTokenizer.nextElement());
							Element curElement = doc.createElement(elementosCSV[i++]);
							curElement.appendChild(doc.createTextNode(curValue));
							rowElement.appendChild(curElement);
						}
					}
					raiz.appendChild(rowElement);
					linhaCSV = leitorCSV.readLine();
					//teste++;
				}
			}
			System.out.println("imprimi todas as linhas!!");
			leitorCSV.close();

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(ARQUIVO_SAIDA));

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
			System.out.println("finalizei o programa!!");

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
