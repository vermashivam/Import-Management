package com.example.demo.repository;

import com.example.demo.model.Importer;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface IImporterRepository {
    void saveImporter(Importer importer) throws ExecutionException, InterruptedException;
    ArrayList<Importer> getImporterArrayList(String productType) throws ExecutionException, InterruptedException;
}
