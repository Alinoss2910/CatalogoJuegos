package es.airamlinares.catalogojuegos;
import java.util.ArrayList;
import javafx.stage.Stage;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Juegos {
    private ArrayList<Juego> listaJuegos = new ArrayList();
    
    public ArrayList<Juego> getListaJuegos(){
        return listaJuegos;
    }
    @XmlElement(name="Juego")
    public void setListaJuegos(ArrayList<Juego> listaJuegos){
        this.listaJuegos = listaJuegos;
    }
    public void fusionarLibros(Stage stage) {
        Juegos juegosNuevos = UtilXML.importarDatosXML(stage, this);
        this.getListaJuegos().addAll(juegosNuevos.getListaJuegos());
    }
}
