package Tema6.src.Ejercicio2;

public class Producto {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if (precio<=0) {
            System.out.println("Indica un precio razonable");
        }else{
        this.precio = precio;
        }
    }
    public void mostrarInfo(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
    }
}
