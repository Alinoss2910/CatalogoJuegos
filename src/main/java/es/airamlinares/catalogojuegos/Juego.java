package es.airamlinares.catalogojuegos;
public class Juego {
    
    private String titulo;
    private String desarrolladora;
    private String fechaPublicacion;
    private int mediaHoras;
    private double precio;
    
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
    
    public double getPrecio(){
        return precio;
    }
    
    public void setPrecio(double precio){
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
        r += "Desarrolladora: " + desarrolladora + "\n";
        r += "Fecha Publicacion: " + fechaPublicacion + "\n";
        r += "Horas: " + mediaHoras + "\n";
        r += "Precio: " + precio;
        return r;
    }
    public String horasToString(){
        String r = "Horas: " + mediaHoras;
        return r;
    }
    public String precioToString(){
        String r = "Precio: " + precio;
        return r;
    }
}
