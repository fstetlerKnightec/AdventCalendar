import org.advent.daySeven.DaySeven;
import org.advent.daySeven.Hand;
import org.advent.daySeven.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DaySevenTests {

    @Test
    public void verifyCorrectTypeOfHand() {

        List<String> listOfStrings = new ArrayList<>(List.of("55555 513", "AK364 163", "K553Q 563", "K6663 12", "83888 153", "83838 561", "A64A4 613"));
        List<Type> listOfTypes = List.of(Type.FIVE_OF_A_KIND, Type.HIGH_CARD, Type.ONE_PAIR, Type.THREE_OF_A_KIND, Type.FOUR_OF_A_KIND, Type.FULL_HOUSE, Type.TWO_PAIR);

        for (int i = 0; i < listOfStrings.size(); i++) {
            assertEquals(listOfTypes.get(i), new Hand(listOfStrings.get(i)).getType());
        }
    }

    @Test
    public void verifyRankOfHand() {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("32T3K 765");
        listOfStrings.add("T55J5 684");
        listOfStrings.add("KK677 28");
        listOfStrings.add("KTJJT 220");
        listOfStrings.add("QQQJA 483");

        List<String> listOfHandsInOrderOfRank = List.of("32T3K", "KTJJT", "KK677", "T55J5", "QQQJA");

        DaySeven daySeven = new DaySeven();
        ArrayList<Hand> listOfHands = daySeven.getListOfHands(listOfStrings);
        List<Hand> listOfSortedHands = daySeven.sortedHandsByRank(listOfHands, true);

        for (int i = 0; i < listOfSortedHands.size(); i++) {
            assertEquals(listOfHandsInOrderOfRank.get(i), listOfSortedHands.get(i).getHandString());
        }
    }


    @Test
    public void verifyTotalWinnings() {

        List<String> listOfStrings = new ArrayList<>(List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483"
        ));

        DaySeven daySeven = new DaySeven();

        ArrayList<Hand> listOfHands = daySeven.getListOfHands(listOfStrings);
        List<Hand> listOfSortedHands = daySeven.sortedHandsByRank(listOfHands, true);

        assertEquals(6440, daySeven.totalWinnings((ArrayList<Hand>) listOfSortedHands));
    }

    @Test
    public void verifyRankOfHandForPartTwo() {
        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("32T3K 765");
        listOfStrings.add("T55J5 684");
        listOfStrings.add("KK677 28");
        listOfStrings.add("KTJJT 220");
        listOfStrings.add("QQQJA 483");

        List<String> listOfHandsInOrderOfRank = List.of("32T3K", "KK677", "T55J5", "QQQJA", "KTJJT");

        DaySeven daySeven = new DaySeven();
        ArrayList<Hand> listOfHands = daySeven.getListOfHands(listOfStrings);
        List<Hand> listOfSortedHands = daySeven.sortedHandsByRank(listOfHands, false);

        for (int i = 0; i < listOfSortedHands.size(); i++) {
            assertEquals(listOfHandsInOrderOfRank.get(i), listOfSortedHands.get(i).getHandString());
        }
    }

}
