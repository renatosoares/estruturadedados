/**
 * @author https://github.com/renatosoares
 *
 */
package filaEpilha;

import java.util.Scanner;

public class Fila {
	
	int extensaoDaFila = 0;
	String A[] = new String[Appli.NumeroMaximoDeElementos];
	// metodo para gerenciar a fila
	public void play() {
		boolean executar = true;
		while (executar == true) {
			System.out.println("======= MENU  FILA =======");
			System.out.println("1 - Inserir na Fila: ");
			System.out.println("2 - Remover da Fila: ");
			System.out.println("3 - Exibir Fila: ");
			System.out.println("4 - Limpar Fila: ");
			System.out.println("5 - Sair ");
			System.out.println("============================");
			int opcao = 0;
			while ((opcao < 1) || (opcao > 5)) {
				System.out.println("Digite opção: ");
				opcao = new Scanner(System.in).nextInt();
			}
			// chamando os métodos de acordo com a opção selecionada no Menu Fila
			switch (opcao) {
			case 1:
				InserirNaFila();
				break;
			case 2:
				RemoveDaDila();
				break;
			case 3:
				ExibirFila();
				break;
			case 4:
				LimparFila();
				break;
			case 5:
				executar = false;

			default:
				System.out.println("Digito incorreto!");
				break;
			}
			
			System.out.println("\n");
		}

	}
	
	// método para inserri elementos na fila
	public void InserirNaFila() {
		if (extensaoDaFila == Appli.NumeroMaximoDeElementos) {
			System.out.println("Fila cheia!");
		} else {
			System.out.println("Digite o elemento a ser inserido na fila");
			A[extensaoDaFila] = new Scanner (System.in).next();
			extensaoDaFila++;
		}
	}
	// Método para remover elementos da fila
	public void  RemoveDaDila() {
		if (extensaoDaFila == 0) {
			System.out.println("Fila vazia");
		}
		if (extensaoDaFila == 1) {
			extensaoDaFila = 0;
		}
		if (extensaoDaFila > 1) {
			for (int i = 0; i < (extensaoDaFila -1); i++) {
				A[i] = A[i + 1];
				extensaoDaFila--;
			}
		}
	}
	// Método para exibir elementos da fila
	public void ExibirFila() {
		System.out.println("Fila: ");
		for (int i = 0; i < extensaoDaFila; i++) {
			System.out.println(A[i] + " ");
		}
		System.out.println("\n");
	}
	
	public void LimparFila() {
		System.out.println("Fila Limpa");
		extensaoDaFila = 0;
	}
	
	
	

}
