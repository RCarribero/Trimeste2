package Tema7.TorneoVideojuego;

import java.util.Arrays;

class jugador extends persona {
    private static final String[] rangos= {"Bronce","Plata","Oro","Diamante","Elite"};
    private String rango;
    private equipo equipo;
    @Override
    public String toString() {
        return "jugador [rango=" + rango + ", IdJugador="+ getIdJugador()+ ", Nombre=" + getNombre() + ", Edad="+ getEdad() + "]";
    }
    String getRango() {
        return rango;
    }
    void setRango(String rango) {
        if (Arrays.asList(rangos).contains(rango)) {
            this.rango = rango;
        }else{
            throw new IllegalArgumentException("El rango debe ser  \"Bronce\", \"Plata\", \"Oro\", \"Diamante\" o \"Élite\" ");
        }
    }
    equipo getEquipo() {
        return equipo;
    }
    void setEquipo(equipo equipo) {
        if (equipo!=null) 
        throw new IllegalArgumentException("Este jugador ya esta asignado a un equipo");
        this.equipo = equipo;
    }
}
