package Tema5.ED;

import java.util.Scanner;

public class DebugEjercicio2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Solicitar el tamaño del array
		System.out.print("Introduce el tamaño del array: ");
		int n = scanner.nextInt();

		// Generar el array de números aleatorios
		int[] numeros = generarArrayAleatorio(n);
		System.out.print("Array generado: ");
		imprimirArray(numeros);

		// Calcular y mostrar el máximo
		int maximo = calcularMaximo(numeros);
		System.out.println("Número máximo: " + maximo);

		// Calcular y mostrar el mínimo
		int minimo = calcularMinimo(numeros);
		System.out.println("Número mínimo: " + minimo);

		// Calcular y mostrar la suma
		int suma = calcularSuma(numeros);
		System.out.println("Suma de los números: " + suma);

		// Calcular y mostrar la media
		double media = calcularMedia(numeros);
		System.out.println("Media de los números: " + media);

		scanner.close();
	}

	// Método para generar un array de números aleatorios
	public static int[] generarArrayAleatorio(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100) + 1; // Generar números entre 1 y 100
		}
		return array;
	}

	// Método para calcular el máximo
	public static int calcularMaximo(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int num : array) {
			if (num > max) { // ERROR: Condición incorrecta (debe ser num > max)
				max = num;
			}
		}
		return max;
	}

	// Método para calcular el mínimo
	public static int calcularMinimo(int[] array) {
		int min = Integer.MAX_VALUE;
		for (int num : array) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	}

	// Método para calcular la suma de los elementos del array
	public static int calcularSuma(int[] array) {
		int suma = 0;
		for (int num : array) {
			suma += num;
		}
		return suma;
	}

	// Método para calcular la media de los elementos del array
	public static double calcularMedia(int[] array) {
		int suma = calcularSuma(array);
		return (double) suma / array.length;
	}

	// Método auxiliar para imprimir el array
	public static void imprimirArray(int[] array) {
		for (int num : array) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}