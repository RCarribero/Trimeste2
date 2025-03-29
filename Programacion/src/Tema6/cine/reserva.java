package src.Tema6.cine;

import java.time.LocalDateTime;

public class reserva {
    private cliente cliente;
    private String[] estados = { "Activa", "Cancelada" };
    private pelicula pelicula;
    private LocalDateTime fechaHora;
    private int nºEntradasReservadas;
    private String estadoReserva = "Activa";

    cliente getCliente() {
        return cliente;
    }

    void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    pelicula getPelicula() {
        return pelicula;
    }

    void setPelicula(pelicula pelicula, cliente cliente) {
        if (pelicula.getClasficacionPelicula() <= cliente.getEdadCliente()) {
            this.pelicula = pelicula;
        } else {
            throw new IllegalArgumentException("Usted no tiene edad para ver esta pelicula");
        }
    }

    LocalDateTime getFechaHora() {
        return fechaHora;
    }

    void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    int getNºEntradasReservadas() {
        return nºEntradasReservadas;
    }

    void setNºEntradasReservadas(int nºEntradasReservadas) {
        if (nºEntradasReservadas <= 5 && nºEntradasReservadas > 0) {
            this.nºEntradasReservadas = nºEntradasReservadas;
        } else {
            throw new IllegalArgumentException("No se pueden reservar mas de 5 entradas por cliente");
        }
    }

    String getEstadoReserva() {
        return estadoReserva;
    }

    void setEstadoReserva(String estadoReserva) {
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
    String mostrarReserva(){
        return "reserva [Cliente="+cliente+ "pelicula=" + pelicula
                + ", fechaHora=" + fechaHora + ", nºEntradasReservadas=" + nºEntradasReservadas + ", estadoReserva="
                + estadoReserva + "]";
    }
}
