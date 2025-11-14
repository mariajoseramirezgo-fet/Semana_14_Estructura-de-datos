package com.equipo;

public class Main{
    public static void main(String[] args) {
        ListaSimplementeOrdenada<Integer> lista = new ListaSimplementeOrdenada<>();
        lista.insertar(5);
        lista.insertar(2);
        lista.insertar(8);
        lista.insertar(2); // duplicado
        lista.insertar(1);
        System.out.println("Lista ordenada inicial: " + lista);
        System.out.println("Contiene 2? " + lista.contiene(2));
        System.out.println("Contiene 7? " + lista.contiene(7));
        lista.eliminar(2); // elimina primera ocurrencia de 2
        System.out.println("Tras eliminar un 2: " + lista);
        lista.eliminar(1);
        System.out.println("Tras eliminar 1: " + lista);
        System.out.println("Tamaño final: " + lista.tamaño());

    }
}