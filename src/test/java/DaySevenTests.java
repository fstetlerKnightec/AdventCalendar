import org.advent.daySeven.DaySeven;
import org.advent.daySeven.Hand;
import org.advent.daySeven.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Hand> listOfSortedHands = daySeven.sortedHandsByRank(listOfHands);
//        System.out.println(listOfSortedHands.get(0).getHandString() + " " + listOfSortedHands.get(0).getBid());
//        System.out.println(listOfSortedHands.get(1).getHandString() + " " + listOfSortedHands.get(1).getBid());
//        System.out.println(listOfSortedHands.get(2).getHandString() + " " + listOfSortedHands.get(2).getBid());
//        System.out.println(listOfSortedHands.get(3).getHandString() + " " + listOfSortedHands.get(3).getBid());
//        System.out.println(listOfSortedHands.get(4).getHandString() + " " + listOfSortedHands.get(4).getBid());

        for (int i = 0; i < listOfSortedHands.size(); i++) {
            assertEquals(listOfHandsInOrderOfRank.get(i), listOfSortedHands.get(i).getHandString());
        }
    }

}
