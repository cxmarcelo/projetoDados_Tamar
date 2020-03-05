package control;

public class BubbleSort {

	public void troca(int a, int b) {
		int aux = a;
		a = b;
		b = aux;
	}

	public void bubbleSort(int[] vet) {
		for(int i = 0; i < vet.length;i ++) {
			for (int j = 0; j < vet.length; j++) {
				if(vet[i] > vet[j]) {
					int aux = vet[i];
					vet[i] = vet[j];
					vet[j] = aux;
				}
			}
		}
	}


	public static void main(String[] args) {
		int[] vet = {7, 0, 3, 5, 1, 9 ,2, 10, 22, 1};
		BubbleSort b = new BubbleSort();
		b.bubbleSort(vet);
		for(int i = 0; i < vet.length; i++) {
			System.out.println(vet[i]);
		}
	}
}