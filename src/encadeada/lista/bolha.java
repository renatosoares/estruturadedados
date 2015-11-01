package encadeada.lista;


public class bolha {

	public bolha() {
		// TODO Auto-generated constructor stub
		
	}
	public void imprima (){
        // valores a serem ordenados
        int vetor[] = {7,3,9,1,10};
        int temp;
        int contador = 1;
        do{
            for (int i=0; i < vetor.length -1; i++){
                if (vetor[i] > vetor [i+1]){
                    temp = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = temp;
                }
            }
            contador++;
        } while (contador < vetor.length);
        // exibe os números na tela
        String numerosOrdenados = "";
        for (int n : vetor) {
            numerosOrdenados += n+"-";
        }
        System.out.println(numerosOrdenados);
        //System.
        
        //JOptionPane.showMessageDialog(null,numerosOrdenados);
	}

}
