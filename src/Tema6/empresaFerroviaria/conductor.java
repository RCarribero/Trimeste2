package src.Tema6.empresaFerroviaria;

import java.util.List;
import java.util.ArrayList;

public class conductor {
    private static List<String> dniUnico = new ArrayList<>();
    private String nombre;
    private String dni;
    private int añoExperiencia;
    private String telefono;
    private boolean asignado = false;

    conductor() {
    }

    conductor(String nombre, String dni, int añoExperiencia, String telefono,boolean asignado) {
        this.nombre = nombre;
        this.dni = dni;
        this.añoExperiencia = añoExperiencia;
        this.telefono = telefono;
        this.asignado = asignado;
    }

    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        if (nombre.matches("^[a-zA-Z]{3,50}$")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Nombre incorrecto");
        }
    }

    String getDni() {
        return dni;
    }

    void setDni(String dni) {
        boolean verificacion = true;
        for (String id : dniUnico) {
            if (id.equals(dni)) {
                verificacion = false;
            }
        }
        if (verificacion && dni.matches("^\\d{8}[a-zA-Z]$")) {
            dniUnico.add(dni);
            this.dni = dni;
        } else {
            throw new IllegalArgumentException("DNI incorrecto");
        }
    }

    int getAñoExperiencia() {
        return añoExperiencia;
    }

    void setAñoExperiencia(int añoExperiencia) {
        if (añoExperiencia >= 1) {
            this.añoExperiencia = añoExperiencia;
        } else {
            throw new IllegalArgumentException("El año tiene que ser mayor que 1");
        }
    }

    String getTelefono() {
        return telefono;
    }

    void setTelefono(String telefono) {
        if (telefono.matches("^\\d{9}$")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Formato de telefono incorrecto");
        }
    }

    boolean isAsignado() {
        return asignado;
    }

    void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    @Override
    public String toString() {
        return "conductor [nombre=" + nombre + ", dni=" + dni + ", añoExperiencia=" + añoExperiencia + ", telefono="
                + telefono + "]";
    }
}
