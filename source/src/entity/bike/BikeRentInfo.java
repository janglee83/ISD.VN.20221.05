package entity.bike;

import entity.dock.Dock;

public class BikeRentInfo {

    private Bike bike;

    private int seconds;

    private int minutes;

    private int hours;

    private Dock returnedDock;

    public BikeRentInfo() {
    }

    public BikeRentInfo(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // getter setter operation
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Dock getReturnedDock() {
        return returnedDock;
    }

    public void setReturnedDock(Dock returnedDock) {
        this.returnedDock = returnedDock;
    }
}
