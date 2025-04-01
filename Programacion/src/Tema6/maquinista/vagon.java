package Tema6.maquinista;

import java.util.ArrayList;

class vagon {
    private static final String[] tiposMercancia = { "Pasajeros", "Granos", "Liquidos", "Materiales pesados" };
    private static ArrayList<Integer> unico = new ArrayList<>();
    private int numeroIdentificacion;
    private double cargaMaxima;
    private double cargaActual;

    private String tipoMercancia;
    vagon(int numeroIdentificacion, double cargaMaxima, double cargaActual, String tipoMercancia) {
        setNumeroIdentificacion(numeroIdentificacion);
        setCargaMaxima(cargaMaxima);
        setCargaActual(cargaActual);
        setTipoMercancia(tipoMercancia);
    }                                               

    

    @Override
    public String toString() {
        return "vagon " + numeroIdentificacion + ", cargaMaxima=" + cargaMaxima + ", cargaActual="
                + cargaActual + ", tipoMercancia=" + tipoMercancia + "\n";
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    void setNumeroIdentificacion(int numeroIdentificacion) {
        boolean verificacion=true;
        if (!unico.isEmpty()) {
            for (int id : unico) {
            if (numeroIdentificacion==id) {
                verificacion=false;
            }
        }
        }
        
        if (verificacion&&numeroIdentificacion>0) {
            unico.add(numeroIdentificacion);
            this.numeroIdentificacion = numeroIdentificacion;
        }else{
            throw new IllegalArgumentException("Introduce un identificador valido");
        }
    }

    double getCargaMaxima() {
        return cargaMaxima;
    }

    void setCargaMaxima(double cargaMaxima) {
        if (cargaMaxima > 5000 && cargaMaxima < 50000) {
            this.cargaMaxima = cargaMaxima;
        } else {
            throw new IllegalArgumentException("La carga tiene que estar entre 5000 y 50000");
        }
    }

    double getCargaActual() {
        return cargaActual;
    }

    void setCargaActual(double cargaActual) {
        if (cargaActual < this.cargaMaxima) {
            this.cargaActual = cargaActual;
        } else {
            throw new IllegalArgumentException("La carga no puede superar el maximo");
        }
    }

    String getTipoMercancia() {
        return tipoMercancia;
    }

    void setTipoMercancia(String tipoMercancia) {
        boolean verificacion = true;
        for (String tipo : tiposMercancia) {
            if (tipoMercancia.equalsIgnoreCase(tipo)) {
                this.tipoMercancia = tipoMercancia;
                verificacion = false;
            }
        }
        if (verificacion) {
            throw new IllegalArgumentException("Tipo de mercancia inexistente");
        }
    }
}
