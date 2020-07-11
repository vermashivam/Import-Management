package com.example.demo.controller;

import com.example.demo.model.Importer;
import com.example.demo.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

@Controller
public class ImportController {

    @Autowired
    ImportService importService;

    @GetMapping("/newImporter")
    public String newInporter(){
        return "importProfile";
    }

    @PostMapping("/newImporter")
    public String newImporter(@ModelAttribute Importer importer){
        System.out.println("in newImporter()");
        importService.saveImporter(importer);
        /*
        System.out.println(importer.getName());
        System.out.println(importer.getEmail());
        System.out.println(importer.getPhone());
        System.out.println(importer.getGstn());
        System.out.println(importer.getLicenseNo());
        for(String eachProduct: importer.getProduct())
            System.out.println(eachProduct);
         */
        return "searchProduct";
    }

    @GetMapping("/searchProduct")
    public String userSearch(){ return  "searchProduct"; }

    @PostMapping("/searchProduct")
    public String userSearch(@RequestParam("product") String productType, Model model){
        System.out.println("in userSearch() for product : " + productType );
        ArrayList<Importer> importerArrayList = importService.getImporterArrayList(productType);
        if(importerArrayList.isEmpty())
            return "noImporterFound";
        model.addAttribute("importerArrayList",importerArrayList);
        return "importerList";
    }

}
