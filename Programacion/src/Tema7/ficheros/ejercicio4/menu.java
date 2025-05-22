package Tema7.ficheros.ejercicio4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class menu {
    public static void main(String[] args) {
        String entrada = "src/Tema7/ficheros/ejercicio4/docs/in/alumnos.csv";
        String salida = "src/Tema7/ficheros/ejercicio4/docs/out/salida.txt", linea = "";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(entrada));
            if (!new File(salida).exists()) {
                File creacion = new File(salida);
                creacion.getParentFile().mkdirs();
                creacion.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(salida));
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    String nombre = partes[0].trim();
                    String apellido1 = partes[1].trim();
                    double nota1 = Double.parseDouble(partes[3].trim());
                    double nota2 = Double.parseDouble(partes[4].trim());
                    double nota3 = Double.parseDouble(partes[5].trim());
                    double media = (nota1 + nota2 + nota3) / 3;
                    String notaMedia = getCalificaiones(media);
                    String mediaNumero= String.format("%.2f",media);
                    bw.write(nombre + " " + apellido1 + " " + mediaNumero + " " + notaMedia);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCalificaiones(double media) {
        String k = null;
        if (media < 5) {
            k = "suspenso";
        } else if (media > 5 && media < 7) {
            k = "bien";
        } else if (media > 7 && media < 9) {
            k = "notable";
        } else if (media > 9 && media <= 10) {
            k = "sobresaliente";
        }
        return k;
    }
}
