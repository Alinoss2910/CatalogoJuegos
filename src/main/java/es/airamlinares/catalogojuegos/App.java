package es.airamlinares.catalogojuegos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
        
        Juego juego1 = new Juego("Elden Ring");
        System.out.println(juego1.getTitulo());
        juego1.setTitulo("Elden Ring");
        juego1.setDesarrolladora("FromSoftware");
        juego1.setMediaHoras(80);
        juego1.setFechaPublicacion("25/02/2022");
        juego1.setPrecio(67.98);
        System.out.println(juego1.getTitulo());
        
        Juegos juegos = new Juegos();
        juegos.getListaJuegos().add(juego1);
                
        HBox cargarGuardar = new HBox(10);
        cargarGuardar.setAlignment(Pos.CENTER);
        paneRoot.getChildren().add(cargarGuardar);
        
        Font fontNegritaTitulo = Font.font("Bahnschrift", FontWeight.BLACK, 20);
        Font fontRojo = Font.font("Bahnschrift", FontWeight.BLACK, FontPosture.REGULAR, 20);
        Font fontVerde = Font.font("Bahnschrift", FontWeight.BLACK, FontPosture.REGULAR, 20);
        
        Label labelTitulo = new Label("Carga un XML");
        labelTitulo.setFont(fontNegritaTitulo);
        Label labelDesarrolladora = new Label();
        Label labelFecha = new Label();
        Label labelHoras = new Label();
        Label labelPrecio = new Label();
        
        paneRoot.getChildren().add(labelTitulo);
        paneRoot.getChildren().add(labelDesarrolladora);
        paneRoot.getChildren().add(labelFecha);
        paneRoot.getChildren().add(labelHoras);
        paneRoot.getChildren().add(labelPrecio);
        
        Juego juego = juegos.getListaJuegos().get(juegoActual);
        
        HBox anteriorSiguiente = new HBox(10);
        anteriorSiguiente.setAlignment(Pos.CENTER);
        paneRoot.getChildren().add(anteriorSiguiente);
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
            labelTitulo.setText("Titulo: " + juego.getTitulo());
            labelDesarrolladora.setText("Desarrolladora: " + juego.getDesarrolladora());
            labelFecha.setText("Fecha: " + juego.getFechaPublicacion());
            labelHoras.setText(juego.horasToString());
            labelPrecio.setText(juego.precioToString());
         });
        
        //CREACION BOTON ANTERIOR
        Button botonAnterior = new Button("Anterior");
        anteriorSiguiente.getChildren().add(botonAnterior);
        botonAnterior.setOnAction((t) -> { 
            juegoActual--;
            System.out.println(juegoActual);
         try {
                labelTitulo.setText(juegos.getListaJuegos().get(juegoActual).getTitulo());
                labelDesarrolladora.setText(juegos.getListaJuegos().get(juegoActual).getDesarrolladora());
                labelFecha.setText(juegos.getListaJuegos().get(juegoActual).getFechaPublicacion());
                labelHoras.setText(juegos.getListaJuegos().get(juegoActual).horasToString());
                labelPrecio.setText(juegos.getListaJuegos().get(juegoActual).precioToString());
            } catch (Exception ex){
                
            }
         });
        
        //CREACION BOTON SIGUIENTE
        Button botonSiguiente = new Button("Siguiente");
        anteriorSiguiente.getChildren().add(botonSiguiente);
        botonSiguiente.setOnAction((t) -> { 
            juegoActual++;
            System.out.println(juegoActual);
            try {
                labelTitulo.setText(juegos.getListaJuegos().get(juegoActual).getTitulo());
                labelDesarrolladora.setText(juegos.getListaJuegos().get(juegoActual).getDesarrolladora());
                labelFecha.setText(juegos.getListaJuegos().get(juegoActual).getFechaPublicacion());
                labelHoras.setText(juegos.getListaJuegos().get(juegoActual).horasToString());
                labelPrecio.setText(juegos.getListaJuegos().get(juegoActual).precioToString());
            } catch (Exception ex){
                
            }
         });
        
        
    }

    public static void main(String[] args) {
        launch();
    }
}