package Tema6.gestorContacto;

import java.util.ArrayList;
import java.util.List;

public class contacto {
    private String nombre;
    private static List<String> nombreUnico=new ArrayList<>();
    private String telefono;
    private String email;
    String getNombre() {
        return nombre;
    }
    public static List<String> getNombreUnico() {
        return nombreUnico;
    }
    public static void setNombreUnico(List<String> nombreUnico) {
        contacto.nombreUnico = nombreUnico;
    }
    void setNombre(String nombre) {
        boolean verificacion=true;
        if (!nombreUnico.isEmpty()) {
            for (String string : nombreUnico) {
                if (nombre.equals(string)) {
                    verificacion=false;
                }
            }
        }
        if (verificacion) {
            nombreUnico.add(nombre);
            this.nombre = nombre;
        }else{
            throw new IllegalArgumentException("Este contacto ya existe");
        }
    }
    String getTelefono() {
        return telefono;
    }
    void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    String getEmail() {
        return email;
    }
    void setEmail(String email) {
        this.email = email;
    }
    contacto(String nombre, String telefono, String email) {
        setNombre(nombre);
        this.telefono = telefono;
        this.email = email;
    }
    @Override
    public String toString() {
        return "contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
    }
}
