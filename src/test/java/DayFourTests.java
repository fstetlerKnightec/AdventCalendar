import org.advent.dayfour.DayFour;
import org.advent.dayfour.NumbersPerCard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayFourTests {

    @Test
    public void canReadLine() {
        String line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
        List<String> listOfStrings = new ArrayList<>(List.of(line));

        DayFour dayFour = new DayFour();
        List<String> listOfCutString = dayFour.removeFrontPartOfStringAndReturnList(listOfStrings);
        List<NumbersPerCard> listOfNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutString);
        NumbersPerCard number = listOfNumbersPerCard.get(0);

        int numberOfWinningNumbers = 5;
        int numberOfNumbersOnHand = 8;
        assertEquals(numberOfWinningNumbers, number.getWinningNumbers().size());
        assertEquals(numberOfNumbersOnHand, number.getNumbersYouHave().size());
    }


    @Test
    public void assertCorrectNumbersOnCard() {

        String line = "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19";
        List<String> listOfStrings = new ArrayList<>(List.of(line));

        DayFour dayFour = new DayFour();
        List<String> listOfCutString = dayFour.removeFrontPartOfStringAndReturnList(listOfStrings);
        List<NumbersPerCard> listOfNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutString);
        NumbersPerCard number = listOfNumbersPerCard.get(0);

        List<Integer> correctNumbers = new ArrayList<>(List.of(13, 32, 20, 16, 61));
        List<Integer> numbersYouHave = new ArrayList<>(List.of(61, 30, 68, 82, 17, 32, 24, 19));

        assertEquals(number.getWinningNumbers(), correctNumbers);
        assertEquals(number.getNumbersYouHave(), numbersYouHave);
    }

    @Test
    public void verifyAllWinningNumbersFromList() {

        List<String> listOfStrings = new ArrayList<>(List.of(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19"
        ));

        DayFour dayFour = new DayFour();

        List<NumbersPerCard> listOfNumbers = dayFour.listOfAllNumbersPerCard(dayFour.removeFrontPartOfStringAndReturnList(listOfStrings));

        List<Integer> winningNumbersOne = new ArrayList<>(Arrays.asList(41, 48, 83, 86, 17));
        List<Integer> winningNumberTwo = new ArrayList<>(Arrays.asList(13, 32, 20, 16, 61));

        assertEquals(winningNumbersOne, listOfNumbers.get(0).getWinningNumbers());
        assertEquals(winningNumberTwo, listOfNumbers.get(1).getWinningNumbers());
    }
}
