package Tema6.gestorContacto;

public class contactoFavorito extends contacto {
    private int prioridad;

    int getPrioridad() {
        return prioridad;
    }

    void setPrioridad(int prioridad) {
        if (prioridad<6&&prioridad>0) {
            this.prioridad = prioridad;
        }else{
            throw new IllegalArgumentException("No se puede");
        }
    }

    contactoFavorito(String nombre, String telefono, String email, int prioridad) {
        super(nombre, telefono, email);
        setPrioridad(prioridad);
    }

    @Override
    public String toString() {
        return "contactoFavorito [prioridad=" + prioridad + ", Nombre=" + getNombre() + ", Telefono="
                + getTelefono() + ", Email=" + getEmail() + "]";
    }


}
