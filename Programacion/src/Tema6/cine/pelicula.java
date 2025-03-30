package Tema6.cine;

import java.util.ArrayList;
import java.util.List;

public class pelicula {
    private static List<String> codigoPeliculaUnico = new ArrayList<>();
    private static String[] generosPelicula = { "Accion", "Drama", "Comedia", "Terror", "Ciencia ficcion",
            "Animacion" };
    private static String[] clasificacionesPelicula = { "ATP", "+13", "+16", "+18" };
    private String codigoPelicula;
    private String tituloPelicula;
    private String generoPelicula;
    private int duracionPelicula;
    private String clasficacionPelicula;

    public pelicula(String string, String string2, String string3, int i, String string4) {
        // TODO Auto-generated constructor stub
    }

    public pelicula() {
        // TODO Auto-generated constructor stub
    }

    public String getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(String codigoPelicula) {
        if (codigoPelicula.matches("^MOV-\\d{4}$") || !codigoPeliculaUnico.contains(codigoPelicula)) {
            codigoPeliculaUnico.add(codigoPelicula);
            this.codigoPelicula = codigoPelicula;
        } else {
            throw new IllegalArgumentException("Codigo de pelicula incorrecto. Formato:(MOV-1234)");
        }
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        if (tituloPelicula.matches("^[a-zA-Z\\s]{3,100}$")) {
            this.tituloPelicula = tituloPelicula;
        } else {
            throw new IllegalArgumentException("Titulo incorrecto. Tiene que tener entre 3 y 100 caracteres");
        }
    }

    public String getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(String generoPelicula) {
        boolean verificacion = true;
        for (String genero : generosPelicula) {
            if (generoPelicula.equalsIgnoreCase(genero)) {
                verificacion = false;
            }
        }
        if (!verificacion) {
            this.generoPelicula = generoPelicula;
        } else {
            throw new IllegalArgumentException(
                    "Genero incorrecto. Generos disponibles: Acción, Drama, Comedia, Terror, Ciencia Ficción, Animación");
        }
    }

    @Override
    public String toString() {
        return "pelicula [codigoPelicula=" + codigoPelicula + ", tituloPelicula=" + tituloPelicula + ", generoPelicula="
                + generoPelicula + ", duracionPelicula=" + duracionPelicula + ", clasficacionPelicula="
                + clasficacionPelicula + "]";
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracionPelicula) {
        if (duracionPelicula > 60 && duracionPelicula < 240) {
            this.duracionPelicula = duracionPelicula;
        } else {
            throw new IllegalArgumentException("La duracion de la pelicula debe estar entre 60 y 240 minutos");
        }
    }

    public int getClasficacionPelicula() {
        int edad = 0;
        switch (clasficacionPelicula) {
            case "ATP":
                edad = 0;
                break;
            case "+13":
                edad = 13;
                break;
            case "+16":
                edad = 16;
                break;
            case "+18":
                edad = 18;
                break;
            default:
                break;
        }
        return edad;
    }

    public void setClasficacionPelicula(String clasficacionPelicula) {
        boolean verificacion = true;
        for (String clasificacion : clasificacionesPelicula) {
            if (clasficacionPelicula.equalsIgnoreCase(clasificacion)) {
                verificacion = false;
            }
        }
        if (!verificacion) {
            this.clasficacionPelicula = clasficacionPelicula;
        } else {
            throw new IllegalArgumentException("La clasificacion de edad debe ser: (ATP, +13, +16, +18)");
        }
    }

}
