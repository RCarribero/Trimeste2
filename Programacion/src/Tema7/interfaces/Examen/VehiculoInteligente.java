package Tema7.interfaces.Examen;

import java.util.ArrayList;
import java.util.List;

public abstract class VehiculoInteligente {
    protected String matricula;
    protected boolean activo = false;
    protected List<String> historial = new ArrayList<>();

    public VehiculoInteligente(String matricula) {
        setMatricula(matricula);
    }

    public void setMatricula(String matricula) {
        if (!matricula.matches("^[A-Z]{4}-\\d{3}$"))
            throw new IllegalArgumentException("Formato de matricula invalido");
        this.matricula = matricula;
    }

    public abstract void arrancar();

    public abstract void detener();

    public void mostrarEstado() {
        System.out.print("Matricula: " + matricula + " estado: " + activo);
        if (!historial.isEmpty()) {
            System.out.println(" ultima accion: " + historial.getLast());
        }
    };

    public void mostrarHistorial() {
        for (String string : historial) {
            System.out.println(string);
        }
    };

    public String getMatricula() {
        return matricula;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<String> getHistorial() {
        return historial;
    }

    public void setHistorial(List<String> historial) {
        this.historial = historial;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        VehiculoInteligente other = (VehiculoInteligente) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}
