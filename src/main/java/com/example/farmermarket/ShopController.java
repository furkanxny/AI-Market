package com.example.farmermarket;

import com.example.farmermarket.Models.Consumer;
import com.example.farmermarket.Models.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Button toCheckoutButton;
    ImageView[] ImgViewArry = new ImageView[14];
    Image[] pngArry  =  new Image[14];
    File[] fileArray = new File[14];
    @FXML
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7
            ,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14;
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(Consumer.getInstance().getName());
        initializeArrays();
        initializeImages();
        initializeProducts();
    }

    public void initializeArrays(){
        this.ImgViewArry = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7
                ,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14};
    }

    public void initializeImages() {
        int i;
        for (i = 0; i < 12; ++i) {
            this.fileArray[i] = new File("src/main/resources/Products/" + i + ".png");
            this.fileArray[12] = new File("src/main/resources/Products/title.png");
            this.fileArray[13] = new File("src/main/resources/Products/cart.png");

        }
        for (i = 0; i < 13; ++i) {
            this.pngArry[i] = new Image(this.fileArray[i].toURI().toString());
            this.pngArry[12] = new Image(this.fileArray[12].toURI().toString());
        }
        this.pngArry[13] = new Image(this.fileArray[13].toURI().toString());
    }

public void initializeProducts(){
        for (int i = 0; i < 12; i++){
            ImgViewArry[i].setImage(pngArry[i]);
            }
        ImgViewArry[12].setImage(pngArry[12]);
        ImgViewArry[13].setImage(pngArry[13]);

}

    @FXML
    void toCheckoutButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));
        Parent secondViewRoot = loader.load();

        // Get the current stage using the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene on the current stage
        Scene scene = new Scene(secondViewRoot);
        stage.setScene(scene);
    }
    }


