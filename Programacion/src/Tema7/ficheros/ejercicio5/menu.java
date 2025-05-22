package Tema7.ficheros.ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Tema7.ficheros.ejercicio5.source.*;

public class menu {
    public static void main(String[] args) {
        Set<libro> listLibros = new HashSet();
        Set<usuario> listUsuarios = new HashSet();
        Set<prestamo> listPrestamos = new HashSet();
        Scanner input = new Scanner(System.in);
        String libros = "src/Tema7/ficheros/ejercicio5/docs/in/libros.csv";
        String prestados = "src/Tema7/ficheros/ejercicio5/docs/in/prestamos.csv";
        String usuarios = "src/Tema7/ficheros/ejercicio5/docs/in/usuarios.csv";
        String linea = "";
        BufferedReader brLibros = null, brPrestamos = null, brUsuarios = null;
        BufferedWriter bwLibros = null, bwPrestamos = null, bwUsuarios = null;
        String opcion = null;
        try {
            brLibros = new BufferedReader(new FileReader(libros));
            brPrestamos = new BufferedReader(new FileReader(prestados));
            brUsuarios = new BufferedReader(new FileReader(usuarios));
            brLibros.readLine();
            brPrestamos.readLine();
            brUsuarios.readLine();
            while ((linea = brLibros.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String ISBN = datos[0];
                    String titulo = datos[1];
                    String autor = datos[2];
                    int ejemplaresTotales = Integer.parseInt(datos[3]);
                    int ejemplaresDisponibles = Integer.parseInt(datos[4]);
                    listLibros.add(new libro(ISBN, titulo, autor, ejemplaresTotales, ejemplaresDisponibles));
                }
            }
            while ((linea = brUsuarios.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String apellido = datos[2];
                    listUsuarios.add(new usuario(id, nombre, apellido));
                }
            }
            while ((linea = brPrestamos.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    int id = Integer.parseInt(datos[0]);
                    String isbn = datos[1];
                    LocalDate fechaPrestamo = LocalDate.parse(datos[2]);
                    LocalDate fechaDevolucion = LocalDate.parse(datos[3]);
                    listPrestamos.add(new prestamo(id, isbn, fechaPrestamo, fechaDevolucion));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        do {
            try {
                System.out.println("a) Listar todos los libros, mostrando si están disponibles para préstamo.\r\n" + //
                        "b) Permitir a un usuario realizar un préstamo de un libro (si hay ejemplares disponibles).\r\n"
                        + //
                        "c) Permitir la devolución de un libro.\r\n" + //
                        "d) Mostrar el historial de préstamos de un usuario concreto, incluyendo libros prestados y devueltos.\r\n"
                        + //
                        "e) Permitir añadir nuevos libros y nuevos usuarios al sistema." +
                        "f)Salir.");
                opcion = input.nextLine();

                switch (opcion) {
                    case "a":
                        for (libro libro : listLibros) {
                            if (libro.getEjemplaresDisponibles() > 0) {
                                System.out.println(libro);
                            }
                        }
                        break;
                    case "b":
                        System.out.println("Indique el ISBN del libro: ");
                        String isbnLibro = input.nextLine();
                        System.out.println("Indica su id de usuario");
                        int idUsuario = input.nextInt();
                        input.nextLine();
                        usuario usuarioTemp = null;
                        for (usuario usuario : listUsuarios) {
                            if (usuario.getId() == idUsuario)
                                usuarioTemp = usuario;
                        }
                        for (libro libro : listLibros) {
                            if (libro.getIsbn().equals(isbnLibro) && libro.getEjemplaresDisponibles() > 0) {
                                libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() - 1);
                                listPrestamos.add(new prestamo(usuarioTemp.getId(), libro.getIsbn(), LocalDate.now(),
                                        LocalDate.parse("0001-01-01")));
                            }
                        }
                        break;
                    case "c":
                        System.out.println("Indique el ISBN del libro a devolver: ");
                        isbnLibro = input.nextLine();
                        System.out.println("Indica su id de usuario");
                        idUsuario = input.nextInt();
                        input.nextLine();
                        usuarioTemp = null;
                        for (usuario usuario : listUsuarios) {
                            if (usuario.getId() == idUsuario)
                                usuarioTemp = usuario;
                        }
                        for (prestamo prestamo : listPrestamos) {
                            if (prestamo.getISBN().equals(isbnLibro)
                                    && prestamo.getIDUsuario() == usuarioTemp.getId()) {
                                prestamo.setFechaDevolucion(LocalDate.now());
                                for (libro libro : listLibros) {
                                    if (libro.getIsbn().equals(isbnLibro)) {
                                        libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() + 1);
                                    }
                                }
                            }
                        }

                        break;
                    case "d":
                        System.out.println("Indica su id de usuario");
                        idUsuario = input.nextInt();
                        input.nextLine();
                        System.out.println("Prestados");
                        for (prestamo prestamo : listPrestamos) {
                            if (prestamo.getIDUsuario() == idUsuario
                                    && prestamo.getFechaDevolucion().isBefore(LocalDate.parse("0500-01-01"))) {
                                System.out.println(prestamo);
                            }
                        }
                        System.out.println("Devueltos");
                        for (prestamo prestamo : listPrestamos) {
                            if (prestamo.getIDUsuario() == idUsuario
                                    && prestamo.getFechaDevolucion().isAfter(LocalDate.parse("1000-01-01"))) {
                                System.out.println(prestamo);
                            }
                        }
                        break;
                    case "e":
                        System.out.println("Que quiere añadir, libro o usuario?");
                        opcion = input.nextLine();
                        switch (opcion) {
                            case "usuario":
                                System.out.println("indique id:");
                                idUsuario = input.nextInt();
                                input.nextLine();
                                System.out.println("Indique el nombre");
                                String nombre = input.nextLine();
                                System.out.println("Indique el apellido");
                                String apellido = input.nextLine();
                                listUsuarios.add(new usuario(idUsuario, nombre, apellido));
                                break;
                            case "libro":
                                System.out.println("indique isbn:");
                                isbnLibro = input.nextLine();
                                System.out.println("Indique el titulo");
                                String titulo = input.nextLine();
                                System.out.println("Indique el autor");
                                String autor = input.nextLine();
                                System.out.println("Indique el numeoro de ejemplares");
                                int ejemplares = input.nextInt();
                                input.nextLine();
                                listLibros.add(new libro(isbnLibro, titulo, autor, ejemplares, ejemplares));
                                break;
                            default:
                                System.out.println("Por favor indique un usuario o libro");
                                break;
                        }
                        break;
                    case "f":
                        System.out.println("ciao");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!opcion.equals("f"));
        try {
            brLibros.close();
            brPrestamos.close();
            brUsuarios.close();
            bwLibros = new BufferedWriter(new FileWriter(libros, false));
            bwPrestamos = new BufferedWriter(new FileWriter(prestados, false));
            bwUsuarios = new BufferedWriter(new FileWriter(usuarios, false));
            bwUsuarios.write("ID,Nombre,Apellido\n");
            for (usuario user : listUsuarios) {
                bwUsuarios.write(user.getId() + "," + user.getNombre() + "," + user.getApellido() + "\n");
            }
            bwLibros.write("ISBN,Titulo,Autor,EjemplaresTotal,EjemplaresDisponibles\n");
            for (libro lib : listLibros) {
                bwLibros.write(lib.getIsbn() + "," + lib.getTitulo() + "," + lib.getAutor() + "," +
                        lib.getEjemplaresTotales() + "," + lib.getEjemplaresDisponibles() + "\n");
            }

            bwPrestamos.write("IDUsuario,ISBN,FechaPrestamo,FechaDevolucion\n");
            for (prestamo prest : listPrestamos) {
                bwPrestamos.write(prest.getIDUsuario() + "," + prest.getISBN() + "," +
                        prest.getFechaPrestamo() + "," + prest.getFechaDevolucion() + "\n");
            }
            bwLibros.close();
            bwPrestamos.close();
            bwUsuarios.close();

            input.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar los archivos: " + e.getMessage());
        }
    }
}
