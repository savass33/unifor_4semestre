package arvore;



// Classe que representa um nó da árvore
class Node {
    int valor;
    Node esquerda;
    Node direita;

    Node(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}

// Classe que representa a árvore binária
class ArvoreBinaria {
    Node raiz;

    ArvoreBinaria() {
        this.raiz = null;
    }

    // Método para inserir nó seguindo a lógica de árvore binária de busca
    public void inserir(int valor) {
        System.out.println("Inserindo o valor: " + valor);
        raiz = inserirRecursivo(raiz, valor);
        System.out.println("Árvore após inserção de " + valor + ":");
        imprimirArvoreVisual(raiz, 0);
        System.out.println("-----------------------------------");
    }

    // Inserção recursiva
    private Node inserirRecursivo(Node atual, int valor) {
        if (atual == null) {
            System.out.println("Criando nó com valor " + valor);
            return new Node(valor);
        }

        if (valor < atual.valor) {
            System.out.println("Valor " + valor + " menor que " + atual.valor + ", indo para esquerda");
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            System.out.println("Valor " + valor + " maior que " + atual.valor + ", indo para direita");
            atual.direita = inserirRecursivo(atual.direita, valor);
        } else {
            System.out.println("Valor " + valor + " já existe na árvore. Não será inserido.");
        }

        return atual;
    }

    // Impressão da árvore em forma visual simples
    public void imprimirArvoreVisual(Node node, int nivel) {
        if (node == null) return;

        imprimirArvoreVisual(node.direita, nivel + 1);

        for (int i = 0; i < nivel; i++)
            System.out.print("    ");
        System.out.println(node.valor);

        imprimirArvoreVisual(node.esquerda, nivel + 1);
    }

    // Travessias
    public void preOrdem(Node node) {
        if (node == null) return;
        System.out.print(node.valor + " ");
        preOrdem(node.esquerda);
        preOrdem(node.direita);
    }

    public void inOrdem(Node node) {
        if (node == null) return;
        inOrdem(node.esquerda);
        System.out.print(node.valor + " ");
        inOrdem(node.direita);
    }

    public void posOrdem(Node node) {
        if (node == null) return;
        posOrdem(node.esquerda);
        posOrdem(node.direita);
        System.out.print(node.valor + " ");
    }
}
