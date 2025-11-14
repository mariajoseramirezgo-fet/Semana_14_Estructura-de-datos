package com.equipo;


public class ListaSimplementeOrdenada<T extends Comparable<T>> {
    public void insertarInicio(int i) {
    }

    public void insertarFinal(int i) {
    }

    public void imprimir() {
    }

    public String buscar(int i) {
        return "";
    }

    private static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;
        Nodo(E dato) { this.dato = dato; }
    }

    private Nodo<T> cabeza;
    private int tamaño;

    /** Inserta el elemento manteniendo el orden ascendente. Permite duplicados (se colocan detrás de iguales). */
    public void insertar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (cabeza == null) { // lista vacía
            cabeza = nuevo;
        } else if (valor.compareTo(cabeza.dato) < 0) { // insertar al inicio
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            // avanzar mientras el siguiente sea <= valor para que duplicados queden después
            while (actual.siguiente != null && actual.siguiente.dato.compareTo(valor) <= 0) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    /** Elimina la primera ocurrencia de valor en la lista. Devuelve true si se eliminó. */
    public boolean eliminar(T valor) {
        if (cabeza == null) return false;
        if (cabeza.dato.equals(valor)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }
        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(valor)) {
            // Como está ordenada, si el siguiente es mayor ya no existe valor
            if (actual.siguiente.dato.compareTo(valor) > 0) return false;
            actual = actual.siguiente;
        }
        if (actual.siguiente == null) return false;
        actual.siguiente = actual.siguiente.siguiente;
        tamaño--;
        return true;
    }

    /** Indica si la lista contiene el valor buscado. */
    public boolean contiene(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            int cmp = actual.dato.compareTo(valor);
            if (cmp == 0) return true;
            if (cmp > 0) return false; // ya pasó el lugar donde debería estar
            actual = actual.siguiente;
        }
        return false;
    }

    public int tamaño() { return tamaño; }
    public boolean estaVacia() { return tamaño == 0; }

    /** Devuelve representación textual de la lista. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append(']');
        return sb.toString();
    }
}

