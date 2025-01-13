package com.example.gatenavigator.Models;
public class KantaDetail {
    private String type;
    private String weight;
    private String time;

    public KantaDetail(String type, String weight, String time) {
        this.type = type;
        this.weight = weight;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getWeight() {
        return weight;
    }

    public String getTime() {
        return time;
    }
}
