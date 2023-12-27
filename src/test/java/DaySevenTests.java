import org.advent.daySeven.DaySeven;
import org.advent.daySeven.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DaySevenTests {

    @Test
    public void assertCorrectTypeOfHand() {

        List<String> listOfHands = new ArrayList<>(List.of("55555 513", "AK364 163", "K553Q 563", "K6663 12", "83888 153", "83838 561", "A64A4 613"));
        List<Type> listOfTypes = List.of(Type.FIVE_OF_A_KIND, Type.HIGH_CARD, Type.ONE_PAIR, Type.THREE_OF_A_KIND, Type.FOUR_OF_A_KIND, Type.FULL_HOUSE, Type.TWO_PAIR);

        DaySeven daySeven = new DaySeven();

        for (int i = 0; i < listOfHands.size(); i++) {
            assertEquals(listOfTypes.get(i), daySeven.typeOfHand(listOfHands.get(i)));
        }
    }
}
