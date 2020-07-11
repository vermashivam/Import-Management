package com.example.demo.service;

import com.example.demo.model.Importer;
import com.example.demo.repository.ImporterRepositoryFirestoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class ImportService {

    @Autowired
    ImporterRepositoryFirestoreImpl importerRepositoryFirestore;

    public void saveImporter(Importer importer)  {
        importer.getProduct().forEach(eachProduct -> eachProduct = eachProduct.toLowerCase() );
        importerRepositoryFirestore.saveImporter(importer);
    }

    public ArrayList<Importer> getImporterArrayList(String productType)  {
        productType = productType.toLowerCase();
        ArrayList<Importer> importerArrayList = importerRepositoryFirestore.getImporterArrayList(productType);
        return importerArrayList;
    }
}
