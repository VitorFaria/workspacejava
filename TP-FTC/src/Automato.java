import java.util.ArrayList;


public class Automato {
	private ArrayList<Estado> estados;
	private ArrayList<String> simbolos;
	private ArrayList<Transicao> transicoes;
	private String inicial;
	private ArrayList<String> terminal;
	
	public Automato(ArrayList<Estado> estados, ArrayList<String> simbolos,
			ArrayList<Transicao> transicoes, String inicial, ArrayList<String> terminal) {
		super();
		this.estados = estados;
		this.simbolos = simbolos;
		this.transicoes = transicoes;
		this.inicial = inicial;
		this.terminal = terminal;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}

	public ArrayList<String> getSimbolos() {
		return simbolos;
	}

	public void setSimbolos(ArrayList<String> simbolos) {
		this.simbolos = simbolos;
	}

	public ArrayList<Transicao> getTransicoes() {
		return transicoes;
	}

	public void setTransicoes(ArrayList<Transicao> transicoes) {
		this.transicoes = transicoes;
	}

	public String getInicial() {
		return inicial;
	}

	public void setInicial(String inicial) {
		this.inicial = inicial;
	}

	public ArrayList<String> getTerminal() {
		return terminal;
	}

	public void setTerminal(ArrayList<String> terminal) {
		this.terminal = terminal;
	}
	
	
	
	
	
	
	
	

}
