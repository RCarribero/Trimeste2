package Tema7.interfaces.EjercicioRepaso;

public class Persona {
private String Nombre;
private String Puesto;
static final String[] ListaPuesto = {"Autobusero","Trenero","Tranvianero"};

boolean asignado=false;

public Persona(String nombre, String puesto) {
    setNombre(nombre);
    setPuesto(puesto);
}


public String getNombre() {
    return Nombre;
}


public void setNombre(String nombre) {
    if(nombre.matches("^[A-Za-z\\s]{3,50}")){
        Nombre = nombre;
    }else{
        throw new IllegalArgumentException("El nombre esta mal");
    }
    
}


public String getPuesto() {
    return Puesto;
}


public void setPuesto(String puesto) {
    boolean verificacion=false;

    for (String puestos : ListaPuesto) {
        if(puestos.equalsIgnoreCase(puesto)){
            Puesto = puesto;
            verificacion=true;
        }
    }
    if(!verificacion){
        throw new IllegalArgumentException("El puesto es incorrecto debe de ser: Autobusero Trenero Tranvianero");
    }
}


public static String[] getListapuesto() {
    return ListaPuesto;
}

public boolean isAsignado() {
    return asignado;
}


public void setAsignado(boolean asignado) {
    this.asignado = asignado;
}


@Override
public String toString() {
    return "Persona [Nombre=" + Nombre + ", Puesto=" + Puesto + ", asignado=" + asignado + "]";
}


}
