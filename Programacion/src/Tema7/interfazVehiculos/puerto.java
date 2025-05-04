package Tema7.interfazVehiculos;

import java.util.Scanner;

public class puerto {
    static Scanner scaner = new Scanner (System.in);
public static void main(String[] args) {
    int resp=0;
coche coche = new coche("Ford", "si");
barco barco = new barco("Yate", "messi");
amfibio amfibio = new amfibio("juan");
    do {
        System.out.println("1. Coche");
        System.out.println("2. Barco");
        System.out.println("3. Anfibio");
        resp=scaner.nextInt();
        scaner.nextLine();
        switch (resp) { 
            case 1:
            String respuesta="";
            do {
                System.out.println("Dime que opcion quieres hacer: Arrancar Conducir Detener estaEnMarcha Salir");
                respuesta=scaner.nextLine();
                switch (respuesta) {
                    case "Arrancar":
                        coche.arrancar();
                    break;

                    case "Conducir":
                        System.out.println("Dime la distancia que lleva el coche");
                        int num = scaner.nextInt();
                        scaner.nextLine();
                        coche.conducir(num);
                    break;
                    case "Detener":
                        coche.detener();
                    break;
                    case "estaEnMarcha":
                        coche.estaEnMarcha();
                    break;
                    default:
                        break;
                }
            } while (!respuesta.equalsIgnoreCase("Salir"));
            
            break;

            case 2:
            String respuesta1="";
            do {
                System.out.println("Dime que opcion quieres del barco: Arrancar Navegar Detener estaEnMarcha Salir");
                respuesta1=scaner.nextLine();
                
                switch (respuesta1) {
                    case "Arrancar":
                        barco.arrancar();
                    break;
                    case "Navegar":
                        System.out.println("Dime la distancia que ha recorrido el barco");
                        int distancia = scaner.nextInt();
                        scaner.nextLine();
                        barco.navegar(distancia);
                    break;
                    case "Detener":
                        barco.detener();
                    break;
                    case "estaEnMarcha":
                        barco.estaEnMarcha();
                    break;
                    case "Salir":
                        System.out.println("Adios");
                    break;
                    default:
                        break;
                }
            } while (!respuesta1.equalsIgnoreCase("Salir"));
            break;
            
            case 3:


            System.out.println("Dime el modo del amfibio");
            String a = scaner.nextLine();
            if(a.equalsIgnoreCase("tierra")){
                String respuesta2="";
                do {
                    System.out.println("Dime que opcion quieres: Arrancar Conducir Detener Salir");
                    respuesta2=scaner.nextLine();
                    switch (respuesta2) {
                        case "Arrancar":
                            amfibio.arrancar();
                        break;
                        case "Detener":
                            amfibio.detener();
                        break;
                        case "Conducir":
                        System.out.println("Dime la distancia que lleva el amfibio");
                        int respa = scaner.nextInt();
                        scaner.nextLine();
                            amfibio.conducir(respa);
                        break;
                        case "Salir":
                            System.out.println("Adios");
                        break;
                        default:
                            break;
                    }
                } while (!respuesta2.equalsIgnoreCase("salir"));
            }else if(a.equalsIgnoreCase("agua")){
                String respuesta2="";
                do {
                    System.out.println("Dime que opcion quieres: Arrancar Conducir Detener Salir");
                    respuesta2=scaner.nextLine();
                    switch (respuesta2) {
                        case "Arrancar":
                            amfibio.arrancar();
                        break;
                        case "Detener":
                            amfibio.detener();
                        break;
                        case "Navegar":
                        System.out.println("Dime la distancia que lleva el amfibio");
                        int respa = scaner.nextInt();
                        scaner.nextLine();
                            amfibio.navegar(respa);
                        break;
                        case "Salir":
                            System.out.println("Adios");
                        break;
                        default:
                            break;
                    }
                } while (!respuesta2.equalsIgnoreCase("salir"));
            }else{
                System.out.println("No hay ese modo");
            }
            break;
            default:
                break;
        }
    } while (resp!=4);
}
}

