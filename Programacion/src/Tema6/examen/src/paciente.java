import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class paciente extends persona {
    private static final String[] listGrupoSanguineo = { "A+", "A-", "B+", "B-", "AB+", "AB-", "0+", "0-" };
    private String numeroHistoriaClinica;
    private List<String> unicoNumeroHistoriaClinica = new ArrayList<>();
    private String grupoSanguineo;
    private List<String> alergias = new ArrayList<>();
    private medico medico;

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        if (!numeroHistoriaClinica.matches("^HC-\\d{5}$"))
            throw new IllegalArgumentException("Formato de nuemero de historial incorrecto");
        if (unicoNumeroHistoriaClinica.contains(numeroHistoriaClinica))
            throw new IllegalArgumentException("El numero ya esta en uso ");
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        unicoNumeroHistoriaClinica.add(numeroHistoriaClinica);
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        if (!Arrays.asList(listGrupoSanguineo).contains(grupoSanguineo))
            throw new IllegalArgumentException("Grupo sanguineo no disponible");
        this.grupoSanguineo = grupoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias.add(alergias);
    }

    public medico getMedico() {
        return medico;
    }

    public void setMedico(medico medico) {
        this.medico = medico;
    }

}
