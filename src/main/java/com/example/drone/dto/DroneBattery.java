package com.example.drone.dto;

public class DroneBattery {

    private Integer batteryLevel;

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public DroneBattery(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
