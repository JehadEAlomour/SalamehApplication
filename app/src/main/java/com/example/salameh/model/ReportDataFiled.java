package com.example.salameh.model;



public class ReportDataFiled {
private int imageView;
private String nameReport;

    public ReportDataFiled(int imageView, String nameReport) {
        this.imageView = imageView;
        this.nameReport = nameReport;
    }

    public int getImageView() {

        return imageView;
    }

    public String getNameReport() {
        return nameReport;
    }
}
