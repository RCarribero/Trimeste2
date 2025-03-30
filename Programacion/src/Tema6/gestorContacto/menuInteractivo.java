package Tema6.gestorContacto;

import java.util.Scanner;


public class menuInteractivo {
    static Scanner input = new Scanner(System.in);
    static int opcion = 0;
    static agenda agenda=new agenda();

    public static void main(String[] args) {
        do {
            menu();
            switch (opcion) {
                case 1:
                System.out.println("Indique el telefono");
                String telefono = input.nextLine();
                System.out.println("Indique el email");
                String email = input.nextLine();
                System.out.println("Indica el nombre");
                String nombre = input.nextLine();
                try {
                    agregarContacto(new contacto(nombre, telefono, email));
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
                case 2:
                System.out.println("Indica el nombre del contacto que quiere buscar");
                nombre = input.nextLine();
                buscarContacto(nombre);
                break;
                case 3:
                System.out.println("Indica el nombre del contacto que quiere buscar");
                nombre = input.nextLine();
                eliminarContacto(nombre);
                break;
                case 4:
                mostarContacto();
                break;
                case 5:
                System.out.println("Indica el nombre del contacto que quiere buscar");
                nombre = input.nextLine();
                try {
                System.out.println("Indica la priodidad");
                int prioridad = input.nextInt();
                    favortioContacto(nombre, prioridad);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
                default:
                break;
            }
        } while (opcion != 6);
    }

    private static void menu() {
        System.out.println("**MENÚ AGENDA**\r\n" + //
                "1️⃣ Agregar un nuevo contacto\r\n" + //
                "2️⃣ Buscar un contacto\r\n" + //
                "3️⃣ Eliminar un contacto\r\n" + //
                "4️⃣ Mostrar todos los contactos\r\n" + //
                "5️⃣ Marcar un contacto como favorito\r\n" + //
                "6️⃣ Salir");
        opcion = input.nextInt();
        input.nextLine();
    }

    static void agregarContacto(contacto contacto){
        agenda.setContactosList(contacto);
    }
    static void buscarContacto(String nombre){
        for (contacto contacto : agenda.getContactosList()) {
            if (nombre.equalsIgnoreCase(contacto.getNombre())) {
                System.out.println(contacto);
            }
        }
    }
    static void eliminarContacto(String nombre){
        for (int i = 0; i < agenda.getContactosList().size(); i++) {
            if (nombre.equalsIgnoreCase(agenda.getContactosList().get(i).getNombre())) {
                agenda.borrarContacto(i);
            }
        }
    }
    static void mostarContacto(){
        for (contacto contacto : agenda.getContactosList()) {
            System.out.println(contacto);
        }
    }
    static void favortioContacto(String nombre, int prioridad){
        for (int i = 0; i < agenda.getContactosList().size(); i++) {
            if (nombre.equalsIgnoreCase(agenda.getContactosList().get(i).getNombre())) {
                String nombre1=agenda.getContactosList().get(i).getNombre();
                String telefono=agenda.getContactosList().get(i).getTelefono();
                String email=agenda.getContactosList().get(i).getEmail();
                eliminarContacto(nombre);
                contactoFavorito contactoTemporal=new contactoFavorito(nombre1,telefono,email, prioridad);
                agenda.getContactosList().add(contactoTemporal);
            }
        }
    }
}