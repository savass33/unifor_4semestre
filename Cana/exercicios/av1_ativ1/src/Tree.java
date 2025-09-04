import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    // Métodos de inserção
    public void preOrdemInsert(int data) {
        root = preOrdemInsertRecursive(root, data);
    }

    private Node preOrdemInsertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        // Lógica de inserção em pré-ordem: Raiz, Esquerda, Direita
        // Para simplificar, vamos inserir sempre à esquerda até encontrar um null,
        // depois à direita. Isso criará uma árvore desbalanceada, mas seguirá a ordem.
        // Uma inserção mais sofisticada poderia tentar balancear a árvore.
        if (current.left == null) {
            current.left = new Node(data);
        } else {
            current.right = preOrdemInsertRecursive(current.right, data);
        }
        return current;
    }

    public void posOrdemInsert(int data) {
        root = posOrdemInsertRecursive(root, data);
    }

    private Node posOrdemInsertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        // Lógica de inserção em pós-ordem: Esquerda, Direita, Raiz
        if (current.left == null) {
            current.left = new Node(data);
        } else if (current.right == null) {
            current.right = new Node(data);
        } else {
            // Alterna a inserção entre os filhos para distribuir os nós
            if (Math.random() < 0.5) {
                current.left = posOrdemInsertRecursive(current.left, data);
            } else {
                current.right = posOrdemInsertRecursive(current.right, data);
            }
        }
        return current;
    }

    public void emNivelInsert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = new Node(data);
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = new Node(data);
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Métodos de busca/seleção
    public Node preOrdemSelect(int target) {
        return preOrdemSelectRecursive(root, target);
    }

    private Node preOrdemSelectRecursive(Node current, int target) {
        if (current == null) {
            return null;
        }
        if (current.data == target) {
            return current;
        }
        Node found = preOrdemSelectRecursive(current.left, target);
        if (found != null) {
            return found;
        }
        return preOrdemSelectRecursive(current.right, target);
    }

    public Node posOrdemSelect(int target) {
        return posOrdemSelectRecursive(root, target);
    }

    private Node posOrdemSelectRecursive(Node current, int target) {
        if (current == null) {
            return null;
        }
        Node found = posOrdemSelectRecursive(current.left, target);
        if (found != null) {
            return found;
        }
        found = posOrdemSelectRecursive(current.right, target);
        if (found != null) {
            return found;
        }
        if (current.data == target) {
            return current;
        }
        return null;
    }

    public Node emNivelSelect(int target) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target) {
                return current;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return null;
    }

    // Métodos de ordenação (Bubble Sort adaptado)
    public void preOrdemBubble() {
        // Extrai os valores em pré-ordem
        LinkedList<Integer> values = new LinkedList<>();
        preOrdemTraversal(root, values);

        // Aplica Bubble Sort nos valores
        bubbleSort(values);

        // Reinsere os valores ordenados na árvore na ordem de pré-ordem
        // Isso requer uma reconstrução lógica ou atualização dos nós existentes
        // Para simplificar, vamos criar uma nova árvore com os valores ordenados
        // e atribuir sua raiz à raiz atual. Isso altera a estrutura da árvore.
        Tree sortedTree = new Tree();
        for (int val : values) {
            sortedTree.preOrdemInsert(val);
        }
        this.root = sortedTree.root;
    }

    public void posOrdemBubble() {
        // Extrai os valores em pós-ordem
        LinkedList<Integer> values = new LinkedList<>();
        posOrdemTraversal(root, values);

        // Aplica Bubble Sort nos valores
        bubbleSort(values);

        // Reinsere os valores ordenados na árvore na ordem de pós-ordem
        Tree sortedTree = new Tree();
        for (int val : values) {
            sortedTree.posOrdemInsert(val);
        }
        this.root = sortedTree.root;
    }

    public void emNivelBubble() {
        // Extrai os valores em nível
        LinkedList<Integer> values = new LinkedList<>();
        emNivelTraversal(root, values);

        // Aplica Bubble Sort nos valores
        bubbleSort(values);

        // Reinsere os valores ordenados na árvore na ordem em nível
        Tree sortedTree = new Tree();
        for (int val : values) {
            sortedTree.emNivelInsert(val);
        }
        this.root = sortedTree.root;
    }

    // Métodos auxiliares para percurso e Bubble Sort
    private void preOrdemTraversal(Node node, LinkedList<Integer> values) {
        if (node != null) {
            values.add(node.data);
            preOrdemTraversal(node.left, values);
            preOrdemTraversal(node.right, values);
        }
    }

    private void posOrdemTraversal(Node node, LinkedList<Integer> values) {
        if (node != null) {
            posOrdemTraversal(node.left, values);
            posOrdemTraversal(node.right, values);
            values.add(node.data);
        }
    }

    private void emNivelTraversal(Node node, LinkedList<Integer> values) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            values.add(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    private void bubbleSort(LinkedList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // swap list.get(j) and list.get(j+1)
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Método para impressão da árvore na vertical
    public void printTreeVertical() {
        printTreeVertical(root, "", false);
    }

    private void printTreeVertical(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            printTreeVertical(node.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
            printTreeVertical(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }
}


