import org.advent.daytwo.oldStuff.DayTwoClean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTwoTests {

    @Test
    public void testSumOfIDsFromAcceptableGames() {
        List<String> listOfGames = new ArrayList<>(Arrays.asList(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green;",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue;",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red;",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red;",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green;"
        ));

        DayTwoClean dayTwoClean = new DayTwoClean();
        int totalSum = dayTwoClean.sumOfAllIDsFromAllowedGames(listOfGames);
        assertEquals(8, totalSum);
    }

    @Test
    public void testSumOfAllPoweredValues() {
        List<String> listOfGames = new ArrayList<>(Arrays.asList(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green;",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue;",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red;",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red;",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green;"
        ));

        DayTwoClean dayTwoClean = new DayTwoClean();

        int totalValue = 0;
        for (String s : listOfGames) {
            totalValue += dayTwoClean.powerOfCurrentGame(s);
        }
        assertEquals(2286, totalValue);
    }
}
