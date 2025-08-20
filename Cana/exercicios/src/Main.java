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

        // Entrada de elementos sem repetição
        System.out.println("Digite quantos elementos deseja inserir: ");
        int n = sc.nextInt();
        Set<Integer> conjunto = new HashSet<>();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n;) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            int valor = sc.nextInt();
            if (conjunto.contains(valor)) {
                System.out.println("Valor repetido! Digite outro número.");
            } else {
                conjunto.add(valor);
                lista.add(valor);
                i++; // só incrementa se o valor for válido
            }
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
        System.out.println("\nÁrvore:");
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

        arvore.imprimirComoVetor();

        // Árvore ordenada visualmente
        arvore.construirArvore(arvore.elementos, modoStr); // reconstrói a árvore a partir da lista ordenada
        System.out.println("\n\nÁrvore ordenada (visual):");
        arvore.imprimirArvore(arvore.raiz);

        // Tempo da ordenação
        arvore.mostrarTempo();

        sc.close();
    }
}