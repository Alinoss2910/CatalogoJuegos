package es.airamlinares.catalogojuegos;
public class Juego {
    
    private String titulo;
    private String desarrolladora;
    private String fechaPublicacion;
    private int mediaHoras;
    private float precio;
    
    public Juego(){
        
    }
    
    public Juego(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    
    public Juego(String titulo, String autor){
        this.titulo = titulo.toUpperCase();
        this.desarrolladora = autor;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo.toUpperCase();
    }
    
    public void setDesarrolladora(String desarrolladora){
        this.desarrolladora = desarrolladora;
    }
    
    public String getDesarrolladora(){
        return desarrolladora;
    }
    
    public int getMediaHoras(){
        return mediaHoras;
    }
    
    public void setMediaHoras(int mediaHoras){
        this.mediaHoras = mediaHoras;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    
    public String getFechaPublicacion(){
        return fechaPublicacion;
    }
    
    public void setFechaPublicacion(String fechaPublicacion){
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString(){
        String r = "";
        r += "Titulo: " + titulo + "\n";
        r += "Autor: " + desarrolladora;
        return r;
    }
}
