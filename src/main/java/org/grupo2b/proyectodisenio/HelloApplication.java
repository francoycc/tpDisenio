package org.grupo2b.proyectodisenio;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Cliente;
import org.grupo2b.proyectodisenio.logica.TestTemporalDB;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        //TipoDocumento tipoDoc = DAOManager.recover(TipoDocumento.class, 1);
        DAOManager.save(TestTemporalDB.getCliente());
        DAOManager.save(TestTemporalDB.getCliente2());

        /*for(Cliente o:DAOManager.getSession().createNativeQuery("select * from cliente", Cliente.class).list()){
            System.out.println(o);
        }*/

        CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
        CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
        Root<Cliente> root = cr.from(Cliente.class);



        cr.select(root).where(
                cb.and(
                        cb.like(root.get("nroCliente"),"%"),
                        cb.like(root.get("nombre"),"%"),
                        cb.like(root.get("apellido"),"%"),
                        cb.gt(root.join("documento").get("numero"), 22222223)));

        System.out.println(cr.toString());



        Query<Cliente> query = DAOManager.getSession().createQuery(cr);
        List<Cliente> results = query.getResultList();

        System.out.println("Numero Cliente | Nombre | Apellido | TipoDoc | Nro Doc");
        for (Cliente c : results){
            System.out.println(""+c.getNroCliente()+"|"+c.getNombre()+"|"+c.getApellido()+"|"+c.getDocumento().getTipoDocumento().getNombre()+"|"+c.getDocumento().getNumero());
        }

        //launch();
    }


}