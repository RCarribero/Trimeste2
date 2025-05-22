package Tema7.ficheros.ejercicio5.source;

public class libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    /**
     * @param isbn
     * @param titulo
     * @param autor
     * @param ejemplaresTotales
     * @param ejemplaresDisponibles
     */
    public libro(String isbn, String titulo, String autor, int ejemplaresTotales, int ejemplaresDisponibles) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", ejemplaresTotales="
                + ejemplaresTotales + ", ejemplaresDisponibles=" + ejemplaresDisponibles + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        libro other = (libro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the ejemplaresTotales
     */
    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    /**
     * @param ejemplaresTotales the ejemplaresTotales to set
     */
    public void setEjemplaresTotales(int ejemplaresTotales) {
        this.ejemplaresTotales = ejemplaresTotales;
    }

    /**
     * @return the ejemplaresDisponibles
     */
    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    /**
     * @param ejemplaresDisponibles the ejemplaresDisponibles to set
     */
    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }
}
