import java.util.Scanner;


public class projeto {

private void exibeContagens(){
	int contador = 1;
	while ( contador < 6 ){
		System.out.println ( contador );
		contador = contador + 1;
	}
}
	public static void main(String[] args) {
		
		String s = "";
		System.out.println("Ola!");
		Scanner sc = new Scanner( System.in );
		s = sc.nextLine();
		System.out.println("Ola!" + s);
		projeto objeto = new projeto();
		objeto.exibeContagens();

	}

}
