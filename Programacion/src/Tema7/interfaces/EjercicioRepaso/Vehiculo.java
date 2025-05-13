package Tema7.interfaces.EjercicioRepaso;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Vehiculo {
protected String tipo;
protected final static String[] TipoVehiculo = {"Autobus", "Tranvia", "Tren"};
protected Persona conductor;
protected String matricula;
protected int capacidadMAX;
protected Double distancia;


public Vehiculo(){

}


public Vehiculo(String tipo, Persona conductor, String matricula, int capacidadMAX) {
    setTipo(tipo);
    this.conductor = conductor;
    this.capacidadMAX = capacidadMAX;
    setMatricula(matricula);
}

public abstract void arrancar();
public abstract void detener();

public void MostrarInformacion(){
    System.out.println(matricula + " " + capacidadMAX);
}


public String getMatricula() {
    return matricula;
}


public String getTipo() {
    return tipo;
}

public void setTipo(String tipo) {
    boolean verificacion=false;

    for (String string : TipoVehiculo) {
        if(string.equalsIgnoreCase(tipo)){
            verificacion=true;
            this.tipo = tipo;
        }
    }
    if(!verificacion){
        throw new IllegalArgumentException("El tipo no es el correcto");
    }
}

public static String[] getTipovehiculo() {
    return TipoVehiculo;
}

public void setMatricula(String matricula) {
    if(matricula.matches("\\d{2}[A-Za-z]{1}$")){
        this.matricula = matricula;
    }else{
        throw new IllegalArgumentException("La matricula esta mal tiene que ser 12A por ejemplo");
    }
    
}


public int getCapacidadMAX() {
    return capacidadMAX;
}


public void setCapacidadMAX(int capacidadMAX) {
    this.capacidadMAX = capacidadMAX;
}


public Double getDistancia() {
    return distancia;
}


public void setDistancia(Double distancia) {
    this.distancia = distancia;
}




@Override
public int hashCode() {
    return Objects.hash(this.matricula);
}

@Override
public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    Vehiculo vehi= (Vehiculo) obj;

    return Objects.equals(this.matricula,vehi.matricula);
}
@Override
public String toString() {
    return "Vehiculo [tipo=" + tipo + ", conductor=" + conductor + ", matricula=" + matricula + ", capacidadMAX="
            + capacidadMAX + ", distancia=" + distancia + "]";
}


public void setListaVehiculo(Set<Vehiculo> ListaVehiculo) {
    ListaVehiculo = ListaVehiculo;
}


public Persona getConductor() {
    return conductor;
}


public void setConductor(Persona conductor) {
    this.conductor = conductor;
}


}
