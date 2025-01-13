package com.example.gatenavigator.Models;


public class VehicleType {
    private String id; // Vehicle type ID
    private String type; // Vehicle type name



    // Constructor
    public VehicleType() {
         }
    // Constructor
    public VehicleType(String id, String type) {
        this.id = id;
        this.type = type;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
