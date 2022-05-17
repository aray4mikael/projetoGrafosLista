/*
* LISTA DE GRAFOS
* INTEGRANTES:
* MATEUS RAMALHO
* MIKAEL ARAYA
* VICTOR SOUZA
*/


import java.util.Scanner;
import java.util.Random;

class App {
 static Scanner sc = new Scanner(System.in);

	  static int informacaoGrafo[] = new int[2];
	  static int Grafo[][] = new int[1][1];
	  static String verticesDesejados = "";
	  static int numVertices = 0;
	  static int tipoGrafo = 0;
      static int tipoAleatoriedade=1;
      static Random gerador = new Random();
	 

	  public static void ImprimeGrafoMatriz(int g[][]) {
	    for (int i = 0; i < g.length; i++) {
	      System.out.print(i + "-");
	      for (int j = 0; j < g[i].length; j++) {

	        System.out.printf("%4d ", g[i][j]);
	      }
	      System.out.printf("\n");
	    }
	  }

	  public static boolean CaracteristicasGrafo() {
		  

		  	System.out.println("+-------------------------------------------------------+");
	        System.out.println("+------------------Escolha uma Opção--------------------+");
	        System.out.println("+-------------------------------------------------------+");
	        System.out.println("+--------1)Grafo direcionado não-ponderado--------------+");
	        System.out.println("+--------2)Grafo não-direcionado não-ponderado----------+");
	        System.out.println("+--------3)Grafo direcionado ponderado------------------+");
	        System.out.println("+--------4)Grafo não-direcionado ponderado--------------+");
			System.out.println("+-------------------------------------------------------+");
	    tipoGrafo = sc.nextInt();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("+--------Digite 0 para um grafo aleatório---------------+");
        System.out.println("+--------Digite 1 para inserir os valores do grafo------+");
        System.out.println("+-------------------------------------------------------+");        
        tipoAleatoriedade = sc.nextInt();

        if (tipoAleatoriedade==1){

        boolean controle = false;
        while(!controle){
	    System.out.print("Informe a quantidade de vértices(1-9): ");
	    numVertices = sc.nextInt();
         if (numVertices>10 || numVertices<1){
             System.out.println("Valor incorreto");
             
         }
         controle = true;
        }
	    sc.nextLine();
	    
	    System.out.print("Em quais vértices deseja aresta?(escreva dois numeros representando os dois vertices conectados, se for mais de uma aresta de um espaço entre os pares de números) ");
	    verticesDesejados = sc.nextLine();
	    
    } else if (tipoAleatoriedade==0){
        numVertices = gerador.nextInt(9) + 1;
        int aux1 = gerador.nextInt(numVertices)+1;
        int aux2 = gerador.nextInt(numVertices)+1;


        verticesDesejados = ""+aux1+aux2+" ";

    }
	  
	    return true;

	  }

	  public static void insereArestaNaoPonderadoNaoDirecionado(int g[][], int origem, int destino) {
	    g[origem][destino] = 1;
	    g[destino][origem] = 1;
	  }

	  public static void insereArestaPonderadoNaoDirecionado(int g[][], int origem, int destino, int peso) {
	    g[origem][destino] = peso;
	    g[destino][origem] = peso;
	  }

	  public static void insereArestaNaoPonderadoDirecionado(int g[][], int origem, int destino) {
	    g[origem][destino] = 1;
	  }

	  public static void insereArestaPonderadoDirecionado(int g[][], int origem, int destino, int peso) {
	    g[origem][destino] = peso;
	  }

	  public static int retornaOrigem(String auxSplit[], int i) {

	    String auxNum = auxSplit[i].toString();
	    String auxNum2 = auxNum.substring(0, auxNum.length() / 2);
	    int origem = Integer.parseInt(auxNum2);
	    return origem;
	  }

	  public static int retornaDestino(String auxSplit[], int i) {

	    String auxNum = auxSplit[i].toString();
	    String auxNum2 = auxNum.substring(auxNum.length() / 2, auxNum.length());
	    int destino = Integer.parseInt(auxNum2);

	    return destino;
	  }

	  public static void main(String[] args) {
		  int x=0;
		  
		  while (x<10) {
		  

	    boolean caracteristicasCorretas = CaracteristicasGrafo();

	     Grafo = new int[numVertices][numVertices];

	    try {
	      if (caracteristicasCorretas) {
	        String auxSplit[] = verticesDesejados.split(" ");
	        System.out.println("valor de tipo grafo"+tipoGrafo);

	        for (int i = 0; i < auxSplit.length; i++) {

	          int origem = retornaOrigem(auxSplit, i);
	          int destino = retornaDestino(auxSplit, i);

	          if (tipoGrafo == 1) {
	            insereArestaNaoPonderadoDirecionado(Grafo, origem, destino);

	          } else if (tipoGrafo == 2) {
	            insereArestaNaoPonderadoNaoDirecionado(Grafo, origem, destino);
	          }
	          else if (tipoGrafo == 3) {
	            System.out.printf("\nInforme o peso na aresta: [%d->%d]: ", origem, destino);
	            int peso = sc.nextInt();
	            insereArestaPonderadoDirecionado(Grafo, origem, destino, peso);
	          } 
	          else if (tipoGrafo == 4) {
	            System.out.printf("\nInforme o peso na aresta: [%d-%d]: ", origem, destino);
	            int peso = sc.nextInt();
		          insereArestaPonderadoNaoDirecionado(Grafo, origem, destino, peso);
	          }
	          
	       
	        }

	        ImprimeGrafoMatriz(Grafo);
	      } else {

	      }
	    } catch (IndexOutOfBoundsException e) {
	      System.out.println("Erro ao buscar índice na matriz de adjacência.");
	      System.out.println(e);
	    }
	  }
	  }
  
}