package Tema7.interfaces.Examen;

public class AutobusElectrico extends VehiculoInteligente implements Programable {
    int capacidad;

    public AutobusElectrico(String matricula, int capacidad) {
        super(matricula);
        setCapacidad(capacidad);
    }

    @Override
    public void arrancar() {
        String estado = "autobus " + matricula + " arrancado con la capacidad " + capacidad;
        System.out.println(estado);
        activo = true;
        historial.add(estado);
    }

    @Override
    public void detener() {
        String estado = "Autobus " + matricula + " detenido";
        System.out.println(estado);
        activo = false;
        historial.add(estado);
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public void programarInicio(String hora) {
        String estado = "autobus " + matricula + " tiene programado el inicio a las " + hora;
        System.out.println(estado);
        historial.add(estado);
    }

    @Override
    public void programarParada(String hora) {
        String estado = "Autobus " + matricula + " tiene programada la parada a las " + hora;
        System.out.println(estado);
        historial.add(estado);
    }

}
