package mx.uv.BD;

public class Pregunta {
    private String id;
    private String pregunta;
    private String tipo;
    private String video;


    public Pregunta(String id, String pregunta, String tipo, String video) {

        this.setId(id);
        this.setPregunta(pregunta);
        this.setTipo(tipo);
        this.setVideo(video);
        
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getPregunta() {
        return pregunta;
    }


    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getVideo() {
        return video;
    }


    public void setVideo(String video) {
        this.video = video;
    }

}