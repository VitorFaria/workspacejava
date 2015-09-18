package PesquisaEleitoral;

import java.util.ArrayList;
import java.util.Collection;

public class Listas extends ArrayList {

	int idLista;
	Object inicioLista;
	
	public Listas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Listas(Collection arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Listas(int arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public Object getInicioLista() {
		return this.get(0);
	}

	public void setInicioLista(Object inicioLista) {
		this.inicioLista = inicioLista;
		this.set(0, inicioLista);
	}
	
	
	

}
