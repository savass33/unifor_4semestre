package arvore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("Bem-vindo ao construtor de Árvore Binária!");
        System.out.println("Escolha a forma de inserção dos elementos:");
        System.out.println("1 - Pré-ordem");
        System.out.println("2 - Em ordem (in-order)");
        System.out.println("3 - Pós-ordem");
        int escolha = scanner.nextInt();

        System.out.println("Digite os números a serem inseridos (digite -1 para parar):");
        int[] valores = new int[100]; // Suporta até 100 elementos
        int count = 0;

        while (true) {
            int valor = scanner.nextInt();
            if (valor == -1)
                break;
            valores[count++] = valor;
        }

        // Inserção conforme a escolha
        switch (escolha) {
            case 1:
                System.out.println("Construindo árvore usando Pré-ordem:");
                for (int i = 0; i < count; i++) {
                    arvore.inserir(valores[i]);
                }
                break;
            case 2:
                System.out.println("Construindo árvore usando In-ordem:");
                for (int i = 0; i < count; i++) {
                    arvore.inserir(valores[i]);
                }
                break;
            case 3:
                System.out.println("Construindo árvore usando Pós-ordem:");
                for (int i = 0; i < count; i++) {
                    arvore.inserir(valores[i]);
                }
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println("\nÁrvore final:");
        arvore.imprimirArvoreVisual(arvore.raiz, 0);

        System.out.println("\nTravessias da árvore:");
        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.print("In-ordem: ");
        arvore.inOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz);
        System.out.println();
    }
}
