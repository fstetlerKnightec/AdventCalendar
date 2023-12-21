package org.advent.daysix;

public class TimeDistance {
    private final int timeRaceLasts;
    private final int totalDistanceTraveled;

    public TimeDistance(int time, int distance) {
        this.timeRaceLasts = time;
        this.totalDistanceTraveled = distance;
    }

    public int numberOfButtonHoldsBeatRecord() {
        int totalNumberOfSettingsAbleToBeatRecord = 0;

        int totalTimeDuration = timeRaceLasts;
        for (int buttonTime = 0; buttonTime < totalTimeDuration; buttonTime++) {
            int distanceTraveled = distanceTraveledPerRace(buttonTime, totalTimeDuration);
            if (totalDistanceTraveled < distanceTraveled) {
                totalNumberOfSettingsAbleToBeatRecord += 1;
            }
        }
        return totalNumberOfSettingsAbleToBeatRecord;
    }

    public int distanceTraveledPerRace(int buttonTime, int totalTimeDuration) {
        return buttonTime*(totalTimeDuration - buttonTime);
    }

    public int getTimeRaceLasts() {
        return timeRaceLasts;
    }

    public int getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

}