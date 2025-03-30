package Tema6.TorneoVideojuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class torneo {
    private String codigoTorneo;
    private static List<String> unicoCodigoTorneo=new ArrayList<>();
    private String nombreTorneo;
    private List<equipo> ListEquipos=new ArrayList<>();
    private static Map<equipo, Integer> puntuaciones=new HashMap<>();

    public String getCodigoTorneo() {
        return codigoTorneo;
    }
    public void setCodigoTorneo(String codigoTorneo) {
        if (!unicoCodigoTorneo.contains(codigoTorneo)) {
            if (codigoTorneo.matches("^T-\\d{4}-\\d{2}$")) {
                unicoCodigoTorneo.add(codigoTorneo);
                this.codigoTorneo = codigoTorneo;
            }else{
                throw new IllegalArgumentException("Formato de codigo incorrecto");
            }
        }else{
            throw new IllegalArgumentException("Codigo en uso");
        }
    }
    public String getNombreTorneo() {
        return nombreTorneo;
    }
    public void setNombreTorneo(String nombreTorneo) {
        if (nombreTorneo.matches("^[a-zA-Z\\s]{3,50}$")) {
            this.nombreTorneo = nombreTorneo;
        }else{
            throw new IllegalArgumentException("Formato de nombre incorrecto");
        }
    }
    public List<equipo> getListEquipos() {
        return ListEquipos;
    }
    public void setListEquipos(equipo equipo) {
        if (ListEquipos.contains(equipo)) {
            throw new IllegalArgumentException("El equipo ya esta añadido");
        }else{
            ListEquipos.add(equipo);
        }
    }
    @Override
    public String toString() {
        String puntuacion="";
        for (Map.Entry<equipo, Integer> equipo : puntuaciones.entrySet()) {
            puntuacion+="Equipo: "+equipo.getKey().getCodigoEquipo()+" Puntuacion: "+equipo.getValue()+"\n";
        }
        return "torneo [codigoTorneo=" + codigoTorneo + ", nombreTorneo=" + nombreTorneo + ", ListEquipos="
                + ListEquipos + ", puntuaciones=" + puntuacion + "]";
    }
    public Map<equipo, Integer> getPuntuaciones() {
        List<Map.Entry<equipo, Integer>> listaEntradas = new ArrayList<>(puntuaciones.entrySet());
        listaEntradas.sort((entrada1, entrada2) -> entrada2.getValue().compareTo(entrada1.getValue()));
        Map<equipo, Integer> puntuacionesOrdenadas = new LinkedHashMap<>();
        for (Map.Entry<equipo, Integer> entrada : listaEntradas) {
            puntuacionesOrdenadas.put(entrada.getKey(), entrada.getValue());
        }
        return puntuacionesOrdenadas;
    }
    public void setPuntuaciones(equipo equipo, int puntuacion) {
        puntuaciones.put(equipo, puntuacion);
    }
    public void aumentarPuntuacion(equipo equipo, int puntuacion) {
        if (puntuaciones.containsKey(equipo)) {
            puntuaciones.replace(equipo, puntuaciones.get(equipo)+puntuacion);
        }else{
        puntuaciones.put(equipo, puntuacion);
        }
    }
    public void borrarJugador(jugador jugador){
        for (equipo equipo : ListEquipos) {
            equipo.getListJugadores().remove(jugador);
        }
    }
    public void borrarEquipo(equipo equipo){
        this.ListEquipos.remove(equipo);
    }
}
