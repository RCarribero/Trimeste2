package src.Tema6.maquinista;

public class maquinista {
    private static final String[] rangos={"ayudante","titular","supervisor"};
    private String nombre;
    private String dni;
    private double sueldo;
    private String rango;

    maquinista(String nombre, String dni, double sueldo, String rango) {
        setNombre(nombre);
        setDni(dni);
        setSueldo(sueldo);
        setRango(rango);
    }

    

    @Override
    public String toString() {
        return "maquinista \nnombre=" + nombre + ", dni=" + dni + ", sueldo=" + sueldo + ", rango=" + rango + "\n";
    }



    String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        if (nombre.matches("^[a-zA-Z]{3,50}$")){
                this.nombre = nombre;
        }else{
        throw new IllegalArgumentException("Introduce un formato de nombre valido");
        }
    }

    String getDni() {
        return dni;
    }

    void setDni(String dni) {
        if (dni.matches("^\\d{8}[a-zA-Z]$")){
            this.dni = dni;
    }else{
        throw new IllegalArgumentException("Introduce un formato de dni valido");
    }
    }

    double getSueldo() {
        return sueldo;
    }

    void setSueldo(double sueldo) {
        if (sueldo>1200&&sueldo<=5000) {
            this.sueldo = sueldo;
        }else{
            throw new IllegalArgumentException("El suelo tiene que ser mayor a 1200 y menor a 5000");
        }
    }

    String getRango() {
        return rango;
    }

    void setRango(String rango) {
        boolean comprobacion=true;
        for (String rol : rangos) {
            if (rango.equalsIgnoreCase(rol)) {
            this.rango = rango;
            comprobacion=false;
            }
        }
        if (comprobacion) {
            throw new IllegalArgumentException("El rango tiene que ser, ayudante, titular o supervisor");
        }
    }

}
