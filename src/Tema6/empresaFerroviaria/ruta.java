package src.Tema6.empresaFerroviaria;

import java.util.ArrayList;
import java.util.List;

public class ruta {
    static List<String> codigoRutaUnico = new ArrayList<>();
    String codigoRuta;
    int paradas;
    double kilometros;
    boolean rutaAsignada = false;

    @Override
    public String toString() {
        return "ruta [codigoRuta=" + codigoRuta + ", paradas=" + paradas + ", kilometros=" + kilometros + "]";
    }

    public void setCodigoRuta(String codigoRuta) {
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

    public void setRutaAsignada(boolean rutaAsignada) {
        this.rutaAsignada = rutaAsignada;
    }

    public String getCodigoRuta() {
        return codigoRuta;
    }

    public int getParadas() {
        return paradas;
    }

    public double getKilometros() {
        return kilometros;
    }

    public boolean isRutaAsignada() {
        return rutaAsignada;
    }

    public void setParadas(int paradas) {
        if (paradas > 1) {
            this.paradas = paradas;
        } else {
            throw new IllegalArgumentException("El numero de paradas tiene que se 2 como minimo");
        }
    }

    public void setKilometros(double kilometros) {
        if (kilometros > 0) {
            this.kilometros = kilometros;
        } else {
            throw new IllegalArgumentException("El kilometraje tine que ser superior a 0");
        }
    }

}
