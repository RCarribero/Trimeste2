package Tema6.TorneoVideojuego;

import java.util.Arrays;

public class jugador extends persona {
    private static final String[] rangos= {"Bronce","Plata","Oro","Diamante","Elite"};
    
    private String rango;
    private equipo equipo;
    @Override
    public String toString() {
        return "jugador [rango=" + rango + ", IdJugador="+ getIdJugador()+ ", Nombre=" + getNombre() + ", Edad="+ getEdad() + "]";
    }
    public String getRango() {
        return rango;
    }
    public void setRango(String rango) {
        if (Arrays.asList(rangos).contains(rango)) {
            this.rango = rango;
        }else{
            throw new IllegalArgumentException("El rango debe ser  \"Bronce\", \"Plata\", \"Oro\", \"Diamante\" o \"Élite\" ");
        }
    }
    public equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(equipo equipo) {
        this.equipo = equipo;
    }
}
