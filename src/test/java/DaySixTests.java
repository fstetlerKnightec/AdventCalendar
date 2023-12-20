import org.advent.day6.DaySix;
import org.advent.day6.TimeDistance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaySixTests {

    @Test
    public void totalReachedDistancePerRace() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Time:      7  15   30",
                "Distance:  9  40  200"
        ));

        DaySix daySix = new DaySix();

        List<String> removedLabelString = daySix.removeLabels(listOfStrings);
        List<TimeDistance> listOfTimeDistances = daySix.listOfTimeAndDistances(removedLabelString);

        assertEquals(7, listOfTimeDistances.get(0).getTimeRaceLasts());
        assertEquals(9, listOfTimeDistances.get(0).getTotalDistanceTraveled());

    }
}
