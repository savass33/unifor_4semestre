package teste_gpt;

public class BinaryTreeApp {

    // Node class with backupValue (for restoration)
    Node Node = new Node();

    // Simple linked queue for level-order traversal / insertion (no Java collections)
    static class SimpleQueue {
        static class QNode {
            Node treeNode;
            QNode next;
            QNode(Node n) { treeNode = n; next = null; }
        }
        private QNode head;
        private QNode tail;
        private int size;

        SimpleQueue() { head = tail = null; size = 0; }

        void enqueue(Node n) {
            QNode qn = new QNode(n);
            if (tail == null) head = tail = qn;
            else { tail.next = qn; tail = qn; }
            size++;
        }

        Node dequeue() {
            if (head == null) return null;
            Node n = head.treeNode;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return n;
        }

        boolean isEmpty() { return head == null; }
        int size() { return size; }
    }

    // Enum for traversal type
    enum TraversalType { PRE_ORDER, POST_ORDER, LEVEL_ORDER }

    // BinaryTree with required methods
    static class BinaryTree {
        Node root;

        BinaryTree() { root = null; }

        // Insert following user's requested construction traversal
        void insertByTraversal(int value, TraversalType t) {
            switch (t) {
                case PRE_ORDER: preOrderInsert(value); break;
                case POST_ORDER: postOrderInsert(value); break;
                case LEVEL_ORDER: levelOrderInsert(value); break;
            }
        }

        // PRE-ORDER insertion: traverse root, left, right; insert at the first null child encountered
        void preOrderInsert(int value) {
            Node newNode = new Node(value);
            if (root == null) { root = newNode; return; }
            if (tryPreOrderInsert(root, newNode)) return;
        }

        // recursive helper: returns true if inserted
        private boolean tryPreOrderInsert(Node cur, Node toInsert) {
            // "visit" cur
            // try left child first
            if (cur.left == null) {
                cur.left = toInsert;
                return true;
            } else {
                if (tryPreOrderInsert(cur.left, toInsert)) return true;
            }
            // then right child
            if (cur.right == null) {
                cur.right = toInsert;
                return true;
            } else {
                if (tryPreOrderInsert(cur.right, toInsert)) return true;
            }
            return false;
        }

        // POST-ORDER insertion: traverse left, right, root; insert at first null child encountered while visiting
        void postOrderInsert(int value) {
            Node newNode = new Node(value);
            if (root == null) { root = newNode; return; }
            if (tryPostOrderInsert(root, newNode)) return;
        }

        private boolean tryPostOrderInsert(Node cur, Node toInsert) {
            // go left first
            if (cur.left != null) {
                if (tryPostOrderInsert(cur.left, toInsert)) return true;
            } else {
                // left is null -> insert here (in postorder, we reach left before root)
                cur.left = toInsert;
                return true;
            }

            // then right
            if (cur.right != null) {
                if (tryPostOrderInsert(cur.right, toInsert)) return true;
            } else {
                cur.right = toInsert;
                return true;
            }

            // finally at cur (root of this subtree) - but since this node has both children non-null now, nothing to do here
            return false;
        }

        // LEVEL-ORDER insertion: standard BFS: first node with missing child (left then right)
        void levelOrderInsert(int value) {
            Node newNode = new Node(value);
            if (root == null) { root = newNode; return; }
            SimpleQueue q = new SimpleQueue();
            q.enqueue(root);
            while (!q.isEmpty()) {
                Node cur = q.dequeue();
                if (cur.left == null) { cur.left = newNode; return; }
                else q.enqueue(cur.left);
                if (cur.right == null) { cur.right = newNode; return; }
                else q.enqueue(cur.right);
            }
        }

        // Restore original values using backupValue
        void restoreOriginalValues() {
            restoreRecursive(root);
        }

        private void restoreRecursive(Node cur) {
            if (cur == null) return;
            cur.value = cur.backupValue;
            restoreRecursive(cur.left);
            restoreRecursive(cur.right);
        }

        // Utility traversal outputs (printing values in traversal order)
        void printPreOrder() {
            System.out.print("PreOrder: ");
            printPreOrder(root);
            System.out.println();
        }
        private void printPreOrder(Node cur) {
            if (cur == null) return;
            System.out.print(cur.value + " ");
            printPreOrder(cur.left);
            printPreOrder(cur.right);
        }

        void printPostOrder() {
            System.out.print("PostOrder: ");
            printPostOrder(root);
            System.out.println();
        }
        private void printPostOrder(Node cur) {
            if (cur == null) return;
            printPostOrder(cur.left);
            printPostOrder(cur.right);
            System.out.print(cur.value + " ");
        }

        void printLevelOrder() {
            System.out.print("LevelOrder: ");
            if (root == null) { System.out.println(); return; }
            SimpleQueue q = new SimpleQueue();
            q.enqueue(root);
            while (!q.isEmpty()) {
                Node cur = q.dequeue();
                System.out.print(cur.value + " ");
                if (cur.left != null) q.enqueue(cur.left);
                if (cur.right != null) q.enqueue(cur.right);
            }
            System.out.println();
        }

        // Structural string representation (parentheses) to visualize the tree shape
        @Override
        public String toString() {
            return toStruct(root);
        }
        private String toStruct(Node cur) {
            if (cur == null) return "-";
            if (cur.left == null && cur.right == null) return String.valueOf(cur.value);
            return String.format("%d(%s,%s)", cur.value, toStruct(cur.left), toStruct(cur.right));
        }

