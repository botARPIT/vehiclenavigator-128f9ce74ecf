package com.example.gatenavigator.Models;

public class VehicleTransaction {
    private String id; // Transaction ID
    private String date; // Transaction date
    private String vehicleNo; // Vehicle number
    private String vehicleType; // Vehicle type
    private String customerName; // Customer name
    private String transporterName; // Transporter name
    private String gateJson; // Gate JSON
    private String kantaJson; // Kanta JSON
    private String loadingJson; // Loading JSON
    private String approvalStatus; // Approval status
    private String uniqueKey; // Unique user code
    private int syncStatus; // Sync status (0 = not synced, 1 = synced)


    public VehicleTransaction() {
    }

    // Constructor
    public VehicleTransaction(String id, String date, String vehicleNo, String vehicleType,
                              String customerName, String transporterName, String gateJson,
                              String kantaJson, String loadingJson, String approvalStatus,
                              String uniqueKey, int syncStatus) {
        this.id = id;
        this.date = date;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.customerName = customerName;
        this.transporterName = transporterName;
        this.gateJson = gateJson;
        this.kantaJson = kantaJson;
        this.loadingJson = loadingJson;
        this.approvalStatus = approvalStatus;
        this.uniqueKey = uniqueKey;
        this.syncStatus = syncStatus;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getGateJson() {
        return gateJson;
    }

    public void setGateJson(String gateJson) {
        this.gateJson = gateJson;
    }

    public String getKantaJson() {
        return kantaJson;
    }

    public void setKantaJson(String kantaJson) {
        this.kantaJson = kantaJson;
    }

    public String getLoadingJson() {
        return loadingJson;
    }

    public void setLoadingJson(String loadingJson) {
        this.loadingJson = loadingJson;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    @Override
    public String toString() {
        return "VehicleTransaction{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", transporterName='" + transporterName + '\'' +
                ", gateJson='" + gateJson + '\'' +
                ", kantaJson='" + kantaJson + '\'' +
                ", loadingJson='" + loadingJson + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", uniqueKey='" + uniqueKey + '\'' +
                ", syncStatus=" + syncStatus +
                '}';
    }
}

