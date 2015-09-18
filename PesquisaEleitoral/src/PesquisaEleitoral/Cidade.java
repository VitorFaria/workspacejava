package PesquisaEleitoral;

public class Cidade {
	
	private String nome;
	private Listas quests = new Listas();
	private Listas candidatos = new Listas();
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Listas getQuests() {
		return quests;
	}
	
	public void setQuests(Listas quests) {
		this.quests = quests;
	}

	public Listas getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(Listas candidatos) {
		this.candidatos = candidatos;
	}
	
	

}
