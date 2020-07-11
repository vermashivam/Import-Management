package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Importer {
    String name;
    String email;
    String phone;
    String gstn;
    String licenseNo;
    ArrayList<String> product;

    public Importer() {
    }

    public Importer(String name, String email, String phone, String gstn, String licenseNo, ArrayList<String> product) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gstn = gstn;
        this.licenseNo = licenseNo;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public ArrayList<String> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<String> product) {
        this.product = product;
    }
}
