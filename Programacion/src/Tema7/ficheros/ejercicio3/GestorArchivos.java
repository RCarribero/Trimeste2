package Tema7.ficheros.ejercicio3;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class GestorArchivos {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ GESTOR DE ARCHIVOS ---");
            System.out.println("1. Mostrar información de una ruta");
            System.out.println("2. Comprobar existencia");
            System.out.println("3. Crear archivo/directorio");
            System.out.println("4. Eliminar archivo/directorio");
            System.out.println("5. Copiar archivo");
            System.out.println("6. Mover o renombrar archivo");
            System.out.println("7. Leer archivo de texto");
            System.out.println("8. Escribir en archivo de texto");
            System.out.println("9. Listar contenido de un directorio");
            System.out.println("10. Comparar rutas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    mostrarInformacionRuta();
                    break;
                case 2:
                    comprobarExistencia();
                    break;
                case 3:
                    crearArchivoODirectorio();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    copiarArchivo();
                    break;
                case 6:
                    moverArchivo();
                    break;
                case 7:
                    leerArchivoTexto();
                    break;
                case 8:
                    escribirEnArchivoTexto();
                    break;
                case 9:
                    listarContenidoDirectorio();
                    break;
                case 10:
                    compararRutas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void mostrarInformacionRuta() {
        Path path = pedirRuta("Introduce la ruta:");
        System.out.println("Nombre del archivo: " + path.getFileName());
        System.out.println("Ruta absoluta: " + path.toAbsolutePath());
        System.out.println("Ruta padre: " + path.getParent());
        System.out.println("Número de elementos en la ruta: " + path.getNameCount());
    }

    public static void comprobarExistencia() {
        Path path = pedirRuta("Introduce la ruta:");
        System.out.println("¿Existe?: " + Files.exists(path));
        System.out.println("¿Es archivo regular?: " + Files.isRegularFile(path));
        System.out.println("¿Es directorio?: " + Files.isDirectory(path));
    }

    public static void crearArchivoODirectorio() {
        Path path = pedirRuta("Introduce la ruta a crear:");
        System.out.print("¿Qué quieres crear? (archivo/directorio): ");
        String tipo = scanner.nextLine().trim().toLowerCase();

        try {
            switch (tipo) {
                case "archivo":
                    Files.createFile(path);
                    System.out.println("Archivo creado.");
                    break;
                case "directorio":
                    Files.createDirectories(path);
                    System.out.println("Directorio creado.");
                    break;
                default:
                    System.out.println("Tipo no válido. Escribe 'archivo' o 'directorio'.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
    }

    public static void eliminar() {
        Path path = pedirRuta("Introduce la ruta a eliminar:");
        try {
            boolean eliminado = Files.deleteIfExists(path);
            System.out.println(eliminado ? "Eliminado correctamente." : "No se encontró la ruta.");
        } catch (IOException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }

    public static void copiarArchivo() {
        Path origen = pedirRuta("Ruta del archivo origen:");
        Path destino = pedirRuta("Ruta del archivo destino:");
        try {
            Files.copy(origen, destino); 
            System.out.println("Archivo copiado con éxito.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: el archivo de destino ya existe.");
        } catch (IOException e) {
            System.out.println("Error al copiar: " + e.getMessage());
        }
    }

    public static void moverArchivo() {
        Path origen = pedirRuta("Ruta del archivo origen:");
        Path destino = pedirRuta("Ruta del archivo destino:");
        try {
            Files.move(origen, destino); 
            System.out.println("Archivo movido/renombrado con éxito.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error: ya existe un archivo en la ruta de destino.");
        } catch (IOException e) {
            System.out.println("Error al mover: " + e.getMessage());
        }
    }

    public static void leerArchivoTexto() {
        Path path = pedirRuta("Ruta del archivo a leer:");
        try {
            List<String> lineas = Files.readAllLines(path);
            System.out.println("--- Contenido del archivo ---");
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void escribirEnArchivoTexto() {
        Path path = pedirRuta("Ruta del archivo:");
        System.out.print("Texto a escribir: ");
        String texto = scanner.nextLine();
        try {
            Files.write(path, (texto + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Texto escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void listarContenidoDirectorio() {
        Path path = pedirRuta("Ruta del directorio:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            System.out.println("--- Contenido del directorio ---");
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error al listar contenido: " + e.getMessage());
        }
    }

    public static void compararRutas() {
        Path ruta1 = pedirRuta("Primera ruta:");
        Path ruta2 = pedirRuta("Segunda ruta:");

        System.out.println("¿Son iguales?: " + ruta1.equals(ruta2));
        System.out.println("¿La primera empieza con la segunda?: " + ruta1.startsWith(ruta2));

        try {
            Path relativa = ruta1.relativize(ruta2);
            System.out.println("Ruta relativa de la primera a la segunda: " + relativa);
        } catch (IllegalArgumentException e) {
            System.out.println("No se pueden relativizar porque no comparten raíz.");
        }
    }

    public static Path pedirRuta(String mensaje) {
        System.out.print(mensaje + " ");
        return Paths.get(scanner.nextLine());
    }
}
