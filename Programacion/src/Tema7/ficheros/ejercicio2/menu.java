package Tema7.ficheros.ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class menu {
    public static void main(String[] args) {
        File ficheroEntrada = new File("./src/Tema7/ficheros/ejercicio2/docs/entrada.txt");
        File ficheroSalida = new File("./src/Tema7/ficheros/ejercicio2/docs/salida.txt");
        String cadena="";
        long startTime=System.nanoTime();
        try {
            int caracter;
            FileReader entrada = new FileReader(ficheroEntrada);
            while ((caracter = entrada.read()) != -1) {
                System.out.print((char) caracter);
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime=System.nanoTime();
        System.out.println();
        System.out.println(endTime-startTime);
        startTime=System.nanoTime();
        try {
            String linea;
            try (BufferedReader bufferreader = new BufferedReader(new FileReader(ficheroEntrada))) {
                while ((linea = bufferreader.readLine()) != null) {
                    System.out.println(linea);
                    cadena+=linea;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime=System.nanoTime();
        System.out.println(endTime-startTime);
        startTime=System.nanoTime();
        try {
            FileWriter fileSalida = new FileWriter(ficheroSalida);
            fileSalida.write(cadena);
            fileSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String linea;
            try (BufferedReader fileSalidaMostrar = new BufferedReader(new FileReader(ficheroSalida))) {
                while ((linea = fileSalidaMostrar.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime=System.nanoTime();
        System.out.println(endTime-startTime);
        startTime=System.nanoTime();
        try (BufferedWriter bufferEntrada = new BufferedWriter(new FileWriter(ficheroSalida))) {
            bufferEntrada.write(cadena);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String linea;
            try (BufferedReader fileSalidaMostrar = new BufferedReader(new FileReader(ficheroSalida))) {
                while ((linea = fileSalidaMostrar.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime=System.nanoTime();
        System.out.println(endTime-startTime);
    }
}
