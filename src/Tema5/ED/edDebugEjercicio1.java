package src.Tema5.ED;

import java.util.Scanner;

public class edDebugEjercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el tamaño del array: ");
        int size = scanner.nextInt();

        // Crear un array para almacenar números
        int[] numeros = new int[size];

        // Llenar el array con números introducidos por el usuario
        for (int i = 0; i < size; i++) {
            System.out.print("Introduce un número para la posición " + i + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Calcular la suma de los números del array
        int suma = calcularSuma(numeros);
        System.out.println("La suma de los números es: " + suma);

        // Calcular el promedio de los números
        double promedio = (double) suma / size;
        System.out.println("El promedio de los números es: " + promedio);

        // Mostrar los números mayores que el promedio
        System.out.println("Números mayores que el promedio:");
        for (int numero : numeros) {
            if (numero > promedio) {
                System.out.println(numero);
            }
        }

        scanner.close();
    }

    // Método para calcular la suma de los elementos de un array
    public static int calcularSuma(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma;
    }
}