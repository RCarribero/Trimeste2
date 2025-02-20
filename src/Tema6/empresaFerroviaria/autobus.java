package src.Tema6.empresaFerroviaria;

import java.util.ArrayList;
import java.util.List;

public class autobus {
    static List<String> matriculaUnica = new ArrayList<>();
    String matricula;
    int capacidadMaxima;
    conductor conductor;
    ruta ruta;
    boolean autobusAsignado = false;

    public autobus() {
    }

    public boolean isAutobusAsignado() {
        return autobusAsignado;
    }

    public void setAutobusAsignado(boolean autobusAsignado) {
        this.autobusAsignado = autobusAsignado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        boolean verificacion = true;
        for (String id : matriculaUnica) {
            if (id.equals(matricula)) {
                verificacion = false;
            }
        }
        if (verificacion && matricula.matches("^[A-Z]{3}-\\d{4}$")) {
            matriculaUnica.add(matricula);
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("Matricula incorrecta, el formato debe ser ABC-1234");
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima > 20 && capacidadMaxima < 80) {
            this.capacidadMaxima = capacidadMaxima;
        } else {
            throw new IllegalArgumentException("La capacidad maxima esta entre 20 y 80");
        }
    }

    public conductor getConductor() {
        return conductor;
    }

    public void setConductor(conductor conductor) {
        if (!conductor.isAsignado()) {
            this.conductor = conductor;
            this.conductor.asignado = true;
        } else {
            throw new IllegalArgumentException("Este conductor ya esta ocupado");
        }
    }

    public ruta getRuta() {
        return ruta;
    }

    public void setRuta(ruta ruta) {
        if (!ruta.isRutaAsignada()) {
            this.ruta = ruta;
            this.ruta.rutaAsignada = true;
        }else{
            throw new IllegalArgumentException("Codigo de ruta invalido");
        }
    }

    @Override
    public String toString() {
        return "autobus [matricula=" + matricula + ", capacidadMaxima=" + capacidadMaxima + ", conductor=" + conductor
                + ", ruta=" + ruta + "]";
    }
    void modificarRuta(ruta ruta){
        if (!ruta.isRutaAsignada()) {
            this.ruta.rutaAsignada=false;
            this.ruta=ruta;
            this.ruta.rutaAsignada=true;
        }else{
            throw new IllegalArgumentException("Esta ruta ya esta asignada");
        }
    }
    void modificarConductor(conductor conductor){
        if (!conductor.asignado) {
            this.conductor.asignado=false;
            this.conductor=conductor;
            this.conductor.asignado=true;
        }else{
            throw new IllegalArgumentException("Este conductoe ya esta asignado");
        }
    }
}
