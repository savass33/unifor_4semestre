import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {

        Random random = new Random();

        int[] lista = new int[10];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextInt(100);
        }
        System.out.println("Lista original: ");
        imprimeLista(lista);

        System.out.println("Lista ordenada com Insertion Sort: ");
        selectionSort(lista);
        imprimeLista(lista);
    }

    public static void imprimeLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int menor = lista[i];
            int indexMenor = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < menor) {
                    menor = lista[j];
                    indexMenor = j;
                }
            }
            int aux = lista[i];
            lista[i] = lista[indexMenor];
            lista[indexMenor] = aux;
        }
    }
}
