import java.util.*;

// Nó da árvore
class Node {
    int valor;
    Node esquerda, direita;

    public Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

// Árvore Binária de Busca (BST) Balanceada
class ArvoreBinaria {
    Node raiz;
    List<Integer> elementos = new ArrayList<>();
    String metodoOrdenacao;
    long tempoTotalOrdenacao = 0;

    // Construção da BST balanceada
    public void construirBST(List<Integer> lista) {
        Collections.sort(lista); // garante a propriedade BST
        raiz = construirBSTRec(lista, 0, lista.size() - 1);
        elementos = new ArrayList<>(lista);
    }

    private Node construirBSTRec(List<Integer> lista, int inicio, int fim) {
        if (inicio > fim)
            return null;
        int meio = (inicio + fim) / 2;
        Node no = new Node(lista.get(meio));
        no.esquerda = construirBSTRec(lista, inicio, meio - 1);
        no.direita = construirBSTRec(lista, meio + 1, fim);
        return no;
    }

    // Travessias clássicas
    public void emOrdem(Node raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }

    public void preOrdem(Node raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public void posOrdem(Node raiz) {
        if (raiz != null) {
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.print(raiz.valor + " ");
        }
    }

    // Configura o método de ordenação
    public void setMetodoOrdenacao(String metodo) {
        this.metodoOrdenacao = metodo;
    }

    // Ordena os elementos da lista
    public void ordenarElementos() {
        long inicio = System.nanoTime();
        if ("insertion".equals(metodoOrdenacao)) {
            insertionSort(elementos);
        } else {
            selectionSort(elementos);
        }
        long fim = System.nanoTime();
        tempoTotalOrdenacao = fim - inicio;
    }

    private void insertionSort(List<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            int chave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, chave);
        }
    }

    private void selectionSort(List<Integer> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(j) < lista.get(minIndex))
                    minIndex = j;
            }
            int temp = lista.get(i);
            lista.set(i, lista.get(minIndex));
            lista.set(minIndex, temp);
        }
    }

    // Mostra o tempo da ordenação
    public void mostrarTempo() {
        double tempoMs = tempoTotalOrdenacao / 1_000_000.0;
        System.out.println("\nTempo gasto pelo " + metodoOrdenacao + " sort: " + tempoMs + " ms");
    }

    // Impressão da árvore horizontal
    public void imprimirArvore(Node node) {
        imprimirArvoreVisual(node, 0);
    }

    private void imprimirArvoreVisual(Node node, int nivel) {
        if (node == null)
            return;

        imprimirArvoreVisual(node.direita, nivel + 1);
        for (int i = 0; i < nivel; i++)
            System.out.print("    ");
        System.out.println(node.valor);
        imprimirArvoreVisual(node.esquerda, nivel + 1);
    }

    // Impressão da árvore como vetor (por nível)
    public void imprimirComoVetor() {
        if (raiz == null) {
            System.out.println("Árvore vazia!");
            return;
        }

        List<Integer> resultado = new ArrayList<>();
        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            resultado.add(atual.valor);
            if (atual.esquerda != null)
                fila.add(atual.esquerda);
            if (atual.direita != null)
                fila.add(atual.direita);
        }

        System.out.println("\nÁrvore como vetor: " + resultado);
    }
}
