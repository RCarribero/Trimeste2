package Tema7.gestionBibliotecla;

import java.util.HashSet;
import java.util.Set;

public class biblioteca {
    private Set <libro> catalogo= new HashSet<>();

    /**
     * @return the catalogo
     */
    public Set<libro> getCatalogo() {
        return catalogo;
    }

    /**
     * @param catalogo the catalogo to set
     */
    public void setCatalogo(libro catalogo) {
        this.catalogo.add(catalogo);
    }

    @Override
    public String toString() {
        return "biblioteca [catalogo=" + catalogo + "]";
    }
}
