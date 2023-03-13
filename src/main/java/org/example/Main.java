package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();
        int termino = 0;
        int valor = 0;
        String palabra = "";
        do {
            System.out.println("Ingrese un termino");
            termino = sc.nextInt();
            System.out.println("Ingrese un valor");
            valor = sc.nextInt();
            polinomio.agregarTermino(termino, valor);
            System.out.println("Ingrese una palabra");
            palabra = sc.next();
        } while (!palabra.equals(""));
        //polinomio.mostrarPolinomioCompleto();
    }
}