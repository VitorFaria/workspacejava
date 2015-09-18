import java.util.Scanner;

/**
 * Programa de exibição de uma tabela de multiplicação em que o usuário inser o número da tabela
 * a ser exibida.
 * 
 * @author Vitor Faria
 * @version 21-12-2010
 */

public class TabelaDeMultiplicação {
	private void exibeTabelaDeMultiplicação( final int n){
		int contador =1;
		System.out.println("O número " + n + " é multiplicado na tabela");
		while(contador < 13){//Eibe de 2 a 12
			System.out.print( contador + " x " + n);
			System.out.println( " = " +contador * n);
			contador = contador +1;
		}
	}
	private int lêNúmeroDaTabela(){
		final Scanner in = new Scanner( System.in );
		System.out.print( "Que tabela (2-12)? ");
		return in.nextInt();
	}
	private void calculaTabela(){
		int x = lêNúmeroDaTabela();
		if((x < 2) || (x > 12)){
			System.out.println("Não é possível imprimir essa tabela.");
		}
		else {
			exibeTabelaDeMultiplicação( x );
		}
	}

	public static void main(String[] args) {
		final TabelaDeMultiplicação objeto = new TabelaDeMultiplicação();
		objeto.calculaTabela();
	}

}
