module es.airamlinares.catalogojuegos {
    requires javafx.controls;
    exports es.airamlinares.catalogojuegos;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    opens es.airamlinares.catalogojuegos to java.xml.bind;
}
