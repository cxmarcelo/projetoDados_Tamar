package control;


public class MargeSort {
	
	public static void margeSort(int[] v, int[] w, int ini, int fim) {
		if(ini < fim) {
			int meio = (ini + fim) / 2;
			margeSort(v, w, ini, meio);
			margeSort(v, w, meio+1, fim);
			intercalar(v, w, ini, meio, fim);
		}
	}
	
	private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
		for(int k = ini; k <= fim; k++) {
			w[k] = v[k];
		}
		int i = ini;
		int j = meio +1;

		for(int k = ini; k <= fim; k++) {
			if(i > meio) v[k] = w[j++];
			else if (j>fim) v[k] = w[i++];
			else if( w[i] < w[j]) v[k] = w[i++];
			else v[k] = w[j++];
		}
	}
	

	public static void main(String[] args) {
		
		int[] vetor = {5, 33, 25, 11, 1, 9, 3, 2};
		int[] vetorb = new int[vetor.length];
		MargeSort.margeSort(vetor, vetorb, 0, vetor.length-1);
		
		for (int i : vetor) {
			System.out.println(i);
		}
	
	}

}
