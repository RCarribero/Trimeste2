package Tema6.maquinista;

import java.time.LocalDate;

class locomotoras {
    private String matricula;
    private double potenciaMotor;
    private int añoFabricacion;
    private mecanicos mecanico;

    locomotoras(String matricula, double potenciaMotor, int añoFabricacion, mecanicos mecanico) {
        setAñoFabricacion(añoFabricacion);
        setMatricula(matricula);
        setMecanico(mecanico);
        setPotenciaMotor(potenciaMotor);
    }


    @Override
    public String toString() {
        return "locomotora\nmatricula=" + matricula + ", potenciaMotor=" + potenciaMotor + ", añoFabricacion="
                + añoFabricacion + mecanico ;
    }


    String getMatricula() {
        return matricula;
    }

    void setMatricula(String matricula) {
        if (matricula.matches("^[a-zA-Z]{2}\\d{4}$")) {
            this.matricula = matricula;
        } else {
            throw new IllegalArgumentException("Matricula no valida");
        }
    }

    double getPotenciaMotor() {
        return potenciaMotor;
    }

    void setPotenciaMotor(double potenciaMotor) {
        if (potenciaMotor > 500 && potenciaMotor < 5000) {
            this.potenciaMotor = potenciaMotor;
        } else {
            throw new IllegalArgumentException("Potencia de motor debe ser entre 500 y 5000");
        }
    }

    int getAñoFabricacion() {
        return añoFabricacion;
    }

    void setAñoFabricacion(int añoFabricacion) {
        if (añoFabricacion > 1950 && añoFabricacion < LocalDate.now().getYear()) {
            this.añoFabricacion = añoFabricacion;
        } else {
            throw new IllegalArgumentException("Año de fabricación debe ser entre 1950 y el año actual");
        }
    }

    mecanicos getMecanico() {
        return mecanico;
    }

    void setMecanico(mecanicos mecanico) {
        this.mecanico = mecanico;
    }
}
