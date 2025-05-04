package Tema7.interfazVehiculos;

public class coche implements terrestre{
private String marca;
private String modelo;
private int km;
private boolean marcha;
public coche(String string, String string2) {
    //TODO Auto-generated constructor stub
}
@Override
public void conducir(int distancia) {
    if (marcha)
    System.out.println(km+=distancia);
}
@Override
public boolean estaEnMarcha() {
    if (marcha)
    return true;    
    return false;
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
public String getMarca() {
    return marca;
}
public void setMarca(String marca) {
    this.marca = marca;
}
public String getModelo() {
    return modelo;
}
public void setModelo(String modelo) {
    this.modelo = modelo;
}

}
