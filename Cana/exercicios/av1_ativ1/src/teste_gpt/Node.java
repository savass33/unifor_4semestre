package teste_gpt;

public class Node {
    int value;
    int backupValue;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.backupValue = value;
        this.left = null;
        this.right = null;
    }

    public Node() {
        //TODO Auto-generated constructor stub
    }
}
