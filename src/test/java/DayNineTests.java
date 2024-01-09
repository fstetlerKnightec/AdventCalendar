import org.advent.daynine.DayNine;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayNineTests {

    @Test
    public void verifyDifferenceBetweenList() {
        List<Integer> listOfIntegers = List.of(0, 3, 6, 9, 12, 15);
        List<Integer> listOfDifference = List.of(3, 3, 3, 3, 3);

        DayNine dayNine = new DayNine();

        for (int i = 0; i < listOfDifference.size(); i++) {
            assertEquals(listOfDifference.get(i), dayNine.differencesBetweenValuesInList(listOfIntegers).get(i));
        }
    }
}
