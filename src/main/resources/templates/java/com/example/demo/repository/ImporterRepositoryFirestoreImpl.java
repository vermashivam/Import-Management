package com.example.demo.repository;

import com.example.demo.model.Importer;
import com.example.demo.service.FirestoreInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public class ImporterRepositoryFirestoreImpl implements IImporterRepository {

    private final Firestore firestoreDb;

    @Autowired
    public ImporterRepositoryFirestoreImpl(final FirestoreInitializer fireStoreInitializer){
        firestoreDb = fireStoreInitializer.getDb();
    }

    @Override
    public void saveImporter(Importer importer)  {
        DocumentReference documentReference = firestoreDb.collection("importer").document();
        //WriteBatch batch = firestoreDb.batch();
        //batch.set(documentReference , importer);

        Map<String,Object> data =new HashMap<>();
        data.put("name", importer.getName());
        data.put("email", importer.getEmail());
        data.put("phone", importer.getPhone());
        data.put("gstn", importer.getGstn());
        data.put("licenseNo", importer.getLicenseNo());
        data.put("product", importer.getProduct());
        ApiFuture<WriteResult> result = documentReference.set(data);

        try {
            System.out.println("Document : "+ documentReference.getId() +" updated at :" + result.get().getUpdateTime() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Importer> getImporterArrayList(String productType)  {
        ArrayList<Importer> importerArrayList = new ArrayList<>();
        ApiFuture<QuerySnapshot> future =  firestoreDb.collection("importer").whereArrayContains("product", productType).get();
        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                importerArrayList.add(document.toObject(Importer.class));
                //System.out.println(document.getId() + " => " + document.toObject(Importer.class));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return importerArrayList;
    }
}
