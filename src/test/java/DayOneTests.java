import org.example.DayOneClean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTests {

    @Test
    public void testTotalSumOfEntireListPartOne() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"));

        DayOneClean dayOneClean = new DayOneClean();

        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, true)).toList();
        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, true)).toList();

        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();

        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);

        assertEquals(142, totalSum);
    }

    @Test
    public void testTotalSumOfEntireListPartTwo() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"));

        DayOneClean dayOneClean = new DayOneClean();

        List<String> listOfFirstNumbersFromLeft = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), false, false)).toList();
        List<String> listOfFirstNumbersFromRight = listOfStrings.stream()
                .map(s -> dayOneClean.returnFirstNumberFromString(String.valueOf(s), true, false)).toList();

        List<String> listOfCombinedNumbersFromLeftAndRight =
                IntStream.range(0, listOfFirstNumbersFromLeft.size())
                        .mapToObj(i -> listOfFirstNumbersFromLeft.get(i) + listOfFirstNumbersFromRight.get(i)).toList();

        int totalSum = dayOneClean.addAllNumbersTogether(listOfCombinedNumbersFromLeftAndRight);

        assertEquals(281, totalSum);
    }

    @Test
    public void testFirstNumberFromTheLeftOnEachRowForPartTwo() {
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

        DayOneClean dayOneClean = new DayOneClean();
        List<String> firstNumberFromLeftList = listOfStrings.stream().map(s -> dayOneClean.returnFirstNumberFromString(s, false, false)).toList();
        assertEquals("2", firstNumberFromLeftList.get(0));
        assertEquals("8", firstNumberFromLeftList.get(1));
        assertEquals("1", firstNumberFromLeftList.get(2));
        assertEquals("2", firstNumberFromLeftList.get(3));
        assertEquals("4", firstNumberFromLeftList.get(4));
        assertEquals("1", firstNumberFromLeftList.get(5));
        assertEquals("7", firstNumberFromLeftList.get(6));
        assertEquals("3", firstNumberFromLeftList.get(7));
        assertEquals("9", firstNumberFromLeftList.get(8));
        assertEquals("8", firstNumberFromLeftList.get(9));
    }

    @Test
    public void testFirstNumberFromTheRightOnEachRowForPartTwo() {
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

        DayOneClean dayOneClean = new DayOneClean();
        List<String> firstNumberFromLeftList = listOfStrings.stream().map(s -> dayOneClean.returnFirstNumberFromString(s, true, false)).toList();
        assertEquals("9", firstNumberFromLeftList.get(0));
        assertEquals("3", firstNumberFromLeftList.get(1));
        assertEquals("3", firstNumberFromLeftList.get(2));
        assertEquals("4", firstNumberFromLeftList.get(3));
        assertEquals("2", firstNumberFromLeftList.get(4));
        assertEquals("4", firstNumberFromLeftList.get(5));
        assertEquals("3", firstNumberFromLeftList.get(6));
        assertEquals("3", firstNumberFromLeftList.get(7));
        assertEquals("3", firstNumberFromLeftList.get(8));
        assertEquals("8", firstNumberFromLeftList.get(9));
    }

    @Test
    public void testFirstNumberFromTheLeftOnEachRowForPartOne() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "two1nine",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "sevenine3",
                "seightwoone8qxcfgszninesvfcnxc68"
        ));

        DayOneClean dayOneClean = new DayOneClean();
        List<String> firstNumberFromLeftList = listOfStrings.stream().map(s -> dayOneClean.returnFirstNumberFromString(s, false, true)).toList();
        assertEquals("1", firstNumberFromLeftList.get(0));
        assertEquals("2", firstNumberFromLeftList.get(1));
        assertEquals("3", firstNumberFromLeftList.get(2));
        assertEquals("4", firstNumberFromLeftList.get(3));
        assertEquals("2", firstNumberFromLeftList.get(4));
        assertEquals("3", firstNumberFromLeftList.get(5));
        assertEquals("8", firstNumberFromLeftList.get(6));
    }

    @Test
    public void testFirstNumberFromTheRightOnEachRowForPartOne() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "two1nine",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "sevenine3",
                "seightwoone8qxcfgszninesvfcnxc68"
        ));

        DayOneClean dayOneClean = new DayOneClean();
        List<String> firstNumberFromLeftList = listOfStrings.stream().map(s -> dayOneClean.returnFirstNumberFromString(s, true, true)).toList();
        assertEquals("1", firstNumberFromLeftList.get(0));
        assertEquals("2", firstNumberFromLeftList.get(1));
        assertEquals("3", firstNumberFromLeftList.get(2));
        assertEquals("2", firstNumberFromLeftList.get(3));
        assertEquals("4", firstNumberFromLeftList.get(4));
        assertEquals("3", firstNumberFromLeftList.get(5));
        assertEquals("8", firstNumberFromLeftList.get(6));
    }
}
