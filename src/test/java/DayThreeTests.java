import org.advent.daythree.DayThree;
import org.advent.daythree.Number;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayThreeTests {

    @Test
    public void testSumOfGears() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                ".............",
                ".467..114....",
                "...*.........",
                "..35..633....",
                "......#......",
                ".617*........",
                "......+.58...",
                "...592.......",
                ".......755...",
                "....$.*......",
                "..664.598....",
                "............."
        ));

        DayThree dayThree = new DayThree();
        List<Number> listOfNumbers = dayThree.listOfAllNumbers(listOfStrings);
        dayThree.setAdjacentToSymbolForNumber(listOfNumbers, listOfStrings);
        assertEquals(467835, dayThree.calculateTotalValueOfAllAdjacentValuesToStar(listOfNumbers));
    }

    @Test
    public void testSumOfGearsPartTwo() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                ".............",
                ".467..114....",
                "...*.........",
                "..35..633....",
                "......#......",
                ".617*........",
                "......+.58...",
                "...592.......",
                ".......755...",
                "....$.*......",
                "..664.598....",
                "............."
        ));

        DayThree dayThree = new DayThree();
        List<Number> listOfNumbers = dayThree.listOfAllNumbers(listOfStrings);
        dayThree.setAdjacentToSymbolForNumber(listOfNumbers, listOfStrings);
        assertEquals(4361, dayThree.getTotalAddedNumbersAdjacentToSymbol(listOfNumbers));
    }

}
