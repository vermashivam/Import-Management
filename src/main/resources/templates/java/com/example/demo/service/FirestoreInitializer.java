package com.example.demo.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FirestoreInitializer {

    //@Value("${gcp.projectId}")
    private String projectId = "test-firestore-native-project";

    private Firestore db;

    /**
     * Initialize Firestore using default project ID.
     */
    public FirestoreInitializer() throws IOException {
        System.out.println("Initializing this");
        System.out.println(projectId);
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setCredentials(credentials)
                        .setProjectId(projectId)
                        .build();
        Firestore db = firestoreOptions.getService();
        this.db = db;
    }

    /**
     * Get firestore db
     * @return
     */
    public Firestore getDb() {
        return db;
    }

}

