import java.util.*;

// Classe do nó da árvore
class Node {
    int valor;
    Node esquerda, direita;

    public Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

// Classe da árvore binária
class ArvoreBinaria {
    Node raiz;
    List<Integer> elementos = new ArrayList<>();
    String metodoOrdenacao;
    long tempoTotalOrdenacao = 0;

    // Construção da árvore
    public void construirArvore(List<Integer> lista, String modo) {
        switch (modo) {
            case "preordem":
                raiz = construirPreOrdem(lista, 0, lista.size() - 1);
                break;
            case "posordem":
                raiz = construirPosOrdem(lista, 0, lista.size() - 1);
                break;
            case "nivel":
                raiz = construirPorNivel(lista);
                break;
        }
        elementos = new ArrayList<>(lista); // mantém lista dos elementos
    }

    private Node construirPreOrdem(List<Integer> lista, int inicio, int fim) {
        if (inicio > fim)
            return null;
        Node no = new Node(lista.get(inicio));
        int meio = (inicio + fim) / 2;
        no.esquerda = construirPreOrdem(lista, inicio + 1, meio);
        no.direita = construirPreOrdem(lista, meio + 1, fim);
        return no;
    }

    private Node construirPosOrdem(List<Integer> lista, int inicio, int fim) {
        if (inicio > fim)
            return null;
        Node no = new Node(lista.get(fim));
        int meio = (inicio + fim - 1) / 2;
        no.esquerda = construirPosOrdem(lista, inicio, meio);
        no.direita = construirPosOrdem(lista, meio + 1, fim - 1);
        return no;
    }

    private Node construirPorNivel(List<Integer> lista) {
        if (lista.isEmpty())
            return null;
        Node raiz = new Node(lista.get(0));
        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        int i = 1;
        while (i < lista.size()) {
            Node atual = fila.poll();
            if (i < lista.size()) {
                atual.esquerda = new Node(lista.get(i++));
                fila.add(atual.esquerda);
            }
            if (i < lista.size()) {
                atual.direita = new Node(lista.get(i++));
                fila.add(atual.direita);
            }
        }
        return raiz;
    }

    public void setMetodoOrdenacao(String metodo) {
        this.metodoOrdenacao = metodo;
    }

    public void ordenarElementos() {
        long inicio = System.nanoTime();
        if (metodoOrdenacao.equals("insertion")) {
            insertionSort(elementos);
        } else {
            selectionSort(elementos);
        }
        long fim = System.nanoTime();
        tempoTotalOrdenacao = fim - inicio;
    }

    public void mostrarTempo() {
        double tempoMs = tempoTotalOrdenacao / 1_000_000.0;
        System.out.println("\nTempo gasto pelo " + metodoOrdenacao + " sort: " + tempoMs + " ms");
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

    // Travessias
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

    public void nivel(Node raiz) {
        if (raiz == null)
            return;
        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            Node atual = fila.poll();
            System.out.print(atual.valor + " ");
            if (atual.esquerda != null)
                fila.add(atual.esquerda);
            if (atual.direita != null)
                fila.add(atual.direita);
        }
    }

    // Impressão da árvore em pé (raiz em cima, filhos embaixo)
    public void imprimirArvore(Node raiz) {
        int altura = altura(raiz);
        int largura = (int) Math.pow(2, altura) * 2;
        List<Node> nivelAtual = new ArrayList<>();
        nivelAtual.add(raiz);

        for (int i = 1; i <= altura; i++) {
            int espacos = largura / (int) Math.pow(2, i);
            List<Node> proximoNivel = new ArrayList<>();

            // Espaços antes do primeiro nó
            imprimirEspacos(espacos / 2);

            for (Node no : nivelAtual) {
                if (no != null) {
                    System.out.print(no.valor);
                    proximoNivel.add(no.esquerda);
                    proximoNivel.add(no.direita);
                } else {
                    System.out.print(" ");
                    proximoNivel.add(null);
                    proximoNivel.add(null);
                }
                imprimirEspacos(espacos);
            }
            System.out.println();
            nivelAtual = proximoNivel;
        }
    }

    // Calcula a altura da árvore
    private int altura(Node no) {
        if (no == null)
            return 0;
        return 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    // Imprime uma quantidade de espaços
    private void imprimirEspacos(int qtd) {
        for (int i = 0; i < qtd; i++) {
            System.out.print(" ");
        }
    }

}
