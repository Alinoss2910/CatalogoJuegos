package es.airamlinares.catalogojuegos;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    static public void guadarDatosXML(Stage stage, Juegos listaJuegos) {
        JAXBContext contexto;
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save");
                fileChooser.setInitialFileName("fichero.xml");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", ".xml"));
                File file = fileChooser.showSaveDialog(stage);
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
