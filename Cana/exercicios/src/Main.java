import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Escolha do modo de construção
        System.out.println("Escolha a forma de construir a árvore:");
        System.out.println("1 - Pré-ordem");
        System.out.println("2 - Pós-ordem");
        System.out.println("3 - Por nível");
        int modo = sc.nextInt();
        String modoStr = modo == 1 ? "preordem" : modo == 2 ? "posordem" : "nivel";

        // Entrada de elementos
        System.out.println("Digite quantos elementos deseja inserir: ");
        int n = sc.nextInt();
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            lista.add(sc.nextInt());
        }

        // Construção da árvore
        arvore.construirArvore(lista, modoStr);

        // Escolha do método de ordenação
        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Insertion Sort");
        System.out.println("2 - Selection Sort");
        int metodo = sc.nextInt();
        arvore.setMetodoOrdenacao(metodo == 1 ? "insertion" : "selection");

        // Ordenação e tempo
        arvore.ordenarElementos();

        // Árvore na ordem escolhida
        System.out.println("\nÁrvore na ordem escolhida:");
        switch (modoStr) {
            case "preordem":
                arvore.preOrdem(arvore.raiz);
                break;
            case "posordem":
                arvore.posOrdem(arvore.raiz);
                break;
            case "nivel":
                arvore.nivel(arvore.raiz);
                break;
        }

        // Árvore ordenada visualmente
        arvore.construirArvore(arvore.elementos, modoStr); // reconstrói a árvore a partir da lista ordenada
        System.out.println("\n\nÁrvore ordenada (visual):");
        arvore.imprimirArvore(arvore.raiz);

        // Tempo da ordenação
        arvore.mostrarTempo();

        sc.close();
    }
}