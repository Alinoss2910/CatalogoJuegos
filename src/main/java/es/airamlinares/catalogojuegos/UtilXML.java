package es.airamlinares.catalogojuegos;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    //Guardar XML en el PC
    static public void guadarDatosXML(Stage stage, Juegos listaJuegos) {
        JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();//Crea el fileChooser
                fileChooser.setTitle("Save");//Nombre de la ventana
                fileChooser.setInitialFileName("fichero.xml");//Nombre por defecto del archivo a guardar
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", ".xml"));//Extension a utilizar para guardar
                File file = fileChooser.showSaveDialog(stage);//Muestra la ventana
                //Vuelca los datos del XML en un archivo
                contexto = JAXBContext.newInstance(Juegos.class);
                Marshaller marshaller = contexto.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
                marshaller.marshal(listaJuegos, System.out);
                marshaller.marshal(listaJuegos, file);
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
            }
    }
    
    //Carga XML desde el PC
    static public Juegos importarDatosXML(Stage stage, Juegos listaJuegos) {
        try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Load");
                File file = fileChooser.showOpenDialog(stage);
                JAXBContext contexto = JAXBContext.newInstance(Juegos.class);
                Unmarshaller unmarshall = contexto.createUnmarshaller();
                Juegos juegosNuevo = new Juegos();
                juegosNuevo = (Juegos)unmarshall.unmarshal(file);
                return juegosNuevo;
            } catch (JAXBException ex) {
                System.out.println("Se ha producido un error");
                ex.printStackTrace();
                return null;
            }
    }    
}
