package com.equipo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ListaSimplementeOrdenada<Integer> lista = new ListaSimplementeOrdenada<>();

        int opcion = 0; // inicializamos para entrar al while

        while (opcion != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Buscar");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número a insertar: ");
                    int n = scan.nextInt();
                    lista.insertar(n);
                    break;

                case 2:
                    System.out.print("Número a eliminar: ");
                    int e = scan.nextInt();
                    boolean eliminado = lista.eliminar(e);
                    if (eliminado) {
                        System.out.println(e + " eliminado de la lista.");
                    } else {
                        System.out.println("Número inválido: no está en la lista.");
                    }
                    break;

                case 3:
                    System.out.println("Lista actual: " + lista);
                    break;

                case 4:
                    System.out.print("Número a buscar: ");
                    int b = scan.nextInt();
                    System.out.println("¿Contiene " + b + "? " + lista.contiene(b));
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        }

        scan.close();
    }
}
