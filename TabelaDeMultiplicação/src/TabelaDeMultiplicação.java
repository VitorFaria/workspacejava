import java.util.Scanner;

/**
 * Programa de exibi��o de uma tabela de multiplica��o em que o usu�rio inser o n�mero da tabela
 * a ser exibida.
 * 
 * @author Vitor Faria
 * @version 21-12-2010
 */

public class TabelaDeMultiplica��o {
	private void exibeTabelaDeMultiplica��o( final int n){
		int contador =1;
		System.out.println("O n�mero " + n + " � multiplicado na tabela");
		while(contador < 13){//Eibe de 2 a 12
			System.out.print( contador + " x " + n);
			System.out.println( " = " +contador * n);
			contador = contador +1;
		}
	}
	private int l�N�meroDaTabela(){
		final Scanner in = new Scanner( System.in );
		System.out.print( "Que tabela (2-12)? ");
		return in.nextInt();
	}
	private void calculaTabela(){
		int x = l�N�meroDaTabela();
		if((x < 2) || (x > 12)){
			System.out.println("N�o � poss�vel imprimir essa tabela.");
		}
		else {
			exibeTabelaDeMultiplica��o( x );
		}
	}

	public static void main(String[] args) {
		final TabelaDeMultiplica��o objeto = new TabelaDeMultiplica��o();
		objeto.calculaTabela();
	}

}
