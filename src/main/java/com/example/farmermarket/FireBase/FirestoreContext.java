package com.example.farmermarket.FireBase;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.IOException;

import static com.google.auth.oauth2.ServiceAccountCredentials.fromStream;

public class FirestoreContext {
        public Firestore firebase() {
            try {
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(fromStream(getClass().getResourceAsStream("/Firebase/key.json")))
                        .build();
                FirebaseApp.initializeApp(options);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return FirestoreClient.getFirestore();
        }

}
