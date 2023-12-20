import org.advent.day6.DaySix;
import org.advent.day6.TimeDistance;
import org.junit.Test;

import java.nio.file.AccessDeniedException;
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
        int totalTimeDuration = 7;

        List<Integer> expectedValues = new ArrayList<>(Arrays.asList(0, 6, 10, 12, 12, 10, 6, 0));
        for (int buttonTime = 0; buttonTime < totalTimeDuration; buttonTime++) {
            assertEquals(expectedValues.get(buttonTime), daySix.distanceTraveledPerRace(buttonTime, totalTimeDuration));
        }
    }
}
