package Tema6.maquinista;

public class mecanicos  {
    private static final String[] rangos = { "frenos", "hidraulica", "electricidad", "motor" };
    private String nombre;
    private String telefono;
    private String especialidad;

    mecanicos(String nombre, String telefono, String especialidad) {
        setNombre(nombre);
        setEspecialidad(especialidad);
        setTelefono(telefono);
    }



    @Override
    public String toString() {
        return "mecanico nombre=" + nombre + ", telefono=" + telefono + ", especialidad=" + especialidad + "\n";
    }



    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        if (nombre.matches("^[a-zA-Z]{3,50}$")) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("Introduce un nombre entre 3-50 caracteres");
        }
    }

    String getTelefono() {
        return telefono;
    }

    void setTelefono(String telefono) {
        if (telefono.matches("^\\d{9}$")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Telefono incorrecto");
        }
    }

    String getEspecialidad() {
        return especialidad;
    }

    void setEspecialidad(String especialidad) {
        boolean comprobacion = true;
        for (String rango : rangos) {
            if (rango.equalsIgnoreCase(especialidad)) {
                this.especialidad = especialidad;
                comprobacion = false;
            }
        }
        if (comprobacion) {
            throw new IllegalArgumentException("Especialidad incorrecta frenos, hidraulica, electricidad, motor");
        }
    }
}
