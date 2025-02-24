package src.Tema6.empresaFerroviaria;

import java.util.ArrayList;
import java.util.List;

public class autobus {
    private static List<String> matriculaUnica = new ArrayList<>();
    private String matricula;
    private int capacidadMaxima;
    private conductor conductor;
    private ruta ruta;
    private boolean autobusAsignado = false;

    autobus() {
    }

    autobus(String matricula, int capacidadMaxima, conductor conductor, ruta ruta, boolean autobusAsignado) {
        this.matricula = matricula;
        this.capacidadMaxima = capacidadMaxima;
        this.conductor = conductor;
        this.ruta = ruta;
        this.autobusAsignado = autobusAsignado;
    }

    boolean isAutobusAsignado() {
        return autobusAsignado;
    }

    void setAutobusAsignado(boolean autobusAsignado) {
        this.autobusAsignado = autobusAsignado;
    }

    String getMatricula() {
        return matricula;
    }

    void setMatricula(String matricula) {
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

    int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima > 20 && capacidadMaxima < 80) {
            this.capacidadMaxima = capacidadMaxima;
        } else {
            throw new IllegalArgumentException("La capacidad maxima esta entre 20 y 80");
        }
    }

    conductor getConductor() {
        return conductor;
    }

    void setConductor(conductor conductor) {
        if (!conductor.isAsignado()) {
            this.conductor = conductor;
            this.conductor.setAsignado(true);
        } else {
            throw new IllegalArgumentException("Este conductor ya esta ocupado");
        }
    }

    ruta getRuta() {
        return ruta;
    }

    void setRuta(ruta ruta) {
        if (!ruta.isRutaAsignada()) {
            this.ruta = ruta;
            this.ruta.setRutaAsignada(true);
        } else {
            throw new IllegalArgumentException("Codigo de ruta invalido");
        }
    }

    @Override
    public String toString() {
        return "autobus [matricula=" + matricula + ", capacidadMaxima=" + capacidadMaxima + ", conductor=" + conductor
                + ", ruta=" + ruta + "]";
    }

    void modificarRuta(ruta ruta) {
        if (!ruta.isRutaAsignada()||ruta.isRutaAsignada()) {
            this.ruta.setRutaAsignada(false);
            this.ruta = ruta;
            this.ruta.setRutaAsignada(true);
        } else {
            throw new IllegalArgumentException("Esta ruta ya esta asignada");
        }
    }

    void modificarConductor(conductor conductor) {
        if (!conductor.isAsignado()) {
            this.conductor.setAsignado(false);
            this.conductor = conductor;
            this.conductor.setAsignado(true);
        } else {
            throw new IllegalArgumentException("Este conductoe ya esta asignado");
        }
    }
}
