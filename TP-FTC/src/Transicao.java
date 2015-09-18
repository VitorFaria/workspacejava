
public class Transicao {
	
	private String estado;
	private String resposta;
	private String simbolo;
	
	public Transicao(String estado, String resposta, String simbolo){
		super();
		this.estado = estado;
		this.resposta = resposta;
		this.simbolo = simbolo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	

}
