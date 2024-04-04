module pokedex.pokedex {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.apache.httpcomponents.httpclient;
    requires org.apache.httpcomponents.httpcore;
    requires com.google.gson;

    opens pokedex.application to javafx.fxml;
    exports pokedex.application;
    exports pokedex.controller;
    opens pokedex.integrations.dto to com.google.gson;
    exports pokedex.integrations.dto;
}