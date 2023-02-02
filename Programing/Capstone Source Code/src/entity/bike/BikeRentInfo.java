package entity.bike;

public class BikeRentInfo {

    private Bike bike;

    private int elapsedTime;

    private int seconds;

    private int minutes;

    private int hours;

    public void BikeRentInfo(int elapsedTime) {
        this.elapsedTime = elapsedTime + 1000;
        hours = (this.elapsedTime/3600000);
        minutes = (this.elapsedTime/60000) % 60;
        seconds = (this.elapsedTime/1000) % 60;
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
}
