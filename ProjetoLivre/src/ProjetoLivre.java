import java.util.Scanner;

/**
 * Programa livre para testes.
 * 
 * @author Vitor Faria
 * @version 21-12-2010
 */

public class ProjetoLivre {
	
	private String criaUmaString( final int n ){
		String s = "";
		for (int i = 0; i < n; ++i){
			s = s + "# ";
		}
		return s;
	}
	
	private void imprimeTriangulo( final int n ){
		System.out.print( "\n" );
		for ( int i = 0; i < n; ++i ){
			for ( int j = 0; j <= i; ++j){
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
	
	private int solicitaEntradaInteira (){
		System.out.print( "Digite o número inteiro desejado: ");
		Scanner entrada = new Scanner ( System.in );
		return entrada.nextInt();
	}

	public static void main(String[] args) {
		ProjetoLivre objeto = new ProjetoLivre();
		objeto.imprimeTriangulo( objeto.solicitaEntradaInteira() );
		System.out.println ("\n" + objeto.criaUmaString( objeto.solicitaEntradaInteira()) );
	}

}
