import java.util.Scanner;

/**
 * Um programa pára a leitura de um nome e uma mensagem e sua posterior exibção.
 * 
 * @author Vitor Faria
 * @version 20-11-2010
 */

public class EntradaSaídaBásica {
	private void executaEntradaSaída(){
		Scanner scanner = new Scanner( System.in );
		System.out.print("Digite seu nome:");
		final String nome = scanner.nextLine();
		System.out.print("Digite uma mensagem:");
		final String mensagem = scanner.nextLine();
		System.out.println("\nOi, você é: " + nome);
		System.out.println("E sua mensagem é: " + mensagem + "\n");
	}


	public static void main(String[] args) {
		EntradaSaídaBásica objeto = new EntradaSaídaBásica();
		objeto.executaEntradaSaída();
	}

}
