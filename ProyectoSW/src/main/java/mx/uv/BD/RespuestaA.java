package mx.uv.BD;

public class RespuestaA  {
    private String id;
    private String respuesta;
    private String video;
    private String id_p;
    private String id_u;


    public RespuestaA(String id, String respuesta, String video, String id_p, String id_u) {

        this.setId(id);
        this.setRespuesta(respuesta);
        this.setVideo(video);
        this.setId_p(id_p);
        this.setId_u(id_u);
        
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }


    public String getVideo() {
        return video;
    }


    public void setVideo(String video) {
        this.video = video;
    }


    public String getId_p() {
        return id_p;
    }


    public void setId_p(String id_p) {
        this.id_p = id_p;
    }


    public String getId_u() {
        return id_u;
    }


    public void setId_u(String id_u) {
        this.id_u = id_u;
    }
  
}