package Tema7.interfaces.Examen;

public class BicicletaCompartida extends VehiculoInteligente {
    String estacionActual;

    public BicicletaCompartida(String matricula, String estacionActual) {
        super(matricula);
        setEstacionActual(estacionActual);
    }

    public void setEstacionActual(String estacionActual) {
        this.estacionActual = estacionActual;
    }

    @Override
    public void arrancar() {
        String estado = "bicicleta " + matricula + " retirada de la estacion " + estacionActual;
        System.out.println(estado);
        activo = true;
        historial.add(estado);
    }

    @Override
    public void detener() {
        String estado = "bicicleta " + matricula + " estacionada en la estacion " + estacionActual;
        System.out.println(estado);
        activo = false;
        historial.add(estado);
    }
}
