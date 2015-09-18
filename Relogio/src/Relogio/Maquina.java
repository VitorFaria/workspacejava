package Relogio;

public class Maquina {
	
	private int horas;
	private int minutos;
	private int segundos;
	private double agora;
	private double antes;
	private boolean continua;
	private Display2Digitos display;
	private GUI graficos;

	public Maquina(int horas, int minutos, int segundos) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
		this.continua = true;
		display = new Display2Digitos();
		graficos = new GUI(this);
		graficos.constroiJanela();
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}
	
	public boolean isContinua() {
		return continua;
	}

	public void setContinua(boolean continua) {
		this.continua = continua;
	}

	public void motor(){
		while(continua){
			agora = System.currentTimeMillis();
			if(agora>=antes+1000){
				antes = agora;
				addSegundos();
				//Aqui chamo o trem pra arrumar os dígitos;
				display.formato2Digitos(horas, minutos, segundos);
				
				//Aqui fica a chamada dos métodos gráficos;
				graficos.getSegundoCampo().setText(display.getSegundo());
				graficos.getMinutoCampo().setText(display.getMinuto());
				graficos.getHoraCampo().setText(display.getHora());
			}
		}
	}
	
	private void addSegundos(){
		segundos++;
		if(segundos >= 60){
			segundos = 0;
			addMinutos();
		}
	}
	
	private void addMinutos(){
		minutos++;
		if(minutos >= 60){
			minutos = 0;
			addHoras();
		}
	}
	
	private void addHoras(){
		horas++;
		if(horas >= 24){
			horas = 0;
		}
	}

}
