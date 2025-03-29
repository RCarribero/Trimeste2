package src.Tema6.maquinista;

import java.time.LocalDate;

public class jefeEstacion {
    private String nombre;

    private String dni;
    private LocalDate fechaNombramiento;
    jefeEstacion(String nombre, String dni, LocalDate fechaNombramiento) {
        setDni(dni);
        setFechaNacimiento(fechaNombramiento);
        setNombre(nombre);
    }
    
    

    @Override
    public String toString() {
        return "jefeEstacion [nombre=" + nombre + ", dni=" + dni + ", fechaNombramiento=" + fechaNombramiento + "]\n";
    }



    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        if (nombre.matches("^[a-zA-Z]{3,50}$")){
                this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Introduce un nombre entre 3-50 caracteres");
        }
    }

    String getDni() {
        return dni;
    }

    void setDni(String dni) {
        if (dni.matches("^\\d{8}[a-z,A-Z]$")){
            this.dni = dni;
    }else{
        throw new IllegalArgumentException("Formato de dni invalido");
    }
    }

    LocalDate getFechaNacimiento() {
        return fechaNombramiento;
    }

    void setFechaNacimiento(LocalDate fechaNombramiento) {
        if (fechaNombramiento.isBefore(LocalDate.now())) {
            this.fechaNombramiento = fechaNombramiento;
        }else{
            throw new IllegalArgumentException("Fecha introducida incorrecta");
        }
    }

}
