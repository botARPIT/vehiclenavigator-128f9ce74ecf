package com.example.gatenavigator.Models;
public class LoadingPoint {
    private String id; // Loading point ID
    private String point; // Loading point name



    // Constructor
    public LoadingPoint() {
    }

    public LoadingPoint(String id, String point) {
        this.id = id;
        this.point = point;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "LoadingPoint{" +
                "id='" + id + '\'' +
                ", point='" + point + '\'' +
                '}';
    }
}
