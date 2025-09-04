public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Teste de Inserção em Pré-Ordem ---");
        Tree preOrderTree = new Tree();
        preOrderTree.preOrdemInsert(50);
        preOrderTree.preOrdemInsert(30);
        preOrderTree.preOrdemInsert(70);
        preOrderTree.preOrdemInsert(20);
        preOrderTree.preOrdemInsert(40);
        preOrderTree.preOrdemInsert(60);
        preOrderTree.preOrdemInsert(80);
        System.out.println("Árvore Pré-Ordem (antes da ordenação):");
        preOrderTree.printTreeVertical();

        System.out.println("\n--- Teste de Busca em Pré-Ordem (50) ---");
        Node foundNode = preOrderTree.preOrdemSelect(50);
        if (foundNode != null) {
            System.out.println("Nó 50 encontrado em pré-ordem.");
        } else {
            System.out.println("Nó 50 não encontrado em pré-ordem.");
        }

        System.out.println("\n--- Teste de Ordenação Bubble Sort em Pré-Ordem ---");
        preOrderTree.preOrdemBubble();
        System.out.println("Árvore Pré-Ordem (após ordenação):");
        preOrderTree.printTreeVertical();

        System.out.println("\n--- Teste de Inserção em Pós-Ordem ---");
        Tree postOrderTree = new Tree();
        postOrderTree.posOrdemInsert(50);
        postOrderTree.posOrdemInsert(30);
        postOrderTree.posOrdemInsert(70);
        postOrderTree.posOrdemInsert(20);
        postOrderTree.posOrdemInsert(40);
        postOrderTree.posOrdemInsert(60);
        postOrderTree.posOrdemInsert(80);
        System.out.println("Árvore Pós-Ordem (antes da ordenação):");
        postOrderTree.printTreeVertical();

        System.out.println("\n--- Teste de Busca em Pós-Ordem (70) ---");
        foundNode = postOrderTree.posOrdemSelect(70);
        if (foundNode != null) {
            System.out.println("Nó 70 encontrado em pós-ordem.");
        } else {
            System.out.println("Nó 70 não encontrado em pós-ordem.");
        }

        System.out.println("\n--- Teste de Ordenação Bubble Sort em Pós-Ordem ---");
        postOrderTree.posOrdemBubble();
        System.out.println("Árvore Pós-Ordem (após ordenação):");
        postOrderTree.printTreeVertical();

        System.out.println("\n--- Teste de Inserção em Nível ---");
        Tree levelOrderTree = new Tree();
        levelOrderTree.emNivelInsert(50);
        levelOrderTree.emNivelInsert(30);
        levelOrderTree.emNivelInsert(70);
        levelOrderTree.emNivelInsert(20);
        levelOrderTree.emNivelInsert(40);
        levelOrderTree.emNivelInsert(60);
        levelOrderTree.emNivelInsert(80);
        System.out.println("Árvore Em Nível (antes da ordenação):");
        levelOrderTree.printTreeVertical();

        System.out.println("\n--- Teste de Busca em Nível (20) ---");
        foundNode = levelOrderTree.emNivelSelect(20);
        if (foundNode != null) {
            System.out.println("Nó 20 encontrado em nível.");
        } else {
            System.out.println("Nó 20 não encontrado em nível.");
        }

        System.out.println("\n--- Teste de Ordenação Bubble Sort em Nível ---");
        levelOrderTree.emNivelBubble();
        System.out.println("Árvore Em Nível (após ordenação):");
        levelOrderTree.printTreeVertical();

        System.out.println("\n--- Teste com Árvore Desbalanceada (Pré-Ordem) ---");
        Tree unbalancedTree = new Tree();
        unbalancedTree.preOrdemInsert(10);
        unbalancedTree.preOrdemInsert(5);
        unbalancedTree.preOrdemInsert(2);
        unbalancedTree.preOrdemInsert(15);
        unbalancedTree.preOrdemInsert(12);
        System.out.println("Árvore Desbalanceada (Pré-Ordem):");
        unbalancedTree.printTreeVertical();

        System.out.println("\n--- Teste com Árvore Perfeita (Em Nível) ---");
        Tree perfectTree = new Tree();
        perfectTree.emNivelInsert(4);
        perfectTree.emNivelInsert(2);
        perfectTree.emNivelInsert(6);
        perfectTree.emNivelInsert(1);
        perfectTree.emNivelInsert(3);
        perfectTree.emNivelInsert(5);
        perfectTree.emNivelInsert(7);
        System.out.println("Árvore Perfeita (Em Nível):");
        perfectTree.printTreeVertical();

        System.out.println("\n--- Teste com Árvore Imperfeita (Pós-Ordem) ---");
        Tree imperfectTree = new Tree();
        imperfectTree.posOrdemInsert(10);
        imperfectTree.posOrdemInsert(5);
        imperfectTree.posOrdemInsert(15);
        imperfectTree.posOrdemInsert(2);
        imperfectTree.posOrdemInsert(7);
        System.out.println("Árvore Imperfeita (Pós-Ordem):");
        imperfectTree.printTreeVertical();

        System.out.println("\n--- Teste com Árvore Vazia ---");
        Tree emptyTree = new Tree();
        System.out.println("Árvore Vazia:");
        emptyTree.printTreeVertical();
        Node notFound = emptyTree.preOrdemSelect(10);
        if (notFound == null) {
            System.out.println("Busca em árvore vazia retornou null (correto).");
        }
        emptyTree.preOrdemBubble();
        System.out.println("Ordenação em árvore vazia (sem erro).");
    }
}


