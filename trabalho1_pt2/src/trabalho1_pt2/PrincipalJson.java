package trabalho1_pt2;

public class PrincipalJson {
	public static final String ARQUIVO_ENTRADA = "/home/yaagocruuz/Documentos/git/Persistence/trabalho1_pt2/" 
						+ "trab1_pt2.xml";
	
	public static void main(String[] args){
		MySaxParser msp = new MySaxParser(ARQUIVO_ENTRADA);
		msp.getJson();
	}
}
