import org.advent.daynine.DayNine;
import org.advent.daynine.Pyramid;
import org.advent.daynine.PyramidFactory;
import org.advent.daynine.Row;
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
        List<Integer> listOfIntegers = pyramid.getListOfRows().getFirst().integerList();
        List<Row> listOfRows = pyramid.getListOfRows();

        Row firstRowInPyramid = listOfRows.getFirst();
        for (int i = 0; i < listOfDifference.size(); i++) {
            assertEquals(
                    listOfDifference.get(i),
                    firstRowInPyramid.differencesBetweenValuesInList(listOfIntegers).get(i));
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
        List<Row> listOfRows = pyramid.getListOfRows();

        for (int i = 0; i < pyramid.getListOfRows().size(); i++) {
            List<Integer> currentListExpected = listOfRows.get(i).integerList();
            for (int j = 0; j < currentListExpected.size(); j++) {
                assertEquals(
                        pyramidListExpected.get(i).get(j),
                        currentListExpected.get(j));
            }
        }
    }

    @Test
    public void verifyResultColumnForPyramid() {
        String startString = "1 3 6 10 15 21";
        List<Integer> resultColumn = List.of(28, 7, 1, 0);

        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(startString);
        pyramid.setListOfRowsUntilZero();

        for (int i = 0; i < resultColumn.size(); i++) {
            assertEquals(
                    resultColumn.get(i),
                    pyramid.resultList(false).get(i));
        }
    }

    @Test
    public void verifyTotalSumAllHighestValues() {
        List<String> list = List.of("0 3 6 9 12 15",
                "1 3 6 10 15 21",
                "10 13 16 21 30 45");

        DayNine dayNine = new DayNine();
        assertEquals(
                114,
                dayNine.sumOfHighestValueFromEachPyramid(list, false));
    }

    @Test
    public void verifyResultColumnForPyramidPartTwo() {
        String startString = "10 13 16 21 30 45";
        List<Integer> resultColumn = List.of(5, 5, -2, 2, 0);

        PyramidFactory pyramidFactory = new PyramidFactory();
        Pyramid pyramid = pyramidFactory.createPyramid(startString);
        pyramid.setListOfRowsUntilZero();

        for (int i = 0; i < resultColumn.size(); i++) {
            assertEquals(
                    resultColumn.get(i),
                    pyramid.resultList(true).get(i));
        }
    }
}
