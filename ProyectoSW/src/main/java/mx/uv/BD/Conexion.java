package mx.uv.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String url = "jdbc:mysql://db4free.net:3306/forms_final";
    private String driverName = "com.mysql.jdbc.Driver";
    private String user = "ltcroot";
    private String password = "12345678";
    private Connection con = null;

    public Connection getConnection(){
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Listo!");
        } catch (SQLException e) {
            System.out.println("Fallo!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");
            e.printStackTrace();
        }
        return con;
    }
}