import org.advent.daynine.Pyramid;
import org.advent.daynine.PyramidFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayNineTests {
    @Test
    public void verifyDifferenceBetweenList() {
        String startString = "0 3 6 9 12 15";
        List<Integer> listOfDifference = List.of(3, 3, 3, 3, 3);

        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(startString);
        pyramid.setListOfRowsUntilZero();
        for (int i = 0; i < listOfDifference.size(); i++) {
            assertEquals(listOfDifference.get(i), pyramid.differencesBetweenValuesInList(pyramidFactory.getListOfIntegerFromString(startString)).get(i));
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

        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(startString);
        pyramid.setListOfRowsUntilZero();

        for (int i = 0; i < pyramidListExpected.size(); i++) {
            List<Integer> currentListExpected = pyramidListExpected.get(i);
            for (int j = 0; j < currentListExpected.size(); j++) {
                assertEquals(currentListExpected.get(j), pyramid.getListOfRows().get(i).integerList().get(j));
            }
        }
    }

    @Test
    public void verifyResultColumnForPyramid() {
        String startString = "1 3 6 10 15 21";
        List<Integer> resultColumn = List.of(28, 7, 1, 0);

        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(startString);

        for (int i = 0; i < resultColumn.size(); i++) {
            assertEquals(resultColumn.get(i), pyramid.resultList().get(i));
        }
    }
}
