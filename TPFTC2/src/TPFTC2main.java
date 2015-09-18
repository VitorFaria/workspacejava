import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TPFTC2main {

	/**
	 * @param args
	 * @author Vitor Faria
	 */
	public static void main(String[] args) {

		Gramatica gramatica = new Gramatica();
//		Método de entrada:
//			Um .txt chamado "entrada" na pasta contendo exprssões do tipo:
//				comando. conteúdo
//		comandos
//			a : definir variavel de partida
//			b : inserir regra
//			c : remover regra
//			d : remover variavel
//			e : listar inúteis
		entrada("entrada.txt", gramatica);

	}
	
	public static ArrayList<String> etapa1(Gramatica gramatica){//Etapa um do algoritmo para determinar variáveis inúteis. Aqui verifica quais variáveis são férteis.
		ArrayList<String> N = new ArrayList<String>();
		ArrayList<String> I = new ArrayList<String>();
		do{
			N.clear();
			for(int i=0; i<gramatica.getRegras().size(); i++){
				String variEsq = gramatica.getRegras().get(i).getVariEsquerda();			
				if(!I.contains(variEsq)){
					ArrayList<String> direita = gramatica.getRegras().get(i).getDireita();
					boolean aux1 = true;
					for(int j=0; j<direita.size(); j++){						
						if( !gramatica.getTerminais().contains(direita.get(j)) && !I.contains(direita.get(j))){
							aux1 = false;
						}
					}
					if(aux1 == true){
						N.add(variEsq);
					}
				}
			}
			I.addAll(N);
			
			
			
		}while(N.size() != 0);
		return I;
	}
	
	public static ArrayList<String> etapa2(Gramatica gramatica, ArrayList<String> vUmaLinha){//Etapa dois do algoritmo para determinar variáveis inúteis. Aqui verifica quais variáveis são alcansáveis.
		ArrayList<String> N = new ArrayList<String>();
		ArrayList<String> Naux = new ArrayList<String>();
		ArrayList<String> vDuasLinhas = new ArrayList<String>();		
		N.add(gramatica.getVinicial());
		do{
			vDuasLinhas.addAll(N);
			Naux.addAll(N);
			N.clear();
			for(int i=0; i<gramatica.getRegras().size(); i++){
				String variEsq = gramatica.getRegras().get(i).getVariEsquerda();
				if(Naux.contains(variEsq)){
					ArrayList<String> direita = gramatica.getRegras().get(i).getDireita();
					boolean aux1 = true;
					ArrayList<String> arrayAux = new ArrayList<String>();
					for(int j=0; j<direita.size(); j++){
						if(!(direita.get(j).startsWith("<")) && !(gramatica.getTerminais().contains((direita.get(j))))){
							aux1 = false;
						}
						if((direita.get(j).startsWith("<")) && !(vUmaLinha.contains((direita.get(j))))){
							aux1 = false;
						}
						if((direita.get(j).startsWith("<")) && !(vDuasLinhas.contains(direita.get(j))) && (vUmaLinha.contains((direita.get(j))))){
							arrayAux.add(direita.get(j));
						}
					}
					if( aux1 == true){
						N.addAll(arrayAux);
					}
				}
			}
			Naux.clear();
			
		}while(N.size() != 0);
		
		return vDuasLinhas;
	}
	
	public static ArrayList<String> listaInuteis(Gramatica gramatica){//Método que lista as variáveis inúteis.
		if (gramatica.getVinicial().isEmpty()){
			ArrayList<String> erro = new ArrayList<String>();
			erro.add("erro");
			return erro;
		}
		ArrayList<String> vUmaLinha = etapa1(gramatica);
		ArrayList<String> vDuasLinhas = etapa2(gramatica, vUmaLinha);
		ArrayList<String> inutil = new ArrayList<String>();
		for(int i = 0; i<gramatica.getVariaveis().size(); i++){
			if ( !vDuasLinhas.contains(gramatica.getVariaveis().get(i)) ){
				inutil.add(gramatica.getVariaveis().get(i));
			}
		}
		return inutil;
	}
	
	public static void insereRegra (Gramatica gramatica, Regra regra){//Método que insere regras novas.
		gramatica.getRegras().add(regra);
		if(!gramatica.getVariaveis().contains(regra.getVariEsquerda())){
			gramatica.getVariaveis().add(regra.getVariEsquerda());
		}
		for(int i=0;i<regra.getDireita().size(); i++){
			if(regra.getDireita().get(i).startsWith("<") && !gramatica.getVariaveis().contains(regra.getDireita().get(i))){
				gramatica.getVariaveis().add(regra.getDireita().get(i));
			}
			if(!regra.getDireita().get(i).startsWith("<") && !gramatica.getTerminais().contains(regra.getDireita().get(i))){
				gramatica.getTerminais().add(regra.getDireita().get(i));
			}
		}
	}
	
	public static void removeRegra (Gramatica gramatica, Regra regra){//Método que remove rgras.
		for(int l=0;l<gramatica.getRegras().size();l++){
			if(gramatica.getRegras().get(l).getVariEsquerda().equals(regra.getVariEsquerda())){
				boolean aux = true;
				for(int m=0;m<gramatica.getRegras().get(l).getDireita().size();m++){
					if(!gramatica.getRegras().get(l).getDireita().get(m).equals(regra.getDireita().get(m))){
						aux = false;
					}
				}
				if(aux) gramatica.getRegras().remove(l); 
			}
		}
		ArrayList<String> var = new ArrayList<String>();
		var.add(regra.getVariEsquerda());
		for(int i=0;i<regra.getDireita().size(); i++){
			if(regra.getDireita().get(i).startsWith("<")){
				var.add(regra.getDireita().get(i));
			}
		}
		for(int i=0;i<var.size(); i++){
			boolean aux = false;
			for(int j=0;j<gramatica.getRegras().size();j++){
				if(gramatica.getRegras().get(j).getVariEsquerda().equals(var.get(i))){
					aux = true;
				}
				for(int k=0;k<gramatica.getRegras().get(j).getDireita().size();k++){
					if(gramatica.getRegras().get(j).getDireita().get(k).equals(var.get(i))){
						aux = true;
					}
				}
			}
			if(aux == false){
				gramatica.getVariaveis().remove(var.get(i));					
			}
		}
	}
	
	public static void removeVariavel (Gramatica gramatica, String variavel){//Método que remove variáveis.
		if(gramatica.getVariaveis().contains(variavel)){
			gramatica.getVariaveis().remove(variavel);
			boolean aux = true;
			for(int j=0;j<gramatica.getRegras().size();j++){
				if(gramatica.getRegras().get(j).getVariEsquerda().equals(variavel)){
					gramatica.getRegras().remove(j);
					aux = false;
				}
				if(aux) for(int k=0;aux && k<gramatica.getRegras().get(j).getDireita().size();k++){
					if(gramatica.getRegras().get(j).getDireita().get(k).equals(variavel)){					
						gramatica.getRegras().remove(j);						
						aux = false;
					}
				}
				aux = true;
			}
		}
	}
	
	public static void setaInicial(Gramatica gramatica, String inicial){//Método que insere a variável inicial.
		gramatica.setVinicial(inicial);		
	}
	
	public static void entrada(String arq, Gramatica gramatica){//Aqui a entrada é lida e o programa é executado.
		try { 
			FileReader reader = new FileReader(arq);  
	    	BufferedReader input = new BufferedReader(reader);  
	    	String linha; 
	    	for (; (linha = input.readLine()) != null;){
	    		String[] temp = linha.split("\\. ");
	    		if(temp[0].equals("a")){
	    			setaInicial(gramatica, temp[1]);
	    			System.out.println(temp[1] + " é a nova variável inicial.");
	    		}
	    		if(temp[0].equals("b")){
	    			String[] temp2 = temp[1].split(" ::= ");	    			
	    			String variEsquerda = temp2[0];
	    			if(temp2.length > 1){
	    				String[] tempDireita = temp2[1].split(" \\| ");	    			
		    			for(int i=0; i<tempDireita.length; i++){
		    				String auxiliar = tempDireita[i];
		    				String [] vetorAuxiliar = auxiliar.split(" ");
		    				ArrayList<String> arrayAuxiliar = new ArrayList<String>();
		    				for(int j=0; j<vetorAuxiliar.length; j++){
		    					arrayAuxiliar.add(vetorAuxiliar[j]);
		    				}
		    				insereRegra(gramatica, new Regra(variEsquerda, arrayAuxiliar));
		    				System.out.println("A regra " + variEsquerda + " ::= " + auxiliar + " foi inserida.");
		    			}
	    			}
	    		}
	    		if(temp[0].equals("c")){
	    			String[] temp2 = temp[1].split(" ::= ");
	    			String variEsquerda = temp2[0];	    			
	    			String[] tempDireita = temp2[1].split(" \\| ");
	    			for(int i=0; i<tempDireita.length; i++){
	    				String auxiliar = tempDireita[i];
	    				String [] vetorAuxiliar = auxiliar.split(" ");
	    				ArrayList<String> arrayAuxiliar = new ArrayList<String>();
	    				for(int j=0; j<vetorAuxiliar.length; j++){
	    					arrayAuxiliar.add(vetorAuxiliar[j]);
	    				}
	    				removeRegra(gramatica, new Regra(variEsquerda, arrayAuxiliar));
	    				System.out.println("A regra " + variEsquerda + " ::= " + auxiliar + " foi removida.");
	    			}
	    		}
	    		if(temp[0].equals("d")){
	    			removeVariavel(gramatica, temp[1]);
	    			System.out.println(temp[1] + " não é mais uma variavel desta gramática.");
	    		}
	    		if(temp[0].equals("e.") || temp[0].equals("e")){
	    			ArrayList<String> inuteis = listaInuteis(gramatica);
	    			for(int i=0; i<inuteis.size(); i++){
	    				System.out.println("Variavel inutil: " + inuteis.get(i));
	    			}
	    		}
	    	}
	    	input.close(); 
		}
    	catch(IOException ioe){
    		System.out.println(ioe);
    	}
	}
	
	

}
