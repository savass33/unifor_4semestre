import java.util.Scanner;

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

    // Método para inserir um novo valor
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    // Inserção recursiva
    private Node inserirRec(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }

        return raiz;
    }

    // Percurso em ordem (in-order)
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

}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("Digite quantos elementos deseja inserir: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            int valor = sc.nextInt();
            arvore.inserir(valor);
        }

        System.out.println("\nElementos em ordem (in-order):");
        arvore.emOrdem(arvore.raiz);

        System.out.println("\n\nElementos em pré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\n\nElementos em pós-ordem:");
        arvore.posOrdem(arvore.raiz);

        sc.close();
    }
}
