package co.uco.bitacora.domain.recomendacion;



public class Recomendacion {

    private long id;
    private String recomendacion;

    private long id_chek;


    public Recomendacion() {
        this.id =1;
        this.recomendacion = "ninguna recomendacion";
        this.id_chek=0;
    }

    public Recomendacion(long id, String recomendacion,long id_chek) {
        this.id = id;
        this.recomendacion = recomendacion;
        this.id_chek=id_chek;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public long getId_chek() {
        return id_chek;
    }

    public void setId_chek(long id_chek) {
        this.id_chek = id_chek;
    }
}
