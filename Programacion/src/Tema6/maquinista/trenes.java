package Tema6.maquinista;

import java.util.ArrayList;
import java.util.Set;

class trenes {
    private static ArrayList<String> unico = new ArrayList<>();
    private Set<vagon> vagones;
    private String identificador;
    private locomotoras locomotora;
    private maquinista maquinista;
    trenes(String identificador, locomotoras locomotora, maquinista maquinista, Set<vagon> vagonListSuplementario) {
        setIdentificador(identificador);
        setLocomotora(locomotora);
        setMaquinista(maquinista);
        setVagones(vagonListSuplementario);
    }

    @Override
    public String toString() {
        return "tren "+identificador+"\n"+vagones+"\n\n"+locomotora+"\n"+maquinista ;
    }

    String getIdentificador() {
        return identificador;
    }

    void setIdentificador(String identificador) {
        boolean verificacion = true;
        for (String id : unico) {
            if (identificador.equalsIgnoreCase(id)) {
                verificacion = false;
            }
        }
        if (identificador.matches("^TR-\\d{4}$") && verificacion) {
            this.identificador = identificador;
            unico.add(identificador); 
        } else {
            throw new IllegalArgumentException("Introduce un identificador valido");
        }
    }

    locomotoras getLocomotora() {
        return locomotora;
    }

    void setLocomotora(locomotoras locomotora) {
        this.locomotora = locomotora;
    }

    maquinista getMaquinista() {
        return maquinista;
    }

    void setMaquinista(maquinista maquinista) {
        this.maquinista = maquinista;
    }

    public Set<vagon> getVagones() {
        return vagones;
    }

    public void setVagones(Set<vagon> vagones) {
        this.vagones = vagones;
    }
}
