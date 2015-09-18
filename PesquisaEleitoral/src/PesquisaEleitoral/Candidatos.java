package PesquisaEleitoral;

public class Candidatos {
	
	String nome;
	private int eleitores;//numero de eleitores;
	private int eleitoras;//numero de eleitoras;
	private int[] faixasEtaria = {0, 0, 0, 0, 0};
	private int[] faixasSalarial= {0, 0, 0};
	private int[] faixasEscolaridade = {0, 0, 0, 0};
	
	
	public Candidatos() {
		super();
//		faixasEtaria = {0, 0, 0};
//		faixasSalarial = new int[3];
//		faixasEscolaridade = new int[4];
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getEleitores() {
		return eleitores;
	}
	
	public void setEleitores(int eleitores) {
		this.eleitores = eleitores;
	}
	
	public int getEleitoras() {
		return eleitoras;
	}
	
	public void setEleitoras(int eleitoras) {
		this.eleitoras = eleitoras;
	}
	
	public int[] getFaixasEtaria() {
		return faixasEtaria;
	}
	
	public void setFaixasEtaria(int[] faixasEtaria) {
		this.faixasEtaria = faixasEtaria;
	}
	
	public int[] getFaixasSalarial() {
		return faixasSalarial;
	}
	
	public void setFaixasSalarial(int[] faixasSalarial) {
		this.faixasSalarial = faixasSalarial;
	}
	
	public int[] getFaixasEscolaridade() {
		return faixasEscolaridade;
	}

	public void setFaixasEscolaridade(int[] faixasEscolaridade) {
		this.faixasEscolaridade = faixasEscolaridade;
	}

	public void atualiza(Questionario questionario){
		faixasEscolaridade[questionario.getEscolaridade()]++;
		faixasEtaria[questionario.getFaixaEt()]++;
		faixasSalarial[questionario.getFaixaSal()]++;
		if(questionario.getSexo()==0) eleitores++;
		else eleitoras++;
	}

}
