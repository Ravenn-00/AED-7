public class LinkedBST <T extends Comparable<T>> {
    private Node<T> root;
    public LinkedBST() {
        this.root = null;
    }
    public LinkedBST(Node<T> root) {
        this.root = root;
    }
    public void insert(T data) throws ItemDuplicated {
        Node<T> nuevo = new Node<T>(data);
        if (root == null) {
            root = nuevo;
            return;
        }
        if (insertRe(root, nuevo) == null) {
            throw new ItemDuplicated("item duplicado");
        }
    }
    private Node<T> insertRe(Node<T> current, Node<T> nuevo) {
        if (nuevo.data.compareTo(current.data) == 0) {
            return null;
        } else if (nuevo.data.compareTo(current.data) < 0) {
            if (current.left == null) {
                current.left = nuevo;
                return nuevo;
            } else {
                return insertRe(current.left, nuevo);
            }
        } else {
            if (current.right == null) {
                current.right = nuevo;
                return nuevo;
            } else {
                return insertRe(current.right, nuevo);
            }
        }
    }
    public void delete(T data) throws ExceptionIsEmpty {
        if (root == null)
            throw new ExceptionIsEmpty("arbol vacio");
        root = deleteRec(root, data);
    }
    private Node<T> deleteRec(Node<T> node, T data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<T> min = minValueNode(node.right);
            node.data = min.data;
            node.right = deleteRec(node.right, min.data);
        }
        return node;
    }
    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null) current = current.left;
        return current;
    }
    public T search(T data) throws ItemNotFound {
        Node<T> res = searchRec(root, data);
        if (res == null)
            throw new ItemNotFound("No encontrado: " + data);
        return res.data;
    }
    private Node<T> searchRec(Node<T> node, T data) {
        if (node == null)
            return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0)
            return node;
        else if (cmp < 0)
            return searchRec(node.left, data);
        else
            return searchRec(node.right, data);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        return sb.toString().trim();
    }
    private void toStringRec(Node<T> node, StringBuilder sb) {
        if (node != null) {
            toStringRec(node.left, sb);
            sb.append(node.data).append(" ");
            toStringRec(node.right, sb);
        }
    }
    public void destroyNodes() {
        root = null;
    }
    public int countAllNodes() {
        return countAllNodesRec(root);
    }
    private int countAllNodesRec(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
    }
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<T> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public int amplitude() {
        if (root == null)
            return 0;
        java.util.Queue<Node<T>> queue = new java.util.LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            maxWidth = Math.max(maxWidth, count);
            for (int i = 0; i < count; i++) {
                Node<T> n = queue.poll();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
        return maxWidth;
    }

    public int areaBTS() {
        return countLeaves(root);
    }

    private int countLeaves(Node<T> node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public void drawBST() {
        drawBSTRec(root, 0);
    }

    private void drawBSTRec(Node<T> node, int level) {
        if (node == null) return;
        drawBSTRec(node.right, level + 1);
        for (int i = 0; i < level; i++) System.out.print("    ");
        System.out.println(node.data);
        drawBSTRec(node.left, level + 1);
    }

    public boolean sameArea(LinkedBST<T> other) {
        if (root == null && (other == null || other.root == null)) {
            return true;
        }
        if (root == null || other == null || other.root == null) {
            return false;
        }
        return countLeaves(this.root) == countLeaves(other.root);
    }

    public void parenthesize() {
        parenthesizeRec(root);
    }

    private void parenthesizeRec(Node<T> node) {
        if (node == null) return;
        System.out.print(node.data);
        if (node.left != null || node.right != null) {
            System.out.print("(");
            if (node.left != null) parenthesizeRec(node.left);
            else System.out.print("null");
            System.out.print(",");
            if (node.right != null) parenthesizeRec(node.right);
            else System.out.print("null");
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();

        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);

            System.out.println("arbol BST:");
            bst.drawBST();

            System.out.println("inorden:");
            System.out.println(bst.toString());

            System.out.println("buscar 40: " + bst.search(40));

            System.out.println("total de nodos: " + bst.countAllNodes());

            System.out.println("altura: " + bst.height());

            System.out.println("amplitud: " + bst.amplitude());

            System.out.println("area hojas: " + bst.areaBTS());

            System.out.print("parentizado: ");
            bst.parenthesize();
            System.out.println();

            LinkedBST<Integer> bst2 = new LinkedBST<>();
            bst2.insert(10);
            bst2.insert(5);
            bst2.insert(15);
            bst2.drawBST();
            System.out.println("compara: " + bst.sameArea(bst2));

            bst.delete(70);
            System.out.println("eliminar 70:");
            bst.drawBST();

        } catch (ItemDuplicated | ItemNotFound | ExceptionIsEmpty e) {
            System.out.println("excp: " + e.getMessage());
        }
    }
}