package ProyectoProgramacion;

public class Barco { //Clase abstracta Barco
    private int tamano;
    private String nombre;

    String getNombre() {
        return nombre;
    }
    
    void setNombre(String nombre) {
        this.nombre = nombre;
    }
    int getTamano() { //Devolver el tamaño del barco
        return tamano;
    }
    void setTamano(int tamano) { //Cambiar el tamaño del barco
        this.tamano=tamano;
    }
    void decrementarTamaño(){
        tamano--;
    }

}
