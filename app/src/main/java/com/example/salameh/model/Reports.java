package com.example.salameh.model;

public class Reports {

    private String address;
    private String description;
    private String nerstLocation;
    private String typeReport;
    private String status;
public Reports()
{}
    public String getStatus() {
        return status;
    }

    public Reports(String address, String description, String nerstLocation, String typeReport,String status) {
        this.status =status;
        this.address = address;
        this.description = description;
        this.nerstLocation = nerstLocation;
        this.typeReport = typeReport;
    }



    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getNerstLocation() {
        return nerstLocation;
    }

    public String getTypeReport() {
        return typeReport;
    }

}
