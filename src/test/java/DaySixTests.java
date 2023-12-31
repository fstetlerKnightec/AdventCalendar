import org.advent.daysix.DaySix;
import org.advent.daysix.TimeDistance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaySixTests {

    @Test
    public void verifyTimeAndDistanceFromFirstRace() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> removedLabelString = daySix.removeLabelsFromFrontPartOfString(listOfStrings);
        List<TimeDistance> listOfTimeDistances = daySix.listOfTimeAndDistances(removedLabelString);

        assertEquals(7, listOfTimeDistances.get(0).getTimeRaceLasts());
        assertEquals(9, listOfTimeDistances.get(0).getTotalDistanceTraveled());
    }

    @Test
    public void allDistanceTraveledForOneRace() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> listWithoutLabels = daySix.removeLabelsFromFrontPartOfString(listOfStrings);
        List<TimeDistance> timeDistances = daySix.listOfTimeAndDistances(listWithoutLabels);

        List<Long> expectedValues = new ArrayList<>(Arrays.asList(0L, 6L, 10L, 12L, 12L, 10L, 6L, 0L));
        for (int buttonTime = 0; buttonTime < timeDistances.get(0).getTimeRaceLasts(); buttonTime++) {
            assertEquals(expectedValues.get(buttonTime), timeDistances.get(0).distanceTraveledPerRace(buttonTime));
        }
    }

    @Test
    public void numberOfSettingsAbleToBeatCurrentRecordForOneRace() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> listWithoutLabels = daySix.removeLabelsFromFrontPartOfString(listOfStrings);
        List<TimeDistance> timeDistances = daySix.listOfTimeAndDistances(listWithoutLabels);

        assertEquals(4, timeDistances.get(0).numberOfButtonHoldsBeatRecord());
    }

    @Test
    public void totalNumberOfSettingsAbleToBeatCurrentRecord() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> listWithoutLabels = daySix.removeLabelsFromFrontPartOfString(listOfStrings);
        List<TimeDistance> timeDistances = daySix.listOfTimeAndDistances(listWithoutLabels);

        assertEquals(288, daySix.totalNumberOfButtonHoldsThatBeatRecordMultiplied(timeDistances));
    }

    @Test
    public void numberOfWaysWithOneCombinedRace() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> listWithoutLabels = daySix.removeLabelsFromFrontPartOfString(listOfStrings);
        List<String> listCombinedNumbers = daySix.stringOfAllNumbersCombined(listWithoutLabels);
        List<TimeDistance> timeDistances = daySix.listOfTimeAndDistances(listCombinedNumbers);

        assertEquals(71503, daySix.totalNumberOfButtonHoldsThatBeatRecordMultiplied(timeDistances));
    }
}