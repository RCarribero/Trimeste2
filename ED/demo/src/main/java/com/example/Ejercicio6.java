package com.example;

public class Ejercicio6 {
    public static boolean esPrimo(int num) {
        boolean verificaion = true;
        if (num <= 1) {
            verificaion = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                verificaion = false;
            }
        }
        return verificaion;
    }

    public static int factorial(int num) {
        int resultado = 1;
        for (int i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static boolean esPalindromo(String cadenanumeros) {
        String numero_reves = "";
        boolean verificarPalindromo = true;
        if (cadenanumeros.isEmpty()) {
            verificarPalindromo = false;
        } else {
            for (int h = cadenanumeros.length() - 1; h >= 0; h--) {
                char j = cadenanumeros.charAt(h);
                numero_reves += j;
            }
            if (cadenanumeros.equals(numero_reves)) {
                verificarPalindromo = true;
            } else {
                verificarPalindromo = false;
            }
        }
        return verificarPalindromo;
    }

    public static int contarVocales(String cadena) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public static String fibonacci(int num) {
        StringBuilder secuencia = new StringBuilder();
        int anterior = 0, posterior = 1, resultado;
        secuencia.append(anterior).append(posterior);
        for (int i = 2; i < num; i++) {
            resultado = posterior + anterior;
            anterior = posterior;
            posterior = resultado;
            secuencia.append(posterior);
        }
        return secuencia.toString().trim();
    }
}