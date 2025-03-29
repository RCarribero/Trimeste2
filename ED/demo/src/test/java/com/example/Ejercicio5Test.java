package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Ejercicio5Test {
    Ejercicio5 prueba = new Ejercicio5();
    @Test
    void testConcatenar() {
        assertEquals("holahola", prueba.concatenar("hola", "hola"));
        assertEquals("", prueba.concatenar("", ""));
    }

    @Test
    void testContarPalabra() {
        assertEquals(3, prueba.contarPalabra("Hola como estas"));
        assertEquals(0, prueba.contarPalabra("  "));
        assertEquals(0, prueba.contarPalabra(""));
    }

    @Test
    void testInvertir() {
        assertEquals("aloH", prueba.invertir("Hola"));
        assertEquals("", prueba.invertir(""));
    }

    @Test
    void testVerificarPalindromo() {
        assertTrue(prueba.verificarPalindromo("ana"));
        assertFalse(prueba.verificarPalindromo(""));
    }
}
