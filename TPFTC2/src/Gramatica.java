import java.util.ArrayList;

public class Gramatica {
	
	private ArrayList<String> variaveis;
	private ArrayList<String> terminais;
	private String vInicial;
	private ArrayList<Regra> regras;
	
	public Gramatica() {
		super();
		this.variaveis = new ArrayList<String>();
		this.terminais = new ArrayList<String>();
		this.vInicial = new String();
		this.regras = new ArrayList<Regra>();
	}
	
	public ArrayList<Regra> getRegras() {
		return regras;
	}
	public void setRegras(ArrayList<Regra> regras) {
		this.regras = regras;
	}
	public ArrayList<String> getVariaveis() {
		return variaveis;
	}
	public void setVariaveis(ArrayList<String> variaveis) {
		this.variaveis = variaveis;
	}
	public ArrayList<String> getTerminais() {
		return terminais;
	}
	public void setTerminais(ArrayList<String> terminais) {
		this.terminais = terminais;
	}
	public String getVinicial() {
		return vInicial;
	}
	public void setVinicial(String vinicial) {
		this.vInicial = vinicial;
	}
	
	

}
