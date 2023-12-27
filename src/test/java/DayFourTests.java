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

    @Test
    public void totalNumberOfEarnedScratchCards() {

        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"
        ));

        DayFour dayFour = new DayFour();

        List<String> listOfCutStrings = dayFour.removeFrontPartOfStringAndReturnList(listOfStrings);
        List<NumbersPerCard> listOfAllNumbersPerCard = dayFour.listOfAllNumbersPerCard(listOfCutStrings);
        dayFour.setMatchingNumberPerCard(listOfAllNumbersPerCard);
        dayFour.setNumberOfTotalPerCard(listOfAllNumbersPerCard);

        assertEquals(30, dayFour.totalSumOfNumbersOfTotalPerCard(listOfAllNumbersPerCard));

    }
}