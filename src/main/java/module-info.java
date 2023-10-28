module com.example.proyectodisenio {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.grupo2b.proyectodisenio to javafx.fxml;
    exports org.grupo2b.proyectodisenio;
    exports org.grupo2b.proyectodisenio.interfaz;
    opens org.grupo2b.proyectodisenio.interfaz to javafx.fxml;
}