package com.example.farmermarket;

import com.example.farmermarket.Models.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checkout implements Initializable {

    @FXML
    private TextArea checkoutText;
    @FXML
    private Button toAIChat;
    static double sum = 0;

    private String newString;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newString = String.valueOf(ShopController.getStringBuilder());
        sumDollarAmounts(newString);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(newString);
        String line = "------------------------\n";
        String checkoutAmount = "Your Total Amount = $" + sum;
        stringBuilder.append(line);
        stringBuilder.append(checkoutAmount);
        String newnewString = String.valueOf(stringBuilder);
        String result = buildNewStringWithNewlines(newnewString);
        checkoutText.setText(result);

    }

    public static double sumDollarAmounts(String input) {
        Pattern pattern = Pattern.compile("\\$([\\d.]+)");
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            String amountString = matcher.group(1); // Extract the numerical part
            double amount = Double.parseDouble(amountString); // Convert to double
            sum += amount; // Add to sum
        }

        return sum;
    }

    public static String buildNewStringWithNewlines(String newString) {
        // Split the input string by colons
        String[] parts = newString.split(":");

        // Use StringBuilder to efficiently build the new string
        StringBuilder builder = new StringBuilder();

        for (String part : parts) {
            // Append each part followed by a newline
            builder.append(part).append("\n");
        }

        // Convert the StringBuilder back to a String
        return builder.toString();
    }

    @FXML
    void toAIChatOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AIChat.fxml"));
        Parent secondViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene on the current stage
        Scene scene = new Scene(secondViewRoot);
        stage.setScene(scene);
    }
}
