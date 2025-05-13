public class Nodo <T> {
    private T dato;
    private Nodo<T> izq;
    private Nodo<T> der;
    public Nodo() {
        this.dato = null;
        this.izq = null;
        this.der = null;
    }
    public Nodo(T dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
    public Nodo(T dato, Nodo<T> izq, Nodo<T> der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    public T getDato() {
        return dato;
    }
    public void setDato(T x) {
        this.dato = x;
    }
    public Nodo<T> getDerecha() {
        return this.der;
    }
    public void setDerecha(Nodo<T> derecha) {
        this.der = derecha;
    }
    public Nodo<T> getIzquierda() {
        return this.izq;
    }
    public void setIzquierda(Nodo<T> izquierda) {
        this.izq = izquierda;
    }
}