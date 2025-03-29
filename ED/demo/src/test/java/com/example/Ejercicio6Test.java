package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Ejercicio6Test {
    @Test
    void testEsPrimo() {
        assertTrue(Ejercicio6.esPrimo(5));
        assertFalse(Ejercicio6.esPrimo(0));
        assertFalse(Ejercicio6.esPrimo(4));
    }

    @Test
    void testFactorial() {
        assertEquals(2, Ejercicio6.factorial(2));
    }

    @Test
    void testContarVocales() {
        assertEquals(3, Ejercicio6.contarVocales("Anales"));
    }

    @Test
    void testEsPalindromo() {
        assertTrue(Ejercicio6.esPalindromo("1221"));
        assertFalse(Ejercicio6.esPalindromo("12281"));
        assertFalse(Ejercicio6.esPalindromo(""));
    }

    @Test
    void testFibonacci() {
        assertEquals("011", Ejercicio6.fibonacci(3));
    }
}
