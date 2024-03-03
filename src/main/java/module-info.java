module com.example.farmermarket {
    requires javafx.controls;
    requires javafx.fxml;

    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires com.google.api.apicommon;
    requires com.google.auth;
    requires java.logging;
    requires google.cloud.core;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;

    opens com.example.farmermarket.OpenAI to com.google.gson;

    opens com.example.farmermarket to javafx.fxml;
    exports com.example.farmermarket;
    exports com.example.farmermarket.Models;
    opens com.example.farmermarket.Models to javafx.fxml;
}