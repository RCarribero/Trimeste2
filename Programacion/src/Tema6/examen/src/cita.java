import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class cita {
    private String id;
    private List<String> unicoId = new ArrayList<>();
    private paciente paciente;
    private medico medico;
    private LocalDateTime fechaHora;
    private String motivoConsulta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.matches("^CITA-\\d{5}$"))
            throw new IllegalArgumentException("Formato incorrecto");
        if (unicoId.contains(id))
            throw new IllegalArgumentException("dni ya en uso");
        unicoId.add(id);
        this.id = id;
    }

    public paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(paciente paciente) {
        this.paciente = paciente;
    }

    public medico getMedico() {
        return medico;
    }

    public void setMedico(medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        if (!fechaHora.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("La fecha tiene que ser posterior a la actual");
        this.fechaHora = fechaHora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        if (!motivoConsulta.matches("^[A-Za-z\s]{1,100}$"))
            throw new IllegalArgumentException("EL motivo tiene que tener entre 0 y 100 caracteres ");
        this.motivoConsulta = motivoConsulta;
    }

}
