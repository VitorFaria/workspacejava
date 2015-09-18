package PesquisaEleitoral;

public class Questionario {
	
	private String candidato;
	private int sexo;//0 -> masc; 1 -> fem;
	private int escolaridade;//0 -> none; 1 -> primeiro grau; etc...
	private int faixaEt;//0 -> menos que 20; 1 -> entre 20 e 30; etc...
	private int faixaSal;//mesmo esquema;
	
	
	public Questionario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(int escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getFaixaEt() {
		return faixaEt;
	}

	public void setFaixaEt(int faixaEt) {
		this.faixaEt = faixaEt;
	}

	public int getFaixaSal() {
		return faixaSal;
	}

	public void setFaixaSal(int faixaSal) {
		this.faixaSal = faixaSal;
	}

	public void avaliacao(){
		
	}
	
}
