package org.example;

import java.util.Scanner;

public class Main {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese los términos del polinomio en formato de pares (coeficiente, exponente), separados por comas");
            System.out.println("Por ejemplo, para el polinomio 2x^2 + 3x + 1, ingrese '2,2,3,1,1,0'");
            String input = scanner.nextLine();

            Polinomio polinomio = new Polinomio();
            String[] terminos = input.split(",");
            for (int i = 0; i < terminos.length; i += 2) {
                float valor = Float.parseFloat(terminos[i]);
                int termino = Integer.parseInt(terminos[i + 1]);
                polinomio.cargarTermino(valor, termino);
            }

            System.out.println("Polinomio ingresado:");
            polinomio.mostrar();

            System.out.println("Grado del polinomio: " + polinomio.obtenerGrado());

            System.out.println("Ingrese los términos de otro polinomio para sumarlos");
            input = scanner.nextLine();
            Polinomio otroPolinomio = new Polinomio();
            terminos = input.split(",");
            for (int i = 0; i < terminos.length; i += 2) {
                float valor = Float.parseFloat(terminos[i]);
                int termino = Integer.parseInt(terminos[i + 1]);
                otroPolinomio.cargarTermino(valor, termino);
            }
            Polinomio resultadoSuma = polinomio.sumar(otroPolinomio);
            System.out.println("Resultado de la suma:");
            resultadoSuma.mostrar();

            scanner.close();
        }
}


