package Tema7.gestionBibliotecla;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class menu {
    static Scanner input = new Scanner(System.in);
    static Set<libro> listLibros = new HashSet<>();
    static int opcion;
    static boolean verificacion = true;
    static biblioteca biblioteca= new biblioteca();

    public static void main(String[] args) {
        do {
            try {
                System.out.println("-----Menu-de-opciones-----\r\n" + //
                        "Permitir agregar libros al catálogo de la biblioteca\r\n" + //
                        "Evitar duplicados basados en el ISBN del libro\r\n" + //
                        "Mostrar el catálogo completo de libros\r\n" + //
                        "Buscar un libro por su ISBN\r\n" + //
                        "Eliminar un libro del catálogo\r\n" + //
                        "Mostrar libros de un autor específico");
                opcion = input.nextInt();
                input.nextLine();
                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        mostrarLibros();
                        break;
                    case 3:
                        agregarLibroBiblioteca();
                        break;
                    case 4:
                        buscarPorISBN();
                        break;
                    case 5:
                        eliminarLibro();
                        break;
                    case 6:
                        mostrarLibrosAutor();
                        break;
                    case 7:
                        System.out.println("Gracias por usar nuestro programa");
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (opcion != 7);
    }

    private static void mostrarLibrosAutor() {
        String autor = input.nextLine();
        for (libro libro : listLibros) {
            if (libro.getAutor().equals(autor))
            System.out.println(libro);
        }
    }

    private static void eliminarLibro() {
        String ISBN = input.nextLine();
        for (libro libro : listLibros) {
            if (libro.getISBN().equals(ISBN))
            biblioteca.getCatalogo().remove(libro);
        }
    }


    private static void buscarPorISBN() {
        String ISBN = input.nextLine();
        for (libro libro : listLibros) {
            if (libro.getISBN().equals(ISBN))
            System.out.println(libro);
        }
    }

    private static void agregarLibroBiblioteca() {
        for (libro libro : listLibros) {
            System.out.println("----> ISBN: "+libro.getISBN());
        }
        String ISBN = input.nextLine();
        for (libro libro : listLibros) {
            if(libro.getISBN().equals(ISBN))
            biblioteca.setCatalogo(libro);
        }
    }

    private static void mostrarLibros() {
        for (libro libro : listLibros) {
            System.out.println("ISBN: "+libro.getISBN()+" autor: "+libro.getAutor()+" titulo: "+libro.getTítulo());
        }
    }

    private static void agregarLibro() {
        libro libro = new libro();
        do {
            try {
                verificacion = true;
                do {
                    try {
                        verificacion = true;
                        System.out.println("Indica ISBN");
                        libro.setISBN(input.nextLine());
                    } catch (Exception e) {
                        verificacion = false;
                        System.out.println(e);
                    }
                } while (!verificacion);
                do {
                    try {
                        verificacion = true;
                        System.out.println("Indica titulo");
                        libro.setTítulo(input.nextLine());
                    } catch (Exception e) {
                        verificacion = false;
                        System.out.println(e);
                    }
                } while (!verificacion);
                do {
                    try {
                        verificacion = true;
                        System.out.println("Indica Autor");
                        libro.setAutor(input.nextLine());
                    } catch (Exception e) {
                        verificacion = false;
                        System.out.println(e);
                    }
                } while (!verificacion);
                do {
                    try {
                        verificacion = true;
                        System.out.println("Indica año de publicacion");
                        libro.setAnioPublicacion(input.nextInt());
                        input.nextLine();
                    } catch (Exception e) {
                        input.nextLine();
                        verificacion = false;
                        System.out.println(e);
                    }
                } while (!verificacion);
                do {
                    try {
                        verificacion = true;
                        System.out.println("Indica editorial");
                        libro.setEditorial(input.nextLine());
                    } catch (Exception e) {
                        verificacion = false;
                        System.out.println(e);
                    }
                } while (!verificacion);
                listLibros.add(libro);
            } catch (Exception e) {
                verificacion = false;
                System.out.println(e);
            }
        } while (!verificacion);
    }
}
