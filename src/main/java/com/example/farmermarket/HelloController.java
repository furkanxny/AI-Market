package com.example.farmermarket;

import com.example.farmermarket.Models.Consumer;
import com.example.farmermarket.Models.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;


public class HelloController {
    private ArrayList<String> registeredEmailArryList = new ArrayList<>();
    private final ObservableList<Person> listOfPeople = FXCollections.observableArrayList();
    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Button shopButton;
    private Firestore firestore;
    private static boolean key;
    private Stage stage;
    Person person;
    private static String ID;
    public void setID(String ID){
        this.ID = ID;
    }



    public HelloController(){
        this.stage = new Stage();
        firestore = HelloApplication.fstore;
    }

    public boolean loginUser(String email, String password) {
        ApiFuture<QuerySnapshot> future = firestore.collection("Users").whereEqualTo("Email", email).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            if (!documents.isEmpty()) {
                for (QueryDocumentSnapshot document : documents) {
                    String storedPassword = document.getString("Password");
                    if (storedPassword != null && storedPassword.equals(password)) {
                        initializeConsumerWithPersonData(document);
                        setID(document.getId());

                        return true;
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }


    private void initializeConsumerWithPersonData(QueryDocumentSnapshot document) {
        String name = document.getString("Name");
        String email = document.getString("Email");
        String password = document.getString("Password");
        Consumer consumer = Consumer.getInstance();
        consumer.setName(name);
    }


    public boolean readFirebase() {
        key = false;
        ApiFuture<QuerySnapshot> future =  HelloApplication.fstore.collection("Users").get();
        List<QueryDocumentSnapshot> documents;
        try
        {
            documents = future.get().getDocuments();
            if(documents.size()>0)
            {
                System.out.println("Outing data from firabase database....");
                listOfPeople.clear();
                for (QueryDocumentSnapshot document : documents)
                {
                    registeredEmailArryList.add((String) document.getData().get("Email"));
                    System.out.println(document.getId() + " => " + document.getData().get("Name"));
                    person  = new Person(
                            String.valueOf(document.getData().get("Name")),
                            String.valueOf(document.getData().get("Email")),
                            String.valueOf(document.getData().get("Password"))
                    );
                    listOfPeople.add(person);
                }
            }
            else
            {
                System.out.println("No data");
            }
            key=true;
        }
        catch (InterruptedException | ExecutionException ex)
        {
            ex.printStackTrace();
        }
        return key;
    }


    @FXML
    void shopButtonOnAction(ActionEvent event) throws IOException {
        readFirebase();
        System.out.println();
        String email = emailTF.getText();
        String password = passwordTF.getText();
        if (loginUser(email, password)) {
            System.out.println("LOGGED IN");
            switchScene(event);
        } else {
            Alert requirementsAlert = new Alert(Alert.AlertType.ERROR);
            requirementsAlert.setTitle("LOGIN ERROR");
            requirementsAlert.setHeaderText("LOGIN ERROR");
            requirementsAlert.setContentText("You have the incorrect username or password.");
            requirementsAlert.showAndWait();
        }
    }


    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shop.fxml"));
        Parent secondViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene on the current stage
        Scene scene = new Scene(secondViewRoot);
        stage.setScene(scene);
    }
}