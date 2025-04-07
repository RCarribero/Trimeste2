package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.List;

class equipo {
    private String codigoEquipo;
    private List<String> unicoCodigoEquipo = new ArrayList<>();
    private String nombreEquipo;
    private List<jugador> listJugadores = new ArrayList<>();
    private final int capacidadMax = 5;

    int getCapacidadMax() {
        return capacidadMax;
    }

    String getCodigoEquipo() {
        return codigoEquipo;
    }

    void borrarJugador(jugador jugador) {
        this.listJugadores.remove(jugador);
    }

    void setCodigoEquipo(String codigoEquipo) {
        if (unicoCodigoEquipo.contains(codigoEquipo)) 
            throw new IllegalArgumentException("El codigo de equipo ya esta en uso");
        if (!codigoEquipo.matches("^EQ-[A-Z]{3}$")) 
            throw new IllegalArgumentException("El codigo de equipo tiene un formato incorrecto");
        this.codigoEquipo = codigoEquipo;
        unicoCodigoEquipo.add(codigoEquipo);
    } 
    
    
    

    String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public String toString() {
        return "equipo [codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo + ", listJugadores="
                + listJugadores + ", capacidadMax=" + capacidadMax + "]";
    }

    void setNombreEquipo(String nombreEquipo) {
        if (nombreEquipo.matches("^[a-zA-Z\\s]{3,50}$")) {
            this.nombreEquipo = nombreEquipo;
        } else {
            throw new IllegalArgumentException("El nombre de equipo tiene un formato incorrecto");
        }
    }

    List<jugador> getListJugadores() {
        return listJugadores;
    }

    void setListJugadores(jugador jugador) {
        if (listJugadores.size() < capacidadMax) {
            this.listJugadores.add(jugador);
        } else {
            throw new IllegalArgumentException("El equipo ya esta lleno");
        }
    }

}
