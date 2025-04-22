import java.util.ArrayList;
import java.util.List;

public class medico extends personalSanitario {
    private String especialidad;
    private List<paciente> pacientesAsignados = new ArrayList<>();

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    public void setPacientesAsignados(paciente paciente) {
        if (pacientesAsignados.contains(paciente))
            throw new IllegalArgumentException("El paciente ya esta en la lista");
        this.pacientesAsignados.add(paciente);
    }

}
