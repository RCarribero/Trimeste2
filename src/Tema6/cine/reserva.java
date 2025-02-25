package src.Tema6.cine;

import java.time.LocalDateTime;

public class reserva {
    private cliente cliente;
    private String[] estados = { "Activa", "Cancelada" };
    private pelicula pelicula;
    private LocalDateTime fechaHora;
    private int nºEntradasReservadas;
    private String estadoReserva = "Activa";

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(pelicula pelicula, cliente cliente) {
        if (pelicula.getClasficacionPelicula() <= cliente.getEdadCliente()) {
            this.pelicula = pelicula;
        } else {
            throw new IllegalArgumentException("Usted no tiene edad para ver esta pelicula");
        }
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNºEntradasReservadas() {
        return nºEntradasReservadas;
    }

    public void setNºEntradasReservadas(int nºEntradasReservadas) {
        if (nºEntradasReservadas <= 5 && nºEntradasReservadas > 0) {
            this.nºEntradasReservadas = nºEntradasReservadas;
        } else {
            throw new IllegalArgumentException("No se pueden reservar mas de 5 entradas por cliente");
        }
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        boolean verificacion = true;
        for (String estado : estados) {
            if (estado.equalsIgnoreCase(estadoReserva)) {
                verificacion = false;
            }
        }
        if (!verificacion) {
            this.estadoReserva = estadoReserva;
        } else {
            throw new IllegalArgumentException("Estado de reserva inexistente");
        }
    }

    @Override
    public String toString() {
        return "reserva [pelicula=" + pelicula
                + ", fechaHora=" + fechaHora + ", nºEntradasReservadas=" + nºEntradasReservadas + ", estadoReserva="
                + estadoReserva + "]";
    }

}
