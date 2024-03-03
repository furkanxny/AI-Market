package com.example.farmermarket;

import com.google.cloud.firestore.Firestore;
import com.example.farmermarket.FireBase.FirestoreContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Firestore fstore;

    private final FirestoreContext contxtFirebase = new FirestoreContext();
    @Override
    public void start(Stage PrimaryStage) throws IOException {
        fstore = contxtFirebase.firebase();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 505, 520);
        PrimaryStage.setTitle("Farmer's Market");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }}

