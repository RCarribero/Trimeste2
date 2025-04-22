import java.util.ArrayList;
import java.util.List;

public class personalSanitario extends persona {
    private String numeroColegiado;
    private List<String> unicoNumeroColegiado = new ArrayList<>();
    private int añosExperiencia;
    private departementoMedico departamento;

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        if (!numeroColegiado.matches("^COL-\\d{5}$"))
            throw new IllegalArgumentException("Formato de numero incorrecto");
        if (unicoNumeroColegiado.contains(numeroColegiado))
            throw new IllegalArgumentException("Numero ya en uso");
        this.numeroColegiado = numeroColegiado;
        unicoNumeroColegiado.add(numeroColegiado);
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia < 0)
            throw new IllegalArgumentException("Tiene que tener 0 años de experiencia como minimo");
        this.añosExperiencia = añosExperiencia;
    }

    public departementoMedico getDepartamento() {
        return departamento;
    }

    public void setDepartamento(departementoMedico departamento) {
        this.departamento = departamento;
    }

}
