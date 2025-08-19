package insertion_sort;

import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int[] lista = new int[10];

        // Preenchendo a lista com números aleatórios
        for (int i = 0; i < lista.length; i++) {
            lista[i] = random.nextInt(100); // Números aleatórios entre 0 e 99
        }

        System.out.println("Lista original: ");
        imprimeLista(lista);

        System.out.println("Lista ordenada com Insertion Sort: ");
        insertionSort(lista);
        imprimeLista(lista);

    }

    public static void imprimeLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] lista) {
        for (int i = 1; i < lista.length; i++) {
            int current = lista[i];

            int j = i - 1;

            while (j >= 0 && lista[j] >= current) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = current;
        }
    }
}
