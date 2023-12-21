package org.advent.daysix;

public class TimeDistance {

    private int timeRaceLasts;

    private int totalDistanceTraveled;

    public TimeDistance() {


    }

    public TimeDistance(int time, int distance) {
        this.timeRaceLasts = time;
        this.totalDistanceTraveled = distance;
    }

    public int getTimeRaceLasts() {
        return timeRaceLasts;
    }

    public void setTimeRaceLasts(int timeRaceLasts) {
        this.timeRaceLasts = timeRaceLasts;
    }

    public int getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(int totalDistanceTraveled) {
        this.totalDistanceTraveled = totalDistanceTraveled;
    }

}