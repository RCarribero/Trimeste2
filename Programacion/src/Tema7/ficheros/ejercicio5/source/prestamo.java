package Tema7.ficheros.ejercicio5.source;

import java.time.LocalDate;

public class prestamo {
    private int IDUsuario;
    private String ISBN;
    private LocalDate FechaPrestamo;
    private LocalDate FechaDevolucion;
    /**
     * @param iDUsuario
     * @param iSBN
     * @param fechaPrestamo
     * @param fechaDevolucion
     */
    public prestamo(int iDUsuario, String iSBN, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        IDUsuario = iDUsuario;
        ISBN = iSBN;
        FechaPrestamo = fechaPrestamo;
        FechaDevolucion = fechaDevolucion;
    }
    /**
     * @return the iDUsuario
     */
    public int getIDUsuario() {
        return IDUsuario;
    }
    /**
     * @param iDUsuario the iDUsuario to set
     */
    public void setIDUsuario(int iDUsuario) {
        IDUsuario = iDUsuario;
    }
    /**
     * @return the iSBN
     */
    public String getISBN() {
        return ISBN;
    }
    /**
     * @param iSBN the iSBN to set
     */
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    /**
     * @return the fechaPrestamo
     */
    public LocalDate getFechaPrestamo() {
        return FechaPrestamo;
    }
    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        FechaPrestamo = fechaPrestamo;
    }
    /**
     * @return the fechaDevolucion
     */
    public LocalDate getFechaDevolucion() {
        return FechaDevolucion;
    }
    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        FechaDevolucion = fechaDevolucion;
    }
    @Override
    public String toString() {
        return "prestamo [IDUsuario=" + IDUsuario + ", ISBN=" + ISBN + ", FechaPrestamo=" + FechaPrestamo
                + ", FechaDevolucion=" + FechaDevolucion + "]";
    }

}
