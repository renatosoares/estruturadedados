/**
 * @author https://github.com/renatosoares
 *
 */
package filaEpilha;

import java.util.Scanner;

public class Appli {
	public static int NumeroMaximoDeElementos = 1000;
	private Fila filaObjeto;
		
	public Appli() {
		// instanciando as classes Pilha e Fila
		filaObjeto = new Fila();
		
		
		int TipoDeEstruturaDeDados = 0;
		while (TipoDeEstruturaDeDados != 3) {
			//menu principal 
			System.out.println("====== MENU PRINCIPAL ======");
			System.out.println(" 1 - PILHA");
            System.out.println(" 2 - FILA");
            System.out.println(" 3 - SAIR");
			System.out.println("============================");
			
			System.out.println("Escolha o tipo: ");
			
			TipoDeEstruturaDeDados = new Scanner(System.in).nextInt();
			
			switch (TipoDeEstruturaDeDados) {
			case 1:
				System.out.println("Pilha");
				break;
			case 2:
				filaObjeto.play();
				break;
			case 3:
				System.out.println("Sair");
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
			
		}
	}
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		new Appli().getClass();
	}



}
