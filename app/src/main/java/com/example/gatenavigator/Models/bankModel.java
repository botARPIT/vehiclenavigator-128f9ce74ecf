package com.example.gatenavigator.Models;

public class bankModel {
    private String driver_name;
    private  String mobile_no;
    private  String account_no;
    private  String bank_name;
    private  String bank_ifsc;
    private  String bank_upi_id;
    private  String agent_id;
    private  String is_sync;

    public bankModel(String driver_name, String mobile_no, String account_no, String bank_name, String bank_ifsc, String bank_upi_id, String agent_id, String is_sync) {
        this.driver_name = driver_name;
        this.mobile_no = mobile_no;
        this.account_no = account_no;
        this.bank_name = bank_name;
        this.bank_ifsc = bank_ifsc;
        this.bank_upi_id = bank_upi_id;
        this.agent_id = agent_id;
        this.is_sync = is_sync;
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

    public String getAccount_no() {
        return account_no;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_ifsc() {
        return bank_ifsc;
    }

    public void setBank_ifsc(String bank_ifsc) {
        this.bank_ifsc = bank_ifsc;
    }

    public String getBank_upi_id() {
        return bank_upi_id;
    }

    public void setBank_upi_id(String bank_upi_id) {
        this.bank_upi_id = bank_upi_id;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    public String getIs_sync() {
        return is_sync;
    }

    public void setIs_sync(String is_sync) {
        this.is_sync = is_sync;
    }
}
