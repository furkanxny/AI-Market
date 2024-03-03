package com.example.farmermarket;
import com.google.gson.Gson;

import com.example.farmermarket.OpenAI.OpenAIRequestHandler;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.beans.value.ObservableStringValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AIChatController {

    @FXML
    private TextArea output;

    @FXML
    private TextField prompt;


    @FXML
    void enterOnAction(ActionEvent event) {
    GetResponse();
    }

    public static String organizeStringByWordCount(String input, int wordCount) {
        String[] words = input.split(" "); // Split the string into words
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (String word : words) {
            result.append(word).append(" ");
            count++;

            // After every 'wordCount' words, append a newline
            if (count % wordCount == 0) {
                result.append("\n");
            }
        }

        return result.toString().trim(); // Return the result, trimming any trailing whitespace
    }
    public void GetResponse() {
        try {
            String promptText = prompt.getText();
            String responseJson = OpenAIRequestHandler.makeRequest(promptText);
            JsonObject jsonObject = JsonParser.parseString(responseJson).getAsJsonObject();
            String content = jsonObject.getAsJsonArray("choices").get(0).getAsJsonObject().getAsJsonObject("message").get("content").getAsString();
            String resultString = organizeStringByWordCount(content, 10);
            output.setText(resultString);
            prompt.clear();
        } catch (IOException e) {
            output.setText("Error: " + e.getMessage());
        }
    }
    @FXML
    void toShopButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shop.fxml"));
        Parent secondViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene on the current stage
        Scene scene = new Scene(secondViewRoot);
        stage.setScene(scene);
    }
}
