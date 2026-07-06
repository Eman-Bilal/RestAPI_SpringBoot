package com.example.RESTAPI_Application.Models;

public class PhoneDetails {
    private String primary;
    private String emergency;

    public PhoneDetails() {

    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }
}