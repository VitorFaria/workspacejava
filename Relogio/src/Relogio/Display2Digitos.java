package Relogio;

public class Display2Digitos {

	private String hora;
	private String minuto;
	private String segundo;
	
	public Display2Digitos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getMinuto() {
		return minuto;
	}
	
	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}
	
	public String getSegundo() {
		return segundo;
	}
	
	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}
	
	public void formato2Digitos(int horas, int minutos, int segundos){
		if(horas <= 9){
			hora = "0"+horas;
		}
		else hora = String.valueOf(horas);
		
		if(minutos <= 9){
			minuto = "0"+minutos;
		}
		else minuto = String.valueOf(minutos);
		
		if(segundos <= 9){
			segundo = "0"+segundos;
		}
		else segundo = String.valueOf(segundos);
	}
	
}
