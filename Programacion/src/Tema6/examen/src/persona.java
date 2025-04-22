import java.util.ArrayList;
import java.util.List;

public class persona {
    private String dni;
    private List<String> unicoDni = new ArrayList<>();
    private String nombreApellido;
    private int edad;
    private String telefono;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!dni.matches("^\\d{8}[a-zA-Z]$"))
            throw new IllegalArgumentException("Formato de dni invalido");
        if (unicoDni.contains(dni))
            throw new IllegalArgumentException("El dni ya esta en uso");
        this.dni = dni;
        unicoDni.add(dni);
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        if (!nombreApellido.matches("^[a-zA-Z\\s]{3,50}$"))
            throw new IllegalArgumentException("Nombre incorrecto");
        this.nombreApellido = nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 0)
            throw new IllegalArgumentException("Edad minima 1 año");
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches("^\\d{9}$"))
            throw new IllegalArgumentException("El formato de telefono es incorrecto");
        this.telefono = telefono;
    }

}
