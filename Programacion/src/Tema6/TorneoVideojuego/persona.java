package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.List;

public class persona {
    
    private String idJugador;

    private List<String> unicoIdJugador = new ArrayList<>();
    private String nombre;
    private int edad;
    public void removeID(jugador jugador) {
        this.unicoIdJugador.remove(jugador.getIdJugador());
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        if (!unicoIdJugador.contains(idJugador)) {
            if (idJugador.matches("^PL-\\d{4}$")) {
                this.idJugador = idJugador;
                unicoIdJugador.add(idJugador);
            } else {
                throw new IllegalArgumentException("El id no cumple el formato correcto");
            }
        } else {
            throw new IllegalArgumentException("El id ya esta registrado");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.matches("^[a-zA-Z\\s]{3,50}$")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El formato del nombre no es correcto");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 12 && edad <= 100) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("La edad debe ser mayor a 12");
        }
    }

}
