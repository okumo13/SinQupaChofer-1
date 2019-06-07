package com.sinqupa.chofer.model;

public class Employee {
    private double latitudeTravel;
    private double longitudeTravel;
    private Boolean activated;

    public Employee() {
    }

    public Employee( double latitudeTravel, double longitudeTravel, Boolean activated) {
        this.latitudeTravel = latitudeTravel;
        this.longitudeTravel = longitudeTravel;
        this.activated = activated;
    }

    public double getLatitudeTravel() {
        return latitudeTravel;
    }

    public void setLatitudeTravel(double latitudeTravel) {
        this.latitudeTravel = latitudeTravel;
    }

    public double getLongitudeTravel() {
        return longitudeTravel;
    }

    public void setLongitudeTravel(double longitudeTravel) {
        this.longitudeTravel = longitudeTravel;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}
