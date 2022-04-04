package es.airamlinares.catalogojuegos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    int juegoActual = 0;
    @Override
    public void start(Stage stage) {
        VBox paneRoot = new VBox(20);
        paneRoot.setAlignment(Pos.CENTER);
        var scene = new Scene(paneRoot, 640, 480);
        stage.setScene(scene);
        stage.show();
        
        Juego juego1 = new Juego("Ficheros en Java");
        Juego juego2 = new Juego();
        Juego juego3 = new Juego("XML en java");
        System.out.println(juego1.getTitulo());
        juego1.setTitulo("Elden Ring");
        juego1.setDesarrolladora("FromSoftware");
        juego1.setMediaHoras(80);
        juego1.setFechaPublicacion("25/02/2022");
        System.out.println(juego1.getTitulo());
        
        Juegos juegos = new Juegos();
        juegos.getListaJuegos().add(juego1);
        juegos.getListaJuegos().add(juego2);
        juegos.getListaJuegos().add(juego3);
        
        HBox cargarGuardar = new HBox(10);
        cargarGuardar.setAlignment(Pos.CENTER);
        paneRoot.getChildren().add(cargarGuardar);
        
        Button guardar = new Button("Guardar");
        cargarGuardar.getChildren().add(guardar);
        guardar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("has pulsado");
            UtilXML.guadarDatosXML(stage, juegos);
          });
        
        Button cargar = new Button("Cargar");
        cargarGuardar.getChildren().add(cargar);
        cargar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("has pulsado");
            juegos.fusionarLibros(stage);
         });
        TextArea textArea = new TextArea();
        
        HBox anteriorSiguiente = new HBox(10);
        anteriorSiguiente.setAlignment(Pos.CENTER);
        paneRoot.getChildren().add(anteriorSiguiente);
        
        //CREACION BOTON SIGUIENTE
        Button botonSiguiente = new Button("Siguiente");
        anteriorSiguiente.getChildren().add(botonSiguiente);
        botonSiguiente.setOnAction((t) -> { 
            juegoActual++;
            try {
                textArea.setText(juegos.getListaJuegos().get(juegoActual));
            } catch (Exception ex){
            
            }
         });
        
        //CREACION BOTON ANTERIOR
        Button botonAnterior = new Button("Anterior");
        anteriorSiguiente.getChildren().add(botonAnterior);
        botonAnterior.setOnAction((t) -> { 
            juegoActual--;
         try {
                textArea.setText(juegos.getListaJuegos().get(juegoActual));
            } catch (Exception ex){
            
            }
         });
    }

    public static void main(String[] args) {
        launch();
    }

}