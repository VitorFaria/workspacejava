import java.util.ArrayList;

public class Regra {
	
	private String variEsquerda;
	private ArrayList<String> direita;	
		
	public Regra(String variEsquerda, ArrayList<String> direita) {
		super();
		this.variEsquerda = variEsquerda;
		this.direita = direita;
	}
	
	public String getVariEsquerda() {
		return variEsquerda;
	}
	public void setVariEsquerda(String variEsquerda) {
		this.variEsquerda = variEsquerda;
	}
	public ArrayList<String> getDireita() {
		return direita;
	}
	public void setDireita(ArrayList<String> direita) {
		this.direita = direita;
	}
	
	

}
