import java.util.LinkedList;
import java.util.Queue;

public class BST <T extends Comparable<T>> {
    private Nodo<T> raiz;

    public BST() {
        this.raiz = null;
    }
    public int getAltura() {
        return getAlturaRecursivo(raiz);
    }
    public int getAlturaRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = getAlturaRecursivo(nodo.getIzquierda());
        int alturaDerecha = getAlturaRecursivo(nodo.getDerecha());
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public void insertar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }
    private void insertarRecursivo(Nodo<T> actual, Nodo<T> nuevo) {
        if (nuevo.getDato().compareTo(actual.getDato()) < 0) {
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(nuevo);
            } else {
                insertarRecursivo(actual.getIzquierda(), nuevo);
            }
        } else {
            if (actual.getDerecha() == null) {
                actual.setDerecha(nuevo);
            } else {
                insertarRecursivo(actual.getDerecha(), nuevo);
            }
        }
    }
    public void inOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            inOrdenRecursivo(nodo.getDerecha());
        }
    }

    public void preOrden() {
        preOrdenRecursivo(raiz);
    }

    private void preOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preOrdenRecursivo(nodo.getIzquierda());
            preOrdenRecursivo(nodo.getDerecha());
        }
    }

    public void postOrden() {
        postOrdenRecursivo(raiz);
    }

    private void postOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.getIzquierda());
            postOrdenRecursivo(nodo.getDerecha());
            System.out.print(nodo.getDato() + " ");
        }
    }
    public void printTree(Nodo<T> nodo) {
        int h = getAltura();
        printRecursivo(nodo, h);
        
    }
    public void printRecursivo(Nodo<T> nodo, int h) {
        if (nodo == null) {
            System.out.print("  ");
        }
        
    }
    public static void main(String[] args) {
        BST<Integer> arbol = new BST<>();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido InOrden:");
        arbol.inOrden();
        System.out.println();

        System.out.println("Recorrido PreOrden:");
        arbol.preOrden();
        System.out.println();

        System.out.println("Recorrido PostOrden:");
        arbol.postOrden();
        System.out.println("Árbol visual:");
        
    }
    
}
