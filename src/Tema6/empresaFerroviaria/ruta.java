package src.Tema6.empresaFerroviaria;

import java.util.ArrayList;
import java.util.List;

public class ruta {
    private static List<String> codigoRutaUnico = new ArrayList<>();
    private String codigoRuta;
    private int paradas;
    private double kilometros;
    private boolean rutaAsignada = false;

    ruta(String codigoRuta, int paradas, double kilometros, boolean rutaAsignada) {
        this.codigoRuta = codigoRuta;
        this.paradas = paradas;
        this.kilometros = kilometros;
        this.rutaAsignada = rutaAsignada;
    }

    ruta() {
    }

    @Override
    public String toString() {
        return "ruta [codigoRuta=" + codigoRuta + ", paradas=" + paradas + ", kilometros=" + kilometros + "]";
    }

    void setCodigoRuta(String codigoRuta) {
        boolean verificacion = true;
        for (String id : codigoRutaUnico) {
            if (codigoRuta.equals(id)) {
                verificacion = false;
            }
        }
        if (verificacion && codigoRuta.matches("^R-\\d{3}$")) {
            codigoRutaUnico.add(codigoRuta);
            this.codigoRuta = codigoRuta;
        } else {
            throw new IllegalArgumentException("Ingresa un codigo de ruta valido");
        }
    }

    void setRutaAsignada(boolean rutaAsignada) {
        this.rutaAsignada = rutaAsignada;
    }

    String getCodigoRuta() {
        return codigoRuta;
    }

    int getParadas() {
        return paradas;
    }

    double getKilometros() {
        return kilometros;
    }

    boolean isRutaAsignada() {
        return rutaAsignada;
    }

    void setParadas(int paradas) {
        if (paradas > 1) {
            this.paradas = paradas;
        } else {
            throw new IllegalArgumentException("El numero de paradas tiene que se 2 como minimo");
        }
    }

    void setKilometros(double kilometros) {
        if (kilometros > 0) {
            this.kilometros = kilometros;
        } else {
            throw new IllegalArgumentException("El kilometraje tine que ser superior a 0");
        }
    }

}
