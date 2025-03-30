package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.List;

public class equipo {
    private String codigoEquipo;

    private List<String> unicoCodigoEquipo = new ArrayList<>();
    private String nombreEquipo;
    private List<jugador> listJugadores = new ArrayList<>();
    private final int capacidadMax = 5;
    /**
     * @return the capacidadMax
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void borrarJugador(jugador jugador) {
        this.listJugadores.remove(jugador);
    }

    public void setCodigoEquipo(String codigoEquipo) {
        if (!unicoCodigoEquipo.contains(codigoEquipo)) {
            if (codigoEquipo.matches("^EQ-[A-Z]{3}$")) {
                this.codigoEquipo = codigoEquipo;
                unicoCodigoEquipo.add(codigoEquipo);
            } else {
                throw new IllegalArgumentException("El codigo de equipo tiene un formato incorrecto");
            }
        } else {
            throw new IllegalArgumentException("El codigo de equipo ya esta en uso");
        }

    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public String toString() {
        return "equipo [codigoEquipo=" + codigoEquipo + ", nombreEquipo=" + nombreEquipo + ", listJugadores="
                + listJugadores + ", capacidadMax=" + capacidadMax + "]";
    }

    public void setNombreEquipo(String nombreEquipo) {
        if (nombreEquipo.matches("^[a-zA-Z\\s]{3,50}$")) {
            this.nombreEquipo = nombreEquipo;
        } else {
            throw new IllegalArgumentException("El nombre de equipo tiene un formato incorrecto");
        }
    }

    public List<jugador> getListJugadores() {
        return listJugadores;
    }

    public void setListJugadores(jugador jugador) {
        if (listJugadores.size() < capacidadMax) {
            this.listJugadores.add(jugador);
        } else {
            throw new IllegalArgumentException("El equipo ya esta lleno");
        }
    }

}
