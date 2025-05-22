package Tema7.demo.src.main.java.com.example.aplicacion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaBasica extends Application {
    // Application es la clase base de todas las aplicaciones de JavaFX
    @Override
    public void start(Stage stage) {
        // Punto de entrada principal de una aplicación JavaFX
        // stage representa la ventana principal

        // La clase Button está en javafx.scene.control
        Button btn = new Button("Hola JavaFx");

        // Contenedor que coloca los elementos centrados
        StackPane root = new StackPane(btn);

        // Scene representa el contenido visual de la ventana
        Scene scene = new Scene(root, 300, 200);

        // Título de la ventana
        stage.setTitle("Ventana Básica");

        // Asigna la escena que se ha creado a la ventana
        stage.setScene(scene);

        // Muestra la ventana. ¡Es obligatorio!
        stage.show();
    }

    public static void main(String[] args) {
        // Inicializar JavaFX y llamar al método start(Stage) automáticamente
        launch(args);
    }
}