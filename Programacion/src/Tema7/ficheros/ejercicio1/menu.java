package Tema7.ficheros.ejercicio1;

import java.io.File;

public class menu {
    public static void main(String[] args) {
        File directorio = new File("./src/Tema7/ficheros/ejercicio1/datos");
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("directorio creado");
            } else {
                System.out.println("No se pudo crear el fichero");
                return;
            }
            File datos = new File(directorio,"datos.txt");
            try {
                if (datos.createNewFile()){

            }else{

            }
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println("Información del archivo datos.txt:");
        System.out.println("¿Es un archivo?: " + datos.isFile());
        System.out.println("¿Es un directorio?: " + datos.isDirectory());
        System.out.println("¿Existe?: " + datos.exists());
        System.out.println("¿Se puede leer?: " + datos.canRead());
        System.out.println("¿Se puede escribir?: " + datos.canWrite());
        System.out.println("¿Se puede ejecutar?: " + datos.canExecute());
        System.out.println("Tamaño: " + datos.length() + " bytes");
        System.out.println("Ruta absoluta: " + datos.getAbsolutePath());
        }
    }
}
