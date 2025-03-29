package src.Tema6.cine;

import java.util.ArrayList;
import java.util.List;

public class cliente {
    private static List<String> dniClienteUnico = new ArrayList<>();
    private String dniCliente;
    private String nombreApellidoCliente;
    private int edadCliente;
    private List<reserva> historialReservaCliente = new ArrayList<>();

    public List<reserva> getHistorialReservaCliente() {
        return historialReservaCliente;
    }

    public void setHistorialReservaCliente(reserva historialReservaCliente) {
        this.historialReservaCliente.add(historialReservaCliente);
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        if (dniCliente.matches("^\\d{8}[a-zA-Z]$") && !dniClienteUnico.contains(dniCliente)) {
            this.dniCliente = dniCliente;
            dniClienteUnico.add(dniCliente);
        } else {
            throw new IllegalArgumentException("Error en dni");
        }
    }

    public String getNombreApellidoCliente() {
        return nombreApellidoCliente;
    }

    public void setNombreApellidoCliente(String nombreApellidoCliente) {
        if (nombreApellidoCliente.matches("^[a-zA-Z\\s]{3,50}$")) {
            this.nombreApellidoCliente = nombreApellidoCliente;
        } else {
            throw new IllegalArgumentException("Formato de nombre incorrecto debe tener entre 3 y 50 caracteres");
        }
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        if (edadCliente >= 3) {
            this.edadCliente = edadCliente;
        }
    }

    @Override
    public String toString() {
        return "cliente [dniCliente=" + dniCliente + ", nombreApellidoCliente=" + nombreApellidoCliente
                + ", edadCliente=" + edadCliente + ", historialReservaCliente=" + historialReservaCliente + "]";
    }
}
