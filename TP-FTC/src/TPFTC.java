import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Não consegui mostrar os exemplos ou fazer com que funcione em todos os casos.
 * 
 * 
 * Modo de entrada: um txt no formato:
 * 
 * 1 2 3 4 5 6 7 //estados
 * 0 1 //alfabeto
 * 2 3 //transicoes
 * 1 3 
 * 4 3 
 * 5 6 
 * 5 7 
 * 7 6 
 * 5 7 
 * 1  //estado inicial
 * 4 6 //estados finais
 * 
 * @author Vitor Faria
 * @version 25-10-2012
 */


public class TPFTC {

	static boolean A = false;
	static boolean B = false;
	static boolean C = false;
	static boolean D = false;
	static boolean E = false;
	static boolean F = false;
	
	static String aa = " ";
	static String bb = " ";
	static String cc = " ";
	static String dd = " ";
	static String ee = " ";
	static String ff = " ";
	
//	static Estado estadoteste1 = new Estado("estadoteste1");
//	static Estado estadoteste2 = new Estado("estadoteste2");
//	static Estado estadoteste3 = new Estado("estadoteste3");
//	static Estado erro1 = new Estado("erro1");
//	static String um = "1";
//	static String dois = "2";	
//	static Transicao transteste1 = new Transicao("estadoteste1", "estadoteste2", um);
//	static Transicao transteste2 = new Transicao("estadoteste2", "estadoteste1", dois);
//	static Transicao transteste3 = new Transicao("estadoteste2", "estadoteste3", um);
//	static Transicao transerro1 = new Transicao("estadoteste1", "erro1", dois);
//	static Transicao transerro2 = new Transicao("estadoteste3", "erro1", um);
//	static Transicao transerro3 = new Transicao("estadoteste3", "erro1", dois);
//	static Transicao transerroerro1 = new Transicao("erro1", "erro1", um);
//	static Transicao transerroerro2 = new Transicao("erro1", "erro1", dois);
//	static ArrayList<Estado> estados1 = new ArrayList<Estado>();
	static ArrayList<String> simbolos1= new ArrayList<String>();
//	static ArrayList<Transicao> transicoes1 = new ArrayList<Transicao>();
	static ArrayList<String> terminal1 = new ArrayList<String>();
//	
//	static Estado estadotestea = new Estado("estadotestea");
//	static Estado estadotesteb = new Estado("estadotesteb");
//	static Estado erroa = new Estado("erroa");
//	static Transicao transtestea = new Transicao("estadotestea", "estadotesteb", um);
//	static Transicao transtesteb = new Transicao("estadotesteb", "estadotestea", dois);
//	static Transicao transerroa = new Transicao("estadotesteb", "erroa", um);
//	static Transicao transerrob = new Transicao("estadotestea", "erroa", dois);
//	static Transicao transerroerroa = new Transicao("erroa", "erroa", um);
//	static Transicao transerroerrob = new Transicao("erroa", "erroa", dois);
//	static ArrayList<Estado> estadosa = new ArrayList<Estado>();
//	static ArrayList<String> simbolosa= new ArrayList<String>();
//	static ArrayList<Transicao> transicoesa = new ArrayList<Transicao>();
//	static ArrayList<String> terminala = new ArrayList<String>();
	
	

	static ArrayList <String> mem = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		estados1.add(estadoteste1);
//		estados1.add(estadoteste2);
//		estados1.add(estadoteste3);
//		estados1.add(erro1);
//		simbolos1.add(um);
//		simbolos1.add(dois);
//		transicoes1.add(transteste1);
//		transicoes1.add(transteste2);
//		transicoes1.add(transteste3);
//		transicoes1.add(transerro1);
//		transicoes1.add(transerro2);
//		transicoes1.add(transerro3);
//		transicoes1.add(transerroerro1);
//		transicoes1.add(transerroerro2);
//		terminal1.add("estadoteste2");
//		terminal1.add("estadoteste3");
//		
//		estadosa.add(estadotestea);
//		estadosa.add(estadotesteb);
//		estadosa.add(erroa);
//		simbolosa.add(um);
//		simbolosa.add(dois);
//		transicoesa.add(transtestea);
//		transicoesa.add(transtesteb);
//		transicoesa.add(transerroa);
//		transicoesa.add(transerrob);
//		transicoesa.add(transerroerroa);
//		transicoesa.add(transerroerrob);
//		terminala.add("estadotesteb");
		
		
		
//		Automato automato1 = new Automato(estados1,simbolos1,transicoes1, "estadoteste1", terminal1);
//		Automato automatoa = new Automato(estadosa,simbolosa,transicoesa, "estadotestea", terminala);
	
