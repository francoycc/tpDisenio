package org.grupoXX;

import com.formdev.flatlaf.FlatLightLaf;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //UN LOOK AND FEEL QUE PODRIAMOS QUERER SI USAMOS SWING
        FlatLightLaf.setup();


        //EJEMPLO DE CONEXION A BASE DE DATOS
        String url = "jdbc:postgresql:proyecto";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        try {
            Connection conn = DriverManager.getConnection(url, props);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM prueba");

            while (rs.next()){
                System.out.println(rs.getString(1) +" "+ rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}