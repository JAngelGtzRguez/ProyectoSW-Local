package mx.uv.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;



public class Operaciones {
    
    private Conexion conexion = new Conexion();

    //************************* CREAR USUARIO ***************************

    public String crearUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();
        try {
            String sql = "INSERT INTO usuarios (ID, email, password) VALUES (?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getID());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getPassword());

            if (stm.executeUpdate() > 0)
                msj = "El usuario fue agregado";
            else
                msj = "El usuario no se agrego";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }

    //************************* BUSCAR USUARIO EN BASE DE DATOS ***************************

    public void buscarUsuario(String email, String password){
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;

        con = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios WHERE email='"+email+"' AND password='"+password+"'";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            if(rs.next()){
                System.out.println("Bienvendio Usuario");
                if (java.awt.Desktop.isDesktopSupported()) {
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
         
                    if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                        try {
                            java.net.URI uri = new java.net.URI("http://localhost:4567/inicio.html");
                            desktop.browse(uri);
                        } catch (URISyntaxException | IOException ex) {}
                    }
                }
            }else{
                System.out.println("No pudo ingresar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    //************************* CREAR PREGUNTA EN BASE DE DATOS ***************************

    public String crearPregunta(Pregunta p) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";
        String video = "Ruta video";
        String idC = "1";
        String tipo = "jejej";

        con = conexion.getConnection();
        try {
            String sql = "INSERT INTO preguntas (id, pregunta, tipo, video, idC) VALUES (?, ?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, p.getId());
            stm.setString(2, p.getPregunta());
            stm.setString(3, tipo);
            stm.setString(4, video);
            stm.setString(5, idC);

            if (stm.executeUpdate() > 0){
                msj = "La pregunta fue agregada";
                System.out.println("Se agrego la pregunta a la BD");
            }else{
                System.out.println("NO se agrego la pregunta a la BD");
                msj = "El pregunta fue agregada";
            }

            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
     
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI("http://localhost:4567/pregunta.html");
                        desktop.browse(uri);
                    } catch (URISyntaxException | IOException ex) {}
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }


        //************************* BUSCAR PREGUNTA EN BASE DE DATOS ***************************
        public List<Pregunta> listaPreguntas() {
            Statement stm = null;
            ResultSet rs = null;
            Connection con = null;
            List<Pregunta> resultado = new ArrayList<>();
    
            con = conexion.getConnection();
            try {
                String sql = "SELECT * FROM preguntas WHERE idC = 1";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Pregunta p = new Pregunta(rs.getString("id"), rs.getString("pregunta"), rs.getString("tipo"), rs.getString("video"), rs.getString("idC"));
                    resultado.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                    rs = null;
                }
                if (stm != null) {
                    try {
                        stm.close();
                    } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                    stm = null;
                }
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return resultado;
        }
    



    /*
    public void crearPregunta(Pregunta p) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        String video ="ruta video";

        con = conexion.getConnection();
        try {
            String sql = "INSERT INTO preguntas (id, pregunta, tipo, video) VALUES (?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, p.getId());
            stm.setString(2, p.getPregunta());
            stm.setString(3, p.getTipo());
            stm.setString(4, video);

            if (stm.executeUpdate() > 0){
                //msj = "La pregunta fue agregada";
                System.out.println("Se agrego la pregunta a la BD");
            }else
                System.out.println("NO se agrego la pregunta a la BD");
                //msj = "El pregunta fue agregada";
            
               
        /*
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
    }*/

    /*
    public List<Usuario> listaUsuario() {
        Statement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<Usuario> resultado = new ArrayList<>();

        con = conexion.getConnection();
        try {
            String sql = "SELECT * FROM usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("ID"), rs.getString("email"), rs.getString("password"));
                resultado.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
        
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                rs = null;
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException sqlEx) { sqlEx.printStackTrace(); } // ignore
                stm = null;
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    
    public String actualizarUsuario(Usuario u) {
        PreparedStatement stm = null;
        Connection con = null;
        String msj = "";

        con = conexion.getConnection();
        try {
            String sql = "UPDATE usuarios SET ID=?, email=?, contrase??a=? WHERE email=?";
            stm = con.prepareStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getPassword());
            stm.setString(4, u.getEmail());

            if (stm.executeUpdate() > 0)
                msj = "El usuario fue actualizado";
            else
                msj = "El usuario no se actualizo";

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msj;
        
    }
    */

    
   

}