		Automato automato1 = getAuto("C:/Users/Victor/Desktop/auto1.txt");
		Automato automatoa = getAuto("C:/Users/Victor/Desktop/auto2.txt");

//		Automato automato1 = getAuto(args[0]);
//		Automato automatoa = getAuto(args[1]);
		
		Automato automatoMult = geraMultAuto(automato1, automatoa);
		
		descobreSe1ContemA(automato1, automatoa, automatoMult);
		descobreSeAContem1(automato1, automatoa, automatoMult);
		if (B && C) F= true;
		disjuntas(automato1, automatoa, automatoMult);
		
		if(!A) aa = criaa(automatoMult);
		if(!B) bb = criab(automato1, automatoa);
		if(!C) cc = criab(automatoa, automato1);
		
		if(!D && !F) dd = criab(automato1, automatoa);
		else dd = "iguais";
		if(!E && !F) ee = criab(automatoa, automato1);
		else ee = "iguais";
		
		if(!F && !B) ff = criab(automato1, automatoa);
		if(!F && !C) ff = criab(automatoa, automato1);
		
		System.out.println("A: "+A+" "+aa );
		System.out.println("B: "+B+" "+bb );
		System.out.println("C: "+C+" "+cc );
		System.out.println("D: "+D+" "+dd );
		System.out.println("E: "+E+" "+ee );
		System.out.println("F: "+F+" "+ff );
		

	}
	
	public static Automato geraMultAuto(Automato auto1, Automato autoa){// Faz a multiplicação dos automatos
		
		ArrayList<Estado> estadosMult = new ArrayList<Estado>();
		ArrayList<Transicao> transicoesMult = new ArrayList<Transicao>();
		
		for(int i = 0; i < auto1.getEstados().size(); i++){
			//System.out.printf("dur");
			for(int j = 0; j < autoa.getEstados().size(); j++){
				//System.out.println(auto1.getEstados().get(i).getIdentificador()+autoa.getEstados().get(j).getIdentificador()+"\n");
				Estado estadoAux = new Estado(auto1.getEstados().get(i).getIdentificador()+" "+autoa.getEstados().get(j).getIdentificador());
				estadosMult.add(estadoAux);
				for(int k = 0; k < auto1.getSimbolos().size(); k++){
					Estado entrada = estadoAux;
					String simbolo = auto1.getSimbolos().get(k);
					
					String saux1 = "deu pau";
					String saux2 = "deu pau";
					for(int l = 0; l < auto1.getTransicoes().size(); l++){
						if( auto1.getTransicoes().get(l).getEstado().equals(auto1.getEstados().get(i).getIdentificador()) && (auto1.getTransicoes().get(l).getSimbolo().equals(simbolo))){
							saux1 = auto1.getTransicoes().get(l).getResposta();
						}
					}
					for(int l = 0; l < autoa.getTransicoes().size(); l++){
						if( autoa.getTransicoes().get(l).getEstado().equals(autoa.getEstados().get(j).getIdentificador()) && (autoa.getTransicoes().get(l).getSimbolo().equals(simbolo))){
							saux2 = autoa.getTransicoes().get(l).getResposta();
						}
					}
					String identResposta = saux1+ " " +saux2; 
					Estado resposta = new Estado(identResposta);
					//System.out.println(entrada.getIdentificador()+" "+identResposta+" "+auto1.getSimbolos().get(k));
					Transicao tranAux = new Transicao(entrada.getIdentificador(),resposta.getIdentificador(),auto1.getSimbolos().get(k));
					transicoesMult.add(tranAux);
				}
				//System.out.println();
				
			}
			
		}
		String novoInicial = auto1.getInicial()+" "+autoa.getInicial();
		//System.out.println(auto1.getInicial()+" "+autoa.getInicial());
		Estado novoEstadoInicial = new Estado(novoInicial);
		Automato automatoMult = new Automato(estadosMult,simbolos1,transicoesMult, novoInicial, terminal1);//Aqui o terminal não importa...
		criaTerminal(auto1, autoa, automatoMult);//aqui é...
		
//		for(int i = 0; i < automatoMult.getEstados().size(); i++){
//			System.out.println(automatoMult.getEstados().get(i).getIdentificador());
//		}
		
		for(int i = 0; i < automatoMult.getEstados().size(); i++){
			Estado estado = new Estado(automatoMult.getEstados().get(i).getIdentificador());
			if(!descobreInuRec(automatoMult, novoEstadoInicial, estado)){
				//System.out.println(novoEstadoInicial.getIdentificador()+" "+estado.getIdentificador());
				automatoMult.getEstados().get(i).setIdentificador("naoValido");
				//automatoMult.getEstados().remove(i);
			}
			mem.clear();
		}
//		for(int i = 0; i < automatoMult.getEstados().size(); i++){
//			System.out.println(automatoMult.getEstados().get(i).getIdentificador());
//		}
		
		return automatoMult;
		
	}
	
	public static boolean descobreInuRec(Automato automato, Estado estado, Estado procurado){//Descobre estados inúteis.
//		System.out.println("dfur");
//		for(int k = 0; k < mem.size(); k++){
//			System.out.println(mem.get(k));
//		}
		if(mem.contains(estado.getIdentificador())) {
			//System.out.println("dfur");
			return false;
		}
		if(estado.getIdentificador().equals(procurado.getIdentificador())) return true;
		mem.add(estado.getIdentificador());
		ArrayList<Boolean> lista = new ArrayList<Boolean>();
		
		for(int k = 0; k < automato.getSimbolos().size(); k++){
			String simbolo = automato.getSimbolos().get(k);
			for(int i=0; i < automato.getTransicoes().size(); i++){
				if(automato.getTransicoes().get(i).getEstado().equals(estado.getIdentificador()) && automato.getTransicoes().get(i).getSimbolo().equals(simbolo)){
					Estado estadoprox = new Estado(automato.getTransicoes().get(i).getResposta());
					//System.out.println(estadoprox.getIdentificador());
					boolean aux = descobreInuRec(automato, estadoprox, procurado);
					lista.add(aux);
				}
			}
		}
		
		if(lista.contains(true)) return true;
		
		else{
			//System.out.println(estado.getIdentificador());
			return false;
		}
	}
	
	public static void descobreSe1ContemA(Automato auto1, Automato autoa, Automato autoMult){//Checa se A é contido em 1
		boolean aux1 = true;
		boolean aux2 = false;
		for(int i = 0; i< autoMult.getEstados().size(); i++){
			if (!autoMult.getEstados().get(i).equals("naoValido")){
				String[] temp = autoMult.getEstados().get(i).getIdentificador().split(" ");
				
				if(temp.length == 2){
					//System.out.println("dur "+temp[0]+" "+temp[1]);
					if (autoa.getTerminal().contains(temp[1])){
						if(!auto1.getTerminal().contains(temp[0])) aux1 = false;
					}
					if (!autoa.getTerminal().contains(temp[1])){
						if(auto1.getTerminal().contains(temp[0])) aux2 = true;
					}
				}
			}
		}
		if(aux1 && aux2) E = true;
		if(aux1 && !aux2) C = true;
	}
	
	public static void descobreSeAContem1(Automato auto1, Automato autoa, Automato autoMult){//Checa se 1 é contido em A
		boolean aux1 = true;
		boolean aux2 = false;
		for(int i = 0; i< autoMult.getEstados().size(); i++){
			if (!autoMult.getEstados().get(i).equals("naoValido")){
				String[] temp = autoMult.getEstados().get(i).getIdentificador().split(" ");
				if(temp.length == 2){
					if (auto1.getTerminal().contains(temp[0])){
						if(!autoa.getTerminal().contains(temp[1])) aux1 = false;
					}
					if (!auto1.getTerminal().contains(temp[0])){
						if(autoa.getTerminal().contains(temp[1])) aux2 = true;
					}
				}
			}
		}
		if(aux1 && aux2) D = true;
		if(aux1 && !aux2) B = true;
	}
	
	public static void disjuntas(Automato auto1, Automato autoa, Automato autoMult){//Método que testa se são disjuntas
		boolean aux1 = true;
		for(int i = 0; i< autoMult.getEstados().size(); i++){
			if (!autoMult.getEstados().get(i).equals("naoValido")){
				String[] temp = autoMult.getEstados().get(i).getIdentificador().split(" ");
				if(temp.length == 2){
					if (auto1.getTerminal().contains(temp[0])){
						if(autoa.getTerminal().contains(temp[1])) aux1 = false;
					}
					if (autoa.getTerminal().contains(temp[1])){
						if(auto1.getTerminal().contains(temp[0])) aux1 = false;
					}
				}
			}
		}
		A = aux1;
	}
	
	public static void criaTerminal(Automato auto1, Automato autoa, Automato autoMult){
		ArrayList<String> term = new ArrayList<String>();
		for(int i = 0; i< autoMult.getEstados().size(); i++){
			String[] temp = autoMult.getEstados().get(i).getIdentificador().split(" ");
			if(temp.length == 2){
				if (auto1.getTerminal().contains(temp[0])){
					if(autoa.getTerminal().contains(temp[1])) term.add(autoMult.getEstados().get(i).getIdentificador());
				}
			}
		}
		autoMult.setTerminal(term);
	}
	
	public static String criaa(Automato autoMult){
		//int i=0;
		String resp = "";
		String ident = autoMult.getInicial();
		while(!autoMult.getTerminal().contains(ident)){
			for(int i = 0; i< autoMult.getTransicoes().size(); i++){
				if(autoMult.getTransicoes().get(i).getEstado().equals(ident)){
					resp = resp + autoMult.getTransicoes().get(i).getSimbolo();
					ident = autoMult.getTransicoes().get(i).getResposta();
				}
			}
		}
		if(resp.equals("")) resp = "lambda(palavra vazia)";
		return resp;
	}
	
	public static String criab(Automato um, Automato a){
		//int i=0;
		String resp = "";
		String resp2 = "";
		String ident = um.getInicial();
		String ident2 = a.getInicial();
		while(!um.getTerminal().contains(ident) && resp.equals(resp2)){
			for(int i = 0; (i< um.getTransicoes().size()) && (i< a.getTransicoes().size()); i++){
				if(um.getTransicoes().get(i).getEstado().equals(ident)  && a.getTransicoes().get(i).getEstado().equals(ident2)){
					resp = resp + um.getTransicoes().get(i).getSimbolo();
					ident = um.getTransicoes().get(i).getResposta();
					resp2 = resp2 + a.getTransicoes().get(i).getSimbolo();
					ident2 = a.getTransicoes().get(i).getResposta();
				}
			}
		}
		if(resp.equals("")) resp = "lambda(palavra vazia)";
		return resp;
	}
	
	public static Automato getAuto (String arq){//Método que cria o automato a partir de um txt.
		
		ArrayList<Estado> estados = new ArrayList<Estado>();
		ArrayList<String> simbolos = new ArrayList<String>();
		ArrayList<Transicao> transicoes = new ArrayList<Transicao>();
		ArrayList<String> terminal = new ArrayList<String>();
		String inicial = " ";
		
		File file = new File(arq);  
        try {  
        	FileReader reader = new FileReader(arq);  
        	BufferedReader input = new BufferedReader(reader);  
        	String linha;  
        	
        	for (int indice = 0; (linha = input.readLine()) != null; indice++) { 
        		if (indice == 0){
        			String[] temp = linha.split(" ");
        			for(int i=0; i<temp.length;i++){
        				estados.add(new Estado(temp[i]));
        				//System.out.println(temp[i]+" "+i);
        			}
        		}
        		if (indice == 1){
        			String[] temp = linha.split(" ");
        			for(int i=0; i<temp.length;i++){
        				simbolos.add((temp[i]));
        				//System.out.println(temp[i]);
        			}
        		}
        		if((indice > 1)&&(indice < (estados.size()+2))){
        			String[] temp = linha.split(" ");
        			for(int i=0; i<temp.length;i++){
        				transicoes.add(new Transicao(estados.get(indice-2).getIdentificador(), temp[i],simbolos.get(i)));
        				//System.out.println(estados.get(indice-2).getIdentificador()+" "+temp[i]+" "+simbolos.get(i));
        			}
        			
        		}
        		if(indice == estados.size()+2 ){
        			String[] auxIni = linha.split(" ");
        			inicial = auxIni[0];
        		}
        		if(indice == estados.size()+3 ){
        			String[] temp = linha.split(" ");
        			for(int i=0; i<temp.length;i++){
        				terminal.add(temp[i]);
        				//System.out.println(temp[i]);
        			}
        		}
        		//System.out.println(linha);  
        	}  
        	simbolos1 = simbolos;
        	terminal1 = terminal;
        	input.close();  
        	} catch (IOException ioe) {  
        		System.out.println(ioe);  
        	}  
        return new Automato(estados,simbolos,transicoes, inicial, terminal);
	}




}
