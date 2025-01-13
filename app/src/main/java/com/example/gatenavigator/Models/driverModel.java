package com.example.gatenavigator.Models;

public class driverModel {
    private String date_time;
    private String agent_id;
    private String driver_name;
    private String mobile_no;
    private String vehicle_type;
    private String vehicle_no;
    private String is_sync;


    public driverModel(String date_time, String agent_id, String driver_name, String mobile_no, String vehicle_type, String vehicle_no, String is_sync) {
        this.date_time = date_time;
        this.agent_id = agent_id;
        this.driver_name = driver_name;
        this.mobile_no = mobile_no;
        this.vehicle_type = vehicle_type;
        this.vehicle_no = vehicle_no;
        this.is_sync = is_sync;
    }


    public String getVehicle_no() {
        return vehicle_no;
    }

    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getIs_sync() {
        return is_sync;
    }

    public void setIs_sync(String is_sync) {
        this.is_sync = is_sync;
    }
}