        // Count nodes (generic)
        int countNodes() {
            return countNodesRec(root);
        }
        private int countNodesRec(Node cur) {
            if (cur == null) return 0;
            return 1 + countNodesRec(cur.left) + countNodesRec(cur.right);
        }

        // --- Key helper: get node at index in a specific traversal (0-based)
        Node getNodeAtIndexInTraversal(int index, TraversalType t) {
            if (index < 0) return null;
            IndexWrapper iw = new IndexWrapper(index);
            switch (t) {
                case PRE_ORDER:
                    return getNodeAtIndexPre(root, iw);
                case POST_ORDER:
                    return getNodeAtIndexPost(root, iw);
                case LEVEL_ORDER:
                    return getNodeAtIndexLevel(index); // level-order handled iteratively
            }
            return null;
        }

        // wrappers
        static class IndexWrapper { int target; int current = 0; IndexWrapper(int t){ target=t; } }

        private Node getNodeAtIndexPre(Node cur, IndexWrapper iw) {
            if (cur == null) return null;
            if (iw.current == iw.target) return cur;
            iw.current++;
            Node leftResult = getNodeAtIndexPre(cur.left, iw);
            if (leftResult != null) return leftResult;
            Node rightResult = getNodeAtIndexPre(cur.right, iw);
            return rightResult;
        }

        private Node getNodeAtIndexPost(Node cur, IndexWrapper iw) {
            if (cur == null) return null;
            Node leftResult = getNodeAtIndexPost(cur.left, iw);
            if (leftResult != null) return leftResult;
            Node rightResult = getNodeAtIndexPost(cur.right, iw);
            if (rightResult != null) return rightResult;
            if (iw.current == iw.target) return cur;
            iw.current++;
            return null;
        }

        private Node getNodeAtIndexLevel(int index) {
            if (root == null) return null;
            SimpleQueue q = new SimpleQueue();
            q.enqueue(root);
            int i = 0;
            while (!q.isEmpty()) {
                Node cur = q.dequeue();
                if (i == index) return cur;
                i++;
                if (cur.left != null) q.enqueue(cur.left);
                if (cur.right != null) q.enqueue(cur.right);
            }
            return null;
        }

        // --- Sorting algorithm implementations adapted to traversal order ---
        // We implement them using index-based access to avoid arrays.

        // Insertion Sort adapted: shift previous values to insert current in right place.
        void insertionSortByTraversal(TraversalType t) {
            int n = countNodes();
            if (n <= 1) return;
            for (int i = 1; i < n; i++) {
                Node curNode = getNodeAtIndexInTraversal(i, t);
                int key = curNode.value;
                int j = i - 1;
                // shift nodes with value > key to the right
                while (j >= 0) {
                    Node prev = getNodeAtIndexInTraversal(j, t);
                    if (prev.value > key) {
                        // move prev.value to position j+1
                        Node dest = getNodeAtIndexInTraversal(j + 1, t);
                        dest.value = prev.value;
                        j--;
                    } else break;
                }
                Node dest = getNodeAtIndexInTraversal(j + 1, t);
                dest.value = key;
            }
        }

        // Selection Sort adapted
        void selectionSortByTraversal(TraversalType t) {
            int n = countNodes();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                Node minNode = getNodeAtIndexInTraversal(i, t);
                for (int j = i + 1; j < n; j++) {
                    Node candidate = getNodeAtIndexInTraversal(j, t);
                    if (candidate.value < minNode.value) {
                        minNode = candidate;
                        minIndex = j;
                    }
                }
                // swap values at i and minIndex
                if (minIndex != i) {
                    Node ni = getNodeAtIndexInTraversal(i, t);
                    int tmp = ni.value;
                    ni.value = minNode.value;
                    minNode.value = tmp;
                }
            }
        }

        // Bubble Sort adapted (compare adjacent nodes in traversal order)
        void bubbleSortByTraversal(TraversalType t) {
            int n = countNodes();
            if (n <= 1) return;
            boolean swapped;
            for (int pass = 0; pass < n - 1; pass++) {
                swapped = false;
                for (int j = 0; j < n - 1 - pass; j++) {
                    Node a = getNodeAtIndexInTraversal(j, t);
                    Node b = getNodeAtIndexInTraversal(j + 1, t);
                    if (a.value > b.value) {
                        int tmp = a.value;
                        a.value = b.value;
                        b.value = tmp;
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
        }

        // Convenience dispatcher methods with requested names
        // Insert = Insertion Sort adapted; Select = Selection Sort; Bubble = Bubble Sort
        void preOrdemInsert() { insertionSortByTraversal(TraversalType.PRE_ORDER); }
        void posOrdemInsert() { insertionSortByTraversal(TraversalType.POST_ORDER); }
        void emNivelInsert() { insertionSortByTraversal(TraversalType.LEVEL_ORDER); }

        void preOrdemSelect() { selectionSortByTraversal(TraversalType.PRE_ORDER); }
        void posOrdemSelect() { selectionSortByTraversal(TraversalType.POST_ORDER); }
        void emNivelSelect() { selectionSortByTraversal(TraversalType.LEVEL_ORDER); }

        void preOrdemBubble() { bubbleSortByTraversal(TraversalType.PRE_ORDER); }
        void posOrdemBubble() { bubbleSortByTraversal(TraversalType.POST_ORDER); }
        void emNivelBubble() { bubbleSortByTraversal(TraversalType.LEVEL_ORDER); }
    }
}