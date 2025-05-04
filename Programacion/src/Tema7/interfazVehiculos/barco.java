package Tema7.interfazVehiculos;

public class barco implements acuatico {
    private String nombre;
    private String tipo;
    private int km;
    private boolean marcha;
    public barco(String string, String string2) {
        //TODO Auto-generated constructor stub
    }
    @Override
public void navegar(int distancia) {
    if (marcha)
    System.out.println(km+=distancia);
}
@Override
public boolean estaEnMarcha() {
    if (marcha)
    return true;    
    return false;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
@Override
public void arrancar() {
    if (estaEnMarcha()){
        System.out.println("Ya esta arrancado");
    }else
    marcha=true;
}
@Override
public void detener() {
    if (!estaEnMarcha()){
        System.out.println("No esta arrancado");
    }
    marcha=false;
}
}
