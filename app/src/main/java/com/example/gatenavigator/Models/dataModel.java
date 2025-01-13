package com.example.gatenavigator.Models;

import java.io.Serializable;

public class dataModel implements Serializable {
   private String id;
   private String timestamp;
   private String is_sync;
   private String gate;

    public dataModel(String id, String timestamp, String is_sync,String gate) {
        this.id = id;
        this.timestamp = timestamp;
        this.is_sync = is_sync;
        this.gate=gate;
    }

    public String getIs_sync() {
        return is_sync;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getGate() {
        return gate;
    }
}
