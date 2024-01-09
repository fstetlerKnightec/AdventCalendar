import org.advent.daynine.DayNine;
import org.advent.daynine.Pyramid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayNineTests {

    @Test
    public void verifyDifferenceBetweenList() {
        String startString = "0 3 6 9 12 15";
        List<Integer> listOfDifference = List.of(3, 3, 3, 3, 3);

        Pyramid pyramid = new Pyramid(startString);
        List<Integer> listOfIntegers = pyramid.getListOfIntegerFromString();

        for (int i = 0; i < listOfDifference.size(); i++) {
            assertEquals(listOfDifference.get(i), pyramid.differencesBetweenValuesInList(listOfIntegers).get(i));
        }
    }

    @Test
    public void verifyPyramidUntilZero() {
        String startString = "1 3 6 10 15 21";
        List<List<Integer>> pyramidListExpected = List.of(
                List.of(1, 3, 6, 10, 15, 21),
                List.of(2, 3, 4, 5, 6),
                List.of(1, 1, 1, 1),
                List.of(0, 0, 0));

        Pyramid pyramid = new Pyramid(startString);
        pyramid.setListOfListsUntilZero();

        for (int i = 0; i < pyramidListExpected.size(); i++) {
            List<Integer> currentListExpected = pyramidListExpected.get(i);
            for (int j = 0; j < currentListExpected.size(); j++) {
                assertEquals(currentListExpected.get(j), pyramid.listOfLists.get(i).get(j));
            }
        }
    }
}
