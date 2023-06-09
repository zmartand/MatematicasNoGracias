package org.example;

import java.util.Scanner;

public class MenuPolinomio {

    public void Menu() {

        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio1 = new Polinomio();
        Polinomio polinomio2 = new Polinomio();
        int opcion = 0;
        do {
            System.out.println("1. Crear Polinomio 1");
            System.out.println("2. Crear Polinomio 2");
            System.out.println("3. Sumar polinomios");
            System.out.println("4. Restar polinomios");
            System.out.println("5. Multiplicar polinomios");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el polinomio 1 en el siguiente formato: 2x^3+5x^2+3x^1+1x^0");
                    scanner.nextLine();
                    String inputPolinomio1 = scanner.nextLine();
                    polinomio1 = crearPolinomioDesdeConsola(inputPolinomio1);
                    break;
                case 2:
                    System.out.println("Ingrese el polinomio 2 en el siguiente formato: 2x^3+5x^2+3x^1+1x^0");
                    scanner.nextLine();
                    String inputPolinomio2 = scanner.nextLine();
                    polinomio2 = crearPolinomioDesdeConsola(inputPolinomio2);
                    break;
                case 3:
                    if (polinomio1 == null || polinomio2 == null) {
                        System.out.println("Debe crear los polinomios primero.");
                        break;
                    }
                    Polinomio suma = polinomio1.sumar(polinomio2);
                    System.out.println("La suma de los polinomios es: " + suma.toString());
                    break;
                case 4:
                    if (polinomio1 == null || polinomio2 == null) {
                        System.out.println("Debe crear los polinomios primero.");
                        break;
                    }
                    Polinomio resta = polinomio1.restar(polinomio2);
                    System.out.println("La resta de los polinomios es: " + resta.toString());
                    break;
                case 5:
                    if (polinomio1 == null || polinomio2 == null) {
                        System.out.println("Debe crear los polinomios primero.");
                        break;
                    }
                    Polinomio producto = polinomio1.multiplicar(polinomio2);
                    System.out.println("El producto de los polinomios es: " + producto.toString());
                    break;

                case 6:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 6);
    }
    public static Polinomio crearPolinomioDesdeConsola(String input) {
        Polinomio polinomio = new Polinomio();
        String[] terminos = input.split("\\+");
        for (String termino : terminos) {
            String[] partes = termino.split("x\\^");
            float valor = Float.parseFloat(partes[0]);
            int exponente = Integer.parseInt(partes[1]);
            polinomio.cargarTermino(valor, exponente);
        }
        return polinomio;
    }
    }

