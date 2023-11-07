module org.grupo2b.proyectodisenio {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;
    requires java.naming;


    opens org.grupo2b.proyectodisenio;
    opens org.grupo2b.proyectodisenio.logica.interfaz;
    opens org.grupo2b.proyectodisenio.logica.poliza;
    opens org.grupo2b.proyectodisenio.logica.historial;
    opens org.grupo2b.proyectodisenio.logica.cuentas;
    opens org.grupo2b.proyectodisenio.logica.vehiculo;

    exports org.grupo2b.proyectodisenio;
    exports org.grupo2b.proyectodisenio.logica.interfaz;
    exports org.grupo2b.proyectodisenio.logica;
    opens org.grupo2b.proyectodisenio.logica;
}