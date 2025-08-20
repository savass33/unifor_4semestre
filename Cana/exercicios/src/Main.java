import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

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

        // Construção da BST balanceada
        arvore.construirBST(lista);

        // Escolha do método de ordenação
        System.out.println("Escolha o método de ordenação:");
        System.out.println("1 - Insertion Sort");
        System.out.println("2 - Selection Sort");
        int metodo = sc.nextInt();
        arvore.setMetodoOrdenacao(metodo == 1 ? "insertion" : "selection");

        // Ordenação e tempo
        arvore.ordenarElementos();

        // Impressão da árvore como vetor
        arvore.imprimirComoVetor();

        // Impressão da árvore visualmente (horizontal)
        System.out.println("\nÁrvore visual (BST balanceada):");
        arvore.imprimirArvore(arvore.raiz);

        // Tempo da ordenação
        arvore.mostrarTempo();

        sc.close();
    }
}
