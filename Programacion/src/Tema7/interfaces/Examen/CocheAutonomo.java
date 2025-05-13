package Tema7.interfaces.Examen;

public class CocheAutonomo extends VehiculoInteligente {
    int nivelAutonomia;

    public CocheAutonomo(String matricula, int nivelAutonomia) {
        super(matricula);
        setNivelAutonomia(nivelAutonomia);

    }

    public void setNivelAutonomia(int nivelAutonomia) {
        if (nivelAutonomia < 1 || nivelAutonomia > 5)
            throw new IllegalArgumentException("No se puede seleccionar un nivel inferior a 1 ni superior a 5");
        this.nivelAutonomia = nivelAutonomia;

    }

    @Override
    public void arrancar() {
        String estado = "Coche " + matricula + " arrancado con autonomia de nivel " + nivelAutonomia;
        System.out.println(estado);
        activo = true;
        historial.add(estado);
    }

    @Override
    public void detener() {
        String estado = "Coche " + matricula + " detenido";
        System.out.println(estado);
        activo = false;
        historial.add(estado);
    }

}
