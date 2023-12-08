import org.example.DayOne;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTests {

    @Test
    public void testTotalSumOfCalculationOfEntireList() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"));

        DayOne dayOne = new DayOne();
        Integer totalValue = dayOne.addAllNumbersTogether(listOfStrings);

        assertEquals(142, totalValue);

    }

    @Test
    public void testFirstNumberOnEachRow() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "sevenine3",
                "threeighthree",
                "nineighthree",
                "seightwoone8qxcfgszninesvfcnxc68"
        ));

        DayOne dayOne = new DayOne();
        List<Integer> firstNumberFromLeftList = dayOne.returnFirstNumberFromLeft(listOfStrings).stream().map(Integer::parseInt).toList();
        assertEquals(2, firstNumberFromLeftList.get(0));
        assertEquals(8, firstNumberFromLeftList.get(1));
        assertEquals(1, firstNumberFromLeftList.get(2));
        assertEquals(2, firstNumberFromLeftList.get(3));
        assertEquals(4, firstNumberFromLeftList.get(4));
        assertEquals(1, firstNumberFromLeftList.get(5));
        assertEquals(7, firstNumberFromLeftList.get(6));
        assertEquals(3, firstNumberFromLeftList.get(7));
        assertEquals(9, firstNumberFromLeftList.get(8));
        assertEquals(8, firstNumberFromLeftList.get(9));
    }

    @Test
    public void testLastNumberOnEachRow() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen",
                "6ddgeighthree"
        ));

        DayOne dayOne = new DayOne();
        List<Integer> firstNumberFromRightList = dayOne.returnFirstNumberFromRight(listOfStrings).stream().map(Integer::parseInt).toList();
        assertEquals(9, firstNumberFromRightList.get(0));
        assertEquals(3, firstNumberFromRightList.get(1));
        assertEquals(3, firstNumberFromRightList.get(2));
        assertEquals(4, firstNumberFromRightList.get(3));
        assertEquals(2, firstNumberFromRightList.get(4));
        assertEquals(4, firstNumberFromRightList.get(5));
        assertEquals(6, firstNumberFromRightList.get(6));
        assertEquals(3, firstNumberFromRightList.get(7));

    }

    @Test
    public void testSumOfAllValuesWithAdditionInput() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "eightwo1",
                "eighthree4",
                "nineight1",
                "sevenine3"
        ));

        DayOne dayOne = new DayOne();
        List<Integer> listOfPutTogetherNumbers = dayOne.addBothNumbersFromList(listOfStrings).stream().map(Integer::parseInt).toList();
        assertEquals(81, listOfPutTogetherNumbers.get(0));
        assertEquals(84, listOfPutTogetherNumbers.get(1));
        assertEquals(91, listOfPutTogetherNumbers.get(2));
        assertEquals(73, listOfPutTogetherNumbers.get(3));
    }
}
