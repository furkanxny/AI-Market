package com.example.farmermarket;
import com.google.gson.Gson;

import com.example.farmermarket.OpenAI.OpenAIRequestHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AIChatController {

    @FXML
    private TextArea output;

    @FXML
    private TextField prompt;

    @FXML
    private Button enter;


    @FXML
    void enterOnAction(ActionEvent event) {
    GetResponse();
    }

    public void GetResponse() {
        try {
            String promptText = prompt.getText();
            String responseJson = OpenAIRequestHandler.makeRequest(promptText);

            output.setText(responseJson);
        } catch (IOException e) {
            output.setText("Error: " + e.getMessage());
        }
    }
}
