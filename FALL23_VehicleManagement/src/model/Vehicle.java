/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author AD
 */
public class Vehicle implements Comparator<Vehicle>{
    private String vehicleID;
    private String vehicleName;
    private String vehicleColor;
    private double vehiclePrice;
    private String vehicleBrand;
    private String type;
    private int pruductYear;

    public Vehicle() {
    }
    
    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    
    public Vehicle(String vehicleID, String vehicleName, String vehicleColor, double vehiclePrice, String vehicleBrand, String type, int pruductYear) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehiclePrice = vehiclePrice;
        this.vehicleBrand = vehicleBrand;
        this.type = type;
        this.pruductYear = pruductYear;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPruductYear() {
        return pruductYear;
    }

    public void setPruductYear(int pruductYear) {
        this.pruductYear = pruductYear;
    }

    @Override
    public String toString() {
        return String.format("%-8s |%-15s |%-15s |%-14.1f $|%-12s |%-12s |%-8d", getVehicleID(), getVehicleName().toUpperCase(), getVehicleColor(), getVehiclePrice(), getVehicleBrand().toUpperCase(), getType().toUpperCase(), getPruductYear());
    }

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        if (o1.getVehiclePrice() < o2.getVehiclePrice()) {
            return 1;
        }
        if (o1.getVehiclePrice() > o2.getVehiclePrice()) {
            return -1;
        }
        return 0;
    }
}