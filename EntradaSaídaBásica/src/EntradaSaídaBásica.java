import java.util.Scanner;

/**
 * Um programa p�ra a leitura de um nome e uma mensagem e sua posterior exib��o.
 * 
 * @author Vitor Faria
 * @version 20-11-2010
 */

public class EntradaSa�daB�sica {
	private void executaEntradaSa�da(){
		Scanner scanner = new Scanner( System.in );
		System.out.print("Digite seu nome:");
		final String nome = scanner.nextLine();
		System.out.print("Digite uma mensagem:");
		final String mensagem = scanner.nextLine();
		System.out.println("\nOi, voc� �: " + nome);
		System.out.println("E sua mensagem �: " + mensagem + "\n");
	}


	public static void main(String[] args) {
		EntradaSa�daB�sica objeto = new EntradaSa�daB�sica();
		objeto.executaEntradaSa�da();
	}

}
