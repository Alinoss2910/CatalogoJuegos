package es.airamlinares.catalogojuegos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        // Crea el primer y unico juego
        Juego juego1 = new Juego("Elden Ring");
        System.out.println(juego1.getTitulo());
        juego1.setTitulo("Elden Ring");
        juego1.setDesarrolladora("FromSoftware");
        juego1.setMediaHoras(60);
        juego1.setFechaPublicacion("25/02/2022");
        juego1.setPrecio(67.98);
        System.out.println(juego1.getTitulo());
        
        //Crea la lista de juegos
        Juegos juegos = new Juegos();
        juegos.getListaJuegos().add(juego1);//Añade el primer juego a la lista
        
        //Crea el Hbox de los botones de cargar y guardar
        HBox cargarGuardar = new HBox(10);
        cargarGuardar.setAlignment(Pos.CENTER); // Pone en el centro los elementos del Hbox
        paneRoot.getChildren().add(cargarGuardar);
        
        //Fuentes que se van a usar en los label donde se muestran los datos de los juegos
        Font fontNegritaTitulo = Font.font("Bahnschrift", FontWeight.BLACK, 20);
        Font fontNormal = Font.font("Bahnschrift", 15);
        Font fontRojo = Font.font("Bahnschrift", FontWeight.BLACK, 15);
        Font fontVerde = Font.font("Bahnschrift", FontWeight.BLACK, 15);
        
        //Crea los label de los datos de los juegos
        Label labelTitulo = new Label("Carga un XML");
        labelTitulo.setFont(fontNegritaTitulo);
        Label labelDesarrolladora = new Label();
        labelDesarrolladora.setFont(fontNormal);
        Label labelFecha = new Label();
        labelFecha.setFont(fontNormal);
        Label labelHoras = new Label();
        Label labelPrecio = new Label();
        
        //Añade los label al VBox que es la ventana
        paneRoot.getChildren().add(labelTitulo);
        paneRoot.getChildren().add(labelDesarrolladora);
        paneRoot.getChildren().add(labelFecha);
        paneRoot.getChildren().add(labelHoras);
        paneRoot.getChildren().add(labelPrecio);
        
        //Crea el HBox para los botones de anterior y siguente
        HBox anteriorSiguiente = new HBox(10);
        anteriorSiguiente.setAlignment(Pos.CENTER);
        paneRoot.getChildren().add(anteriorSiguiente);
        //Boton de guardar
        Button guardar = new Button("Guardar");
        cargarGuardar.getChildren().add(guardar);
        //Cuando haces clic en el boton llama al metodo guardarDatos de UtilXML
        guardar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("has pulsado");
            UtilXML.guadarDatosXML(stage, juegos);
          });
        
        //Boton Cargar
        Button cargar = new Button("Cargar");
        cargarGuardar.getChildren().add(cargar);
        //Cuando haces clic llama a fusionar libros de la clase juegos y en los label pone los datos que se pide de cada juego
        cargar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println(juegos.getListaJuegos().get(juegoActual).getPrecio());
            if(juegos.getListaJuegos().get(juegoActual).getPrecio() > 60.00) {
                labelPrecio.setFont(fontRojo);
                labelPrecio.setTextFill(Color.RED);
            }else{
                labelPrecio.setFont(fontVerde);
                labelPrecio.setTextFill(Color.GREEN);
            }
            //Si las horas no superan 20 se ponen en verde si la superan se pone en rojo
            if(juegos.getListaJuegos().get(juegoActual).getMediaHoras() > 50 ) {
                labelPrecio.setFont(fontRojo);
                labelPrecio.setTextFill(Color.RED);
            }else{
                labelPrecio.setFont(fontVerde);
                labelPrecio.setTextFill(Color.GREEN);
            }
            System.out.println("has pulsado");
            juegos.fusionarLibros(stage);
            labelTitulo.setText("Titulo: " + juegos.getListaJuegos().get(juegoActual).getTitulo());
            labelDesarrolladora.setText("Desarrolladora: " + juegos.getListaJuegos().get(juegoActual).getDesarrolladora());
            labelFecha.setText("Fecha: " + juegos.getListaJuegos().get(juegoActual).getFechaPublicacion());
            labelHoras.setText(juegos.getListaJuegos().get(juegoActual).horasToString());
            labelPrecio.setText(juegos.getListaJuegos().get(juegoActual).precioToString());
         });
        
        
        
        //Boton ANTERIOR
        Button botonAnterior = new Button("Anterior");
        anteriorSiguiente.getChildren().add(botonAnterior);
        //Cuando haces clic pasa al juego anterior decrementado juegoActual
        botonAnterior.setOnAction((t) -> {
            juegoActual--;
            //Comprueba si juegoActual es menor que 0 si es así pone juegoActual con el valor del tamaño de la lista
            if(juegoActual < 0) {
                juegoActual = juegos.getListaJuegos().size()-1;
            }
            // Si el precio es mayor de 60 se pone en rojo si es menor se pone en verde
            if(juegos.getListaJuegos().get(juegoActual).getPrecio() > 60.00) {
                labelPrecio.setFont(fontRojo);
                labelPrecio.setTextFill(Color.RED);
            }else{
                labelPrecio.setFont(fontVerde);
                labelPrecio.setTextFill(Color.GREEN);
            }
            //Si las horas no superan 20 se ponen en verde si la superan se pone en rojo
            if(juegos.getListaJuegos().get(juegoActual).getMediaHoras() > 20 ) {
                labelPrecio.setFont(fontRojo);
                labelPrecio.setTextFill(Color.RED);
            }else{
                labelPrecio.setFont(fontVerde);
                labelPrecio.setTextFill(Color.GREEN);
            }
            //Pone en los label los datos requeridos de cada juego de la lista
            labelTitulo.setText("Titulo: " + juegos.getListaJuegos().get(juegoActual).getTitulo());
            labelDesarrolladora.setText("Desarrolladora: " + juegos.getListaJuegos().get(juegoActual).getDesarrolladora());
            labelFecha.setText("Fecha: " + juegos.getListaJuegos().get(juegoActual).getFechaPublicacion());
            labelHoras.setText(juegos.getListaJuegos().get(juegoActual).horasToString());
            labelPrecio.setText(juegos.getListaJuegos().get(juegoActual).precioToString());
            System.out.println(juegoActual);
            System.out.println(juegos.getListaJuegos().get(juegoActual).getPrecio());
         });
        
        //Boton SIGUIENTE
        Button botonSiguiente = new Button("Siguiente");
        anteriorSiguiente.getChildren().add(botonSiguiente);
        //Cuando haces clic pasa al juego anterior incrementado juegoActual
        botonSiguiente.setOnAction((t) -> {
            juegoActual++;
            //Comprueba si juegoActual es mayor al número de juegos en lista si es así pone juegoActual a 0
            if(juegoActual >= juegos.getListaJuegos().size()) {
                juegoActual = 0;
            }
            System.out.println(juegos.getListaJuegos().get(juegoActual).getPrecio());
            // Si el precio es mayor de 60 se pone en rojo si es menor se pone en verde
            if(juegos.getListaJuegos().get(juegoActual).getPrecio() > 60.00) {
                System.out.println("Rojo");
                labelPrecio.setFont(fontRojo);
                labelPrecio.setTextFill(Color.RED);
            }else{
                System.out.println("Verde");
                labelPrecio.setFont(fontVerde);
                labelPrecio.setTextFill(Color.GREEN);
            }
            //Si las horas no superan 20 se ponen en verde si la superan se pone en rojo
            if(juegos.getListaJuegos().get(juegoActual).getMediaHoras() > 20 ) {
                labelHoras.setFont(fontRojo);
                labelHoras.setTextFill(Color.RED);
            }else{
                labelHoras.setFont(fontVerde);
                labelHoras.setTextFill(Color.GREEN);
            }
            //Pone en los label los datos requeridos de cada juego de la lista
            labelTitulo.setText("Titulo: " + juegos.getListaJuegos().get(juegoActual).getTitulo());
            labelDesarrolladora.setText("Desarrolladora: " + juegos.getListaJuegos().get(juegoActual).getDesarrolladora());
            labelFecha.setText("Fecha: " + juegos.getListaJuegos().get(juegoActual).getFechaPublicacion());
            labelHoras.setText(juegos.getListaJuegos().get(juegoActual).horasToString());
            labelPrecio.setText(juegos.getListaJuegos().get(juegoActual).precioToString());
            System.out.println(juegoActual);
            
         });
        
        
    }

    public static void main(String[] args) {
        launch();
    }
}