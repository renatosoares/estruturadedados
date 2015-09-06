/**
 * 
 */
package fila;

import java.util.Scanner;

/**
 * @author renato
 *
 */

class Estrutura_de_Dados {
  
    /*
     * Tanto a Pilha como a Fila, os vetores suportam
     * até 1000 elementos e cada elemento é do tipo
     * String.
     * 
     * O programa possui um menu principal que permite
     * a escolha do tipo de estrutura de dados a ser
     * utilizado.
    */ 
  
  
    static int Numero_Maximo_de_Elementos = 1000;
  
  
    public Estrutura_de_Dados(){
      
        // Instanciando as classes Pilha e Fila
        Pilha p = new Pilha();
        Fila  f = new Fila();
        Deque d = new Deque();
      
        int Tipo_de_Estrutura_de_Dados = 0;
      
        while ( Tipo_de_Estrutura_de_Dados != 3 ) {
          
            // Menu Principal
            System.out.println("====== MENU PRINCIPAL ======");
            System.out.println(" 1 - PILHA");
            System.out.println(" 2 - FILA");
            System.out.println(" 3 - SAIR");
            System.out.println(" 4 - DEQUE");
            System.out.println("============================");
          
            System.out.print(" Escolha o tipo de Estrutura de Dados: ");
            Tipo_de_Estrutura_de_Dados = new Scanner (System.in).nextInt();
          
            if ( Tipo_de_Estrutura_de_Dados == 1) p.play();
            if ( Tipo_de_Estrutura_de_Dados == 2) f.play();
            if ( Tipo_de_Estrutura_de_Dados == 4) d.play();
            if ( Tipo_de_Estrutura_de_Dados == 3) break;
          
            if ((Tipo_de_Estrutura_de_Dados < 1) || (Tipo_de_Estrutura_de_Dados > 3))
                System.out.println("Opção Inválida!");
          
        }
      
    }

  
    // Método Principal
    public static void main (String [] args){
      
        new Estrutura_de_Dados().getClass();
      
    }
  
  
  
  
  
    class Pilha {
      
        String A[] = new String[Numero_Maximo_de_Elementos];
        int topo = 0;
      
      
        // Método para Inserir elementos na Pilha
        public void Push() {
          
            if (topo == Numero_Maximo_de_Elementos)
                System.out.println("A Pilha está cheia");
          
            else {
                  
                    System.out.print("Digite o elemento a ser inserido na pilha: ");
                    String cadeia;
                    cadeia = new Scanner (System.in).next();
                    A[topo] = cadeia;
                    topo++;
   
           }
  
        }
 
 
        // Método para Retirar elementos da Pilha
        public void Pop() {
  
            if (topo == 0)
                System.out.println("A Pilha está vazia!");
                else
                    topo--;
  
        }
 
 
        // Método para Exibir elementos da Pilha
        public void Exibir() {
          
            System.out.print("Pilha: ");
          
            for (int i=0; i<topo; i++)
                System.out.print(A[i] + "  ");
          
            System.out.print("\n");
          
        }
 
 
        // Método para Remover todos elementos da Pilha
        public void Clear() {
          
            System.out.println("Pilha Limpa!");
            topo = 0;
  
        }
 
 
        // Método Gerenciador da Pilha
        public void play() {
  
            boolean Executar = true;
          
            System.out.println("\n======= MENU PILHA =======");
            System.out.println("1 - Inserir na Pilha");
            System.out.println("2 - Retirar da Pilha");
            System.out.println("3 - Limpar Pilha");
            System.out.println("4 - Exibir a Pilha");
            System.out.println("5 - Sair");
            System.out.println("============================");
          
            while (Executar == true) {
   
                int opcao = 0;
              
                while ( (opcao < 1) || (opcao > 5) ){
                  
                    System.out.print("Digite opcao: ");
                    opcao = new Scanner (System.in).nextInt();
                  
            }
  
                /* Chamando os métodos de acordo com
                 * a opção selecionada no Menu da Pilha*/
                if (opcao == 1) Push();
                if (opcao == 2) Pop();
                if (opcao == 3) Clear();
                if (opcao == 4) Exibir();
                if (opcao == 5) Executar = false;
              
                System.out.print("\n");
              
            }
  
       }

    }
  
  
  
  
  
    class Fila {
      
    int extensao_da_fila = 0;
    String A[] = new String[Numero_Maximo_de_Elementos];
      
      
        // Método para Inserir elementos na Fila
        public void InserirNaFila() {
 
            if (extensao_da_fila == Numero_Maximo_de_Elementos)
               System.out.println("Fila Cheia");
 
            else {
 
               System.out.print("Digite o elemento a ser inserido na Fila: ");
               A[extensao_da_fila] = new Scanner (System.in).next();
               extensao_da_fila++;
          
            }
        }
      
      
        // Método para Remover elementos da Fila
        public void RemoverDaFila() {
 
            if (extensao_da_fila == 0)
               System.out.println("Fila Vazia: ");
 
            if (extensao_da_fila == 1)
               extensao_da_fila = 0;
 
            if (extensao_da_fila > 1) {
              
               for (int i=0; i < (extensao_da_fila - 1); ++i)
                    A[i] = A[i+1];
              
               extensao_da_fila--;
              
            }
        }
 
      
        // Método para Exibir elementos da Fila
        public void ExibirFila() {
          
            System.out.print("Fila: ");
          
            for (int i=0; i<extensao_da_fila;++i)
                System.out.print(A[i] + "  ");
          
            System.out.print("\n");
          
       }
 
      
        // Método para Retirar todos elementos da Fila
        public void LimparFila() {
          
            System.out.println("Fila Limpa!");
            extensao_da_fila = 0;
          
        }
 
      
        // Método Gerenciador da Fila
        public void play() {
  
            boolean executar = true;
          
            System.out.println("\n======= MENU  FILA =======");
            System.out.println("1 - Inserir na Fila: ");
            System.out.println("2 - Remover da Fila: ");
            System.out.println("3 - Exibir Fila: ");
            System.out.println("4 - Limpar Fila: ");
            System.out.println("5 - Sair ");
            System.out.println("============================");
          
            while (executar == true){
              
           int opcao = 0;
              
           while ( (opcao < 1) || (opcao > 5) ) {
                  
                    System.out.print("Digite opcao: ");
                    opcao = new Scanner (System.in).nextInt();
                  
          }
  
                /* Chamando os métodos de acordo com
                 * a opção selecionada no Menu da Fila*/
                if (opcao == 1) InserirNaFila();
                if (opcao == 2) RemoverDaFila();
                if (opcao == 3) ExibirFila();
                if (opcao == 4) LimparFila();
                if (opcao == 5) executar = false;
              
                System.out.print("\n");
              
            }
          
       }
      
    }
  
}


class Deque {
    
    String A[] = new String[1000];
    int topo = 0;
    
    //int extensao_da_fila = 0;
    //String A[] = new String[Numero_Maximo_de_Elementos];

    // Método para Remover elementos da cabeca
    public void RemoverDaCabeca() {

        if (topo == 0)
           System.out.println("Deque Vazia: ");

        if (topo == 1)
           topo = 0;

        if (topo > 1) {
          
           for (int i=0; i < (topo - 1); ++i)
                A[i] = A[i+1];
          
           topo--;
          
        }
    }
    
    
  
    // Método para Inserir elementos na Calda
    public void Push() {
      
        if (topo == 1000)
            System.out.println("A Pilha está cheia");
      
        else {
              
                System.out.print("Digite o elemento a ser inserido na pilha: ");
                String cadeia;
                cadeia = new Scanner (System.in).next();
                A[topo] = cadeia;
                topo++;

       }

    }


    // Método para Retirar elementos da Calda
    public void Pop() {

        if (topo == 0)
            System.out.println("A Pilha está vazia!");
            else
                topo--;

    }



    // Método para Exibir elementos da Pilha
    public void Exibir() {
      
        System.out.print("Pilha: ");
      
        for (int i=0; i<topo; i++)
            System.out.print(A[i] + "  ");
      
        System.out.print("\n");
      
    }
    public void Pivo(){
    	
    }


    // Método para Remover todos elementos da Pilha
    public void Clear() {
      
        System.out.println("Pilha Limpa!");
        topo = 0;

    }


    // Método Gerenciador da Pilha
    public void play() {

        boolean Executar = true;
      
        System.out.println("\n======= MENU PILHA =======");
        System.out.println("1 - Inserir na Calda");
        System.out.println("2 - Retirar da Calda");
        System.out.println("3 - Limpar Deque");
        System.out.println("4 - Exibir a Deque");
        System.out.println("5 - Sair");
        System.out.println("6 - Remover da Cabeça");
        System.out.println("============================");
      
        while (Executar == true) {

            int opcao = 0;
          
            while ( (opcao < 1) || (opcao > 5) ){
              
                System.out.print("Digite opcao: ");
                opcao = new Scanner (System.in).nextInt();
              
        }

            /* Chamando os métodos de acordo com
             * a opção selecionada no Menu da Pilha*/
            if (opcao == 1) Push();
            if (opcao == 2) Pop();
            if (opcao == 3) Clear();
            if (opcao == 4) Exibir();
            if (opcao == 5) Executar = false;
            if (opcao == 6) RemoverDaCabeca();
          
            System.out.print("\n");
          
        }

   }

}

