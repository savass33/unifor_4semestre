package teste_gpt;

import java.util.Scanner;

import teste_gpt.BinaryTreeApp.BinaryTree;
import teste_gpt.BinaryTreeApp.TraversalType;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("=== Sistema de Árvore Binária com Ordenação Personalizada ===");
        // choose fill traversal
        System.out.println("Escolha o método de preenchimento da árvore:");
        System.out.println("1 - Pré-ordem");
        System.out.println("2 - Pós-ordem");
        System.out.println("3 - Em nível (level-order)");
        System.out.print("Opção: ");
        int opt = readInt(sc);
        TraversalType fillType = TraversalType.PRE_ORDER;
        if (opt == 1)
            fillType = TraversalType.PRE_ORDER;
        else if (opt == 2)
            fillType = TraversalType.POST_ORDER;
        else if (opt == 3)
            fillType = TraversalType.LEVEL_ORDER;
        else {
            System.out.println("Opção inválida. Assumindo Pré-ordem.");
        }

        System.out.print("Quantos valores deseja inserir? ");
        int n = readInt(sc);
        if (n <= 0) {
            System.out.println("Nenhum elemento para inserir. Encerrando.");
            return;
        }
        System.out.println("Insira " + n + " valores inteiros (um por vez):");
        for (int i = 0; i < n; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            int v = readInt(sc);
            tree.insertByTraversal(v, fillType);
        }

        System.out.println("\nÁrvore construída (estrutura): " + tree.toString());
        tree.printPreOrder();
        tree.printPostOrder();
        tree.printLevelOrder();
        System.out.println();

        while (true) {
            System.out.println("Escolha o algoritmo de ordenação a aplicar (adaptado ao percurso escolhido):");
            System.out.println("1 - Insertion Sort (preOrdemInsert / posOrdemInsert / emNivelInsert)");
            System.out.println("2 - Selection Sort (preOrdemSelect / posOrdemSelect / emNivelSelect)");
            System.out.println("3 - Bubble Sort (preOrdemBubble / posOrdemBubble / emNivelBubble)");
            System.out.println("4 - Restaurar valores originais");
            System.out.println("5 - Mostrar árvore (estrutura e percursos)");
            System.out.println("6 - Finalizar");
            System.out.print("Opção: ");
            int choice = readInt(sc);
            switch (choice) {
                case 1:
                    // insertion sort by initial chosen traversal
                    callInsertSortByType(tree, fillType);
                    System.out.println("Aplicado Insertion Sort adaptado ao percurso " + fillType);
                    displayTraversals(tree);
                    break;
                case 2:
                    callSelectionSortByType(tree, fillType);
                    System.out.println("Aplicado Selection Sort adaptado ao percurso " + fillType);
                    displayTraversals(tree);
                    break;
                case 3:
                    callBubbleSortByType(tree, fillType);
                    System.out.println("Aplicado Bubble Sort adaptado ao percurso " + fillType);
                    displayTraversals(tree);
                    break;
                case 4:
                    tree.restoreOriginalValues();
                    System.out.println("Árvore restaurada para os valores originais.");
                    displayTraversals(tree);
                    break;
                case 5:
                    System.out.println("Estrutura: " + tree.toString());
                    displayTraversals(tree);
                    break;
                case 6:
                    System.out.println("Finalizando. Bom trabalho!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
    }

    // Helper read int with scanner
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next(); // skip
            System.out.print("Digite um inteiro válido: ");
        }
        return sc.nextInt();
    }

    private static void displayTraversals(BinaryTree tree) {
        tree.printPreOrder();
        tree.printPostOrder();
        tree.printLevelOrder();
    }

    private static void callInsertSortByType(BinaryTree tree, TraversalType t) {
        switch (t) {
            case PRE_ORDER:
                tree.preOrdemInsert();
                break;
            case POST_ORDER:
                tree.posOrdemInsert();
                break;
            case LEVEL_ORDER:
                tree.emNivelInsert();
                break;
        }
    }

    private static void callSelectionSortByType(BinaryTree tree, TraversalType t) {
        switch (t) {
            case PRE_ORDER:
                tree.preOrdemSelect();
                break;
            case POST_ORDER:
                tree.posOrdemSelect();
                break;
            case LEVEL_ORDER:
                tree.emNivelSelect();
                break;
        }
    }

    private static void callBubbleSortByType(BinaryTree tree, TraversalType t) {
        switch (t) {
            case PRE_ORDER:
                tree.preOrdemBubble();
                break;
            case POST_ORDER:
                tree.posOrdemBubble();
                break;
            case LEVEL_ORDER:
                tree.emNivelBubble();
                break;

        }
    }
}