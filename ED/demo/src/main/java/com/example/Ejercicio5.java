package com.example;

public class Ejercicio5 {
    public String invertir(String entrada) {
        String inverso = "";
        if (entrada.isEmpty()) {
            inverso="";
        } else {
            for (int i = entrada.length()-1; i >= 0; i--) {
                inverso += entrada.charAt(i);
            }
        }
        return inverso;
    }

    public boolean verificarPalindromo(String cadenanumeros) {
        String numero_normal = cadenanumeros;
        String numero_reves = "";
        boolean verificarPalindromo = true;
        if (cadenanumeros.isEmpty()) {
            verificarPalindromo=false;
        }else{
        for (int h = cadenanumeros.length() - 1; h >= 0; h--) {
            char j = cadenanumeros.charAt(h);
            numero_reves += j;
        }
        if (numero_normal.equals(numero_reves)) {
        } else {
            verificarPalindromo = false;
        }
    }
        return  verificarPalindromo;
    }
    public int contarPalabra(String entrada){
        int contador=0;
        if (entrada.isEmpty()) {
            
        }
        for (int i = 0; i < entrada.length(); i++) {
            char caracter=entrada.charAt(i);
            if (Character.isWhitespace(caracter)) {
                contador++;
            }else if (i==entrada.length()-1) {
                contador++;
            }
        }
        if (contador==entrada.length()) {
            contador=0;
        }
        return contador;
    }
    public String concatenar(String a, String b){
        String resultado="";
        if (a.equals("")||b.equals("")) {
            
        }else{
            resultado=a+b;
        }
        return resultado;
    }
}
