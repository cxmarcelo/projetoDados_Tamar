package control;

import java.util.Random;

public class TesteOrdenacao {
	
	
	public void testeNaoOrdenado(int qtd) {
		int[] vetor = new int[qtd];
		int[] vetor2 = new int[qtd];
		Random a = new Random();

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = a.nextInt(qtd * 2);
		}
		vetor2 = vetor;
		long tempoInicialBubble = System.currentTimeMillis();
		BubbleSort b = new BubbleSort();
		b.bubbleSort(vetor);
		long tempoFinalBubble = System.currentTimeMillis();

		int[] vetAux = new int[vetor2.length];
		long tempoInicial = System.currentTimeMillis();
		MargeSort.margeSort(vetor2, vetAux, 0, vetor2.length-1);
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Comparando desempenho do BubbleSort com MargeSort em um vetor não ordenado");
		System.out.println("Ordenando vetor de " + qtd + " pelo BubbleSort = " + (tempoFinalBubble - tempoInicialBubble) + " ms");
		System.out.println("Ordenando vetor de " + qtd + " pelo MargeSort = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("\n");
	}
	
	
	
	public void Ordenado(int qtd) {
		int[] vetor = new int[qtd];
		int[] vetor2 = new int[qtd];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i;
		}
		vetor2 = vetor;
		long tempoInicialBubble = System.currentTimeMillis();
		BubbleSort b = new BubbleSort();
		b.bubbleSort(vetor);
		long tempoFinalBubble = System.currentTimeMillis();

		int[] vetAux = new int[vetor2.length];
		long tempoInicial = System.currentTimeMillis();
		MargeSort.margeSort(vetor2, vetAux, 0, vetor2.length-1);
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Comparando desempenho do BubbleSort com MargeSort em um vetor ordenado");
		System.out.println("Ordenando vetor de " + qtd + " pelo BubbleSort = " + (tempoFinalBubble - tempoInicialBubble) + " ms");
		System.out.println("Ordenando vetor de " + qtd + " pelo MargeSort = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("\n");
	}
	
	public void parcialmenteOrdenado(int qtd) {
		int[] vetor = new int[qtd];
		int[] vetor2 = new int[qtd];
		Random a = new Random();

		for (int i = 0; i < vetor.length; i++) {
			if(i < vetor.length /2) {
				vetor[i] = i;
			}else {
				vetor[i] = a.nextInt(qtd * 2);
			}
		}

		vetor2 = vetor;
		long tempoInicialBubble = System.currentTimeMillis();
		BubbleSort b = new BubbleSort();
		b.bubbleSort(vetor);
		long tempoFinalBubble = System.currentTimeMillis();

		int[] vetAux = new int[vetor2.length];
		long tempoInicial = System.currentTimeMillis();
		MargeSort.margeSort(vetor2, vetAux, 0, vetor2.length-1);
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Comparando desempenho do BubbleSort com MargeSort em um vetor parcialmente ordenado");
		System.out.println("Ordenando vetor de " + qtd + " pelo BubbleSort = " + (tempoFinalBubble - tempoInicialBubble) + " ms");
		System.out.println("Ordenando vetor de " + qtd + " pelo MargeSort = " + (tempoFinal - tempoInicial) + " ms");
		System.out.println("\n");
		
	}
	
	
	public static void main(String[] args) {

		//Não ordenados
		
		TesteOrdenacao teste = new TesteOrdenacao();
		
		/*
		teste.testeNaoOrdenado(100);
		teste.testeNaoOrdenado(1000);
		teste.testeNaoOrdenado(10000);
		teste.testeNaoOrdenado(100000);
		teste.testeNaoOrdenado(1000000);
		

		//Ordenados
		teste.Ordenado(100);
		teste.Ordenado(1000);
		teste.Ordenado(10000);
		teste.Ordenado(100000);
		teste.Ordenado(1000000);
		*/
		
		//Parcialmente Ordenados
		teste.parcialmenteOrdenado(100);
		teste.parcialmenteOrdenado(1000);
		teste.parcialmenteOrdenado(10000);
		teste.parcialmenteOrdenado(100000);
		teste.parcialmenteOrdenado(1000000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int quantidade = 2000000;
		int[] vetor = new int[quantidade];
		int[] vetor2 = new int[quantidade];
		Random a = new Random();

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = a.nextInt(2000);
		}
		vetor2 = vetor;
		
		
		long tempoInicialBubble = System.currentTimeMillis();
		BubbleSort b = new BubbleSort();
		b.bubbleSort(vetor);
		long tempoFinalBubble = System.currentTimeMillis();

		int[] vetAux = new int[vetor2.length];
		long tempoInicial = System.currentTimeMillis();
		MargeSort.margeSort(vetor2, vetAux, 0, vetor2.length-1);
		long tempoFinal = System.currentTimeMillis();

		System.out.println("Comparando desempenho do BubbleSort com MargeSort");
		System.out.println("");
		System.out.println("Ordenando vetor de 2.000.000 pelo BubbleSort = " + (tempoFinalBubble - tempoInicialBubble) + " ms");
		System.out.println("");
		System.out.println("Ordenando vetor de 2.000.000 pelo MargeSort = " + (tempoFinal - tempoInicial) + " ms");
		/*
		 for (int i = 0; i < vetor2.length; i++) {
			System.out.println(vetor2[i]);
		}
		*/
	}
}
