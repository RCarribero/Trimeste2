package modelio;
public class Main {
    public static void main(String[] args) {
        // Crear organizador
        Organizador pepe = new Organizador("Pepe Eventos");

        // Crear eventos
        Concierto concierto = new Concierto("Rock Fest", "10/06/2025", "Los Caños");
        Teatro teatro = new Teatro("Hamlet", "15/06/2025", "Juana Pérez");

        pepe.agregarEvento(concierto);
        pepe.agregarEvento(teatro);

        // Crear asistentes
        Asistente ruben = new Asistente("Rubén");
        Asistente maria = new Asistente("María");

        // Crear entradas (relación ternaria)
        Entrada e1 = new Entrada(ruben, concierto, pepe, "25.00");
        Entrada e2 = new Entrada(maria, teatro, pepe, "30.00");

        // Mostrar info
        concierto.mostrarInfo();
        teatro.mostrarInfo();
        e1.mostrarEntrada();
        e2.mostrarEntrada();
        pepe.listarEventos();

        // Escenario con iluminación (composición)
        Escenario escenario = new Escenario("Escenario Principal", 80);
        escenario.preparar();
    }
}
