package mx.uv;

import static spark.Spark.*;
import mx.uv.BD.Usuario;
import mx.uv.BD.Operaciones;
import mx.uv.BD.Pregunta;

import com.google.gson.*;
import java.util.UUID;

/*
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
*/

public class App 
{
    private static Gson gson = new Gson();
    //private static Map<String, Usuario> usuarios = new HashMap<>();
    public static void main( String[] args ) {

        port(getHerokuAssignedPort());

        staticFiles.location("/");

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) -> {
            res.redirect("login.html");
            return null;
        });

        post("/usuario", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Usuario u = gson.fromJson(payload, Usuario.class);
            u.setID(id);

            Operaciones dao = new Operaciones();
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearUsuario(u));
            objetoJson.addProperty("id", id);
            return objetoJson;
        });

        post("/usuarioB", (req, res) -> {
            String payload = req.body();
            Usuario u = gson.fromJson(payload, Usuario.class);
            String email = u.getEmail();
            String password = u.getPassword();

            Operaciones dao = new Operaciones();
            JsonObject objetoJson = new JsonObject();
            dao.buscarUsuario(email, password);
            return objetoJson;
        });




        //*********************************** PREGUNTAS **********************************
        post("/pregunta", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();
            Operaciones dao = new Operaciones();
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearPregunta(p));
            objetoJson.addProperty("id", id);
            //return objetoJson;
            return new Gson().toJson(objetoJson);
        });

        /*
        post("/preguntaC", (req, res) -> {
            String payload = req.body();
            String id = UUID.randomUUID().toString();

            Pregunta p = gson.fromJson(payload, Pregunta.class);

            p.setId(id);

            Operaciones dao = new Operaciones();
            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("status", dao.crearPregunta(p));
            objetoJson.addProperty("id", id);
            return objetoJson;
        });
        */

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
