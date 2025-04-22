import java.util.ArrayList;
import java.util.List;

public class departementoMedico {
    private String codigoDepartamento;
    private List<String> uniocCodigoDepartamento = new ArrayList<>();
    private String nombreDepartamento;
    private List<personalSanitario> listPersonal = new ArrayList<>();
    private int planta;

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        if (!codigoDepartamento.matches("^DEP-[A-Z]{3}$"))
            throw new IllegalArgumentException("Formato incorrecto");
        if (uniocCodigoDepartamento.contains(codigoDepartamento))
            throw new IllegalArgumentException("El codigo ya existe");
        this.codigoDepartamento = codigoDepartamento;
        uniocCodigoDepartamento.add(codigoDepartamento);
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        if (!nombreDepartamento.matches("^[a-zA-Z\s]{3,50}$"))
            throw new IllegalArgumentException("Formato incorrecto");
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<personalSanitario> getListPersonal() {
        return listPersonal;
    }

    public void setListPersonal(personalSanitario Personal) {
        if (listPersonal.contains(Personal)) {
            throw new IllegalArgumentException("Ya esta añadido ese personal");
        }else{
            this.listPersonal.add(Personal);
        }
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        if (planta < 0)
            throw new IllegalArgumentException("la planta tiene que ser positiva");
        this.planta = planta;
    }

}
