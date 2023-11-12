package org.grupo2b.proyectodisenio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.grupo2b.proyectodisenio.dao.DAOManager;
import org.grupo2b.proyectodisenio.logica.Objetos;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("interfaz/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        DAOManager.save(Objetos.CLIENTE1);
        DAOManager.save(Objetos.CLIENTE2);
        DAOManager.save(Objetos.POLIZA1);
        DAOManager.save(Objetos.POLIZA2);
        DAOManager.save(Objetos.POLIZA3);
        DAOManager.save(Objetos.POLIZA4);
        DAOManager.save(Objetos.POLIZA5);
        DAOManager.save(Objetos.POLIZA61);
        DAOManager.save(Objetos.POLIZA62);
        DAOManager.save(Objetos.POLIZA8);
        DAOManager.save(Objetos.POLIZA7);





        /*for(Cliente o:DAOManager.getSession().createNativeQuery("select * from cliente", Cliente.class).list()){
            System.out.println(o);
        }*/

        /*CriteriaBuilder cb = DAOManager.getSession().getCriteriaBuilder();
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
        }*/


        //TestTemporalDB.metodoPruebas();

        launch();
    }


}