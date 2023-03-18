package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Polinomio p1 = new Polinomio();
        Polinomio p2 = new Polinomio();
        int opcion = 0;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar término a polinomio 1");
            System.out.println("2. Agregar término a polinomio 2");
            System.out.println("3. Modificar término de polinomio 1");
            System.out.println("4. Modificar término de polinomio 2");
            System.out.println("5. Sumar polinomios");
            System.out.println("6. Multiplicar polinomios");
            System.out.println("7. Mostrar polinomio 1");
            System.out.println("8. Mostrar polinomio 2");
            System.out.println("9. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el término: ");
                    int termino1 = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valor1 = scanner.nextInt();
                    p1.agregarTermino(termino1, valor1);
                    break;
                case 2:
                    System.out.print("Ingrese el término: ");
                    int termino2 = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    int valor2 = scanner.nextInt();
                    p2.agregarTermino(termino2, valor2);
                    break;
                case 3:
                    System.out.print("Ingrese el término a modificar: ");
                    int termino3 = scanner.nextInt();
                    System.out.print("Ingrese el nuevo valor: ");
                    int valor3 = scanner.nextInt();
                    p1.modificarTermino(termino3, valor3);
                    break;
                case 4:
                    System.out.print("Ingrese el término a modificar: ");
                    int termino4 = scanner.nextInt();
                    System.out.print("Ingrese el nuevo valor: ");
                    int valor4 = scanner.nextInt();
                    p2.modificarTermino(termino4, valor4);
                    break;
                case 5:
                    //Polinomio suma = p1.sumar(p1, p2);
                    System.out.println("La suma de los polinomios es: ");
                    //suma.mostrarPolinomio();
                    break;
                case 6:
                    Polinomio producto = p1.multiplicar(p2);
                    System.out.println("El producto de los polinomios es: ");
                    producto.mostrarPolinomio();
                    break;
                case 7:
                    System.out.println("El polinomio 1 es: ");
                    p1.mostrarPolinomio();
                    break;
                case 8:
                    System.out.println("El polinomio 2 es: ");
                    p2.mostrarPolinomio();
                    break;
                case 9:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 9);
    }
}


