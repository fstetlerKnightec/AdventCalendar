package org.advent.daysix;

public class TimeDistance {
    private final long timeRaceLasts;
    private final long totalDistanceTraveled;

    public TimeDistance(long time, long distance) {
        this.timeRaceLasts = time;
        this.totalDistanceTraveled = distance;
    }

    public int numberOfButtonHoldsBeatRecord() {
        int totalNumberOfSettingsAbleToBeatRecord = 0;

        for (int buttonTime = 0; buttonTime < timeRaceLasts; buttonTime++) {
            long distanceTraveled = distanceTraveledPerRace(buttonTime);
            if (totalDistanceTraveled < distanceTraveled) {
                totalNumberOfSettingsAbleToBeatRecord += 1;
            }
        }
        return totalNumberOfSettingsAbleToBeatRecord;
    }

    public long distanceTraveledPerRace(long buttonTime) {
        return buttonTime*(timeRaceLasts - buttonTime);
    }

    public long getTimeRaceLasts() {
        return timeRaceLasts;
    }

    public long getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

}