package DbManager.Models;

public class Filmografia {

    // ATRIBUTOS
    int id;
    private String titulo;
    private String fecha_estreno;
    private String sinopsis;
    private int pais_id;
    private int clasificacion_id;

    //CONSTRUCTOR
    public Filmografia ( int id,  String titulo,  String fecha_estreno,  String sinopsis,  int pais_id,  int clasificacion_id){
        this.id = id;
        this.titulo = titulo;
        this.fecha_estreno = fecha_estreno;
        this.sinopsis = sinopsis;
        this.pais_id = pais_id;
        this.clasificacion_id =clasificacion_id;

    }

    // Getters setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(String fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public int getClasificacion_id() {
        return clasificacion_id;
    }

    public void setClasificacion_id(int clasificacion_id) {
        this.clasificacion_id = clasificacion_id;
    }
}
