import org.advent.dayeight.DayEight;
import org.advent.dayeight.Node;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayEightTests {

    @Test
    public void verifyNode() {

        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "AAA = (BBB, CCC)",
                "BBB = (DDD, EEE)",
                "CCC = (ZZZ, GGG)",
                "DDD = (DDD, DDD)",
                "EEE = (EEE, EEE)",
                "GGG = (GGG, GGG)",
                "ZZZ = (ZZZ, ZZZ)"
        ));

        DayEight dayEight = new DayEight();

        assertEquals(dayEight.nodeList(listOfStrings).get(0).getIndex(), 0);
        assertEquals(dayEight.nodeList(listOfStrings).get(0).getAddress(), "AAA");
        assertEquals(dayEight.nodeList(listOfStrings).get(0).getLeftPointer(), "BBB");
        assertEquals(dayEight.nodeList(listOfStrings).get(0).getRightPointer(), "CCC");

    }

    @Test
    public void verifyNumberOfStepsToReachEnd() {
        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "AAA = (BBB, BBB)",
                "BBB = (AAA, ZZZ)",
                "ZZZ = (ZZZ, ZZZ)"
        ));

        String directions = "LLR";

        DayEight dayEight = new DayEight();

        try {
            assertEquals(6, dayEight.numberOfStepsToReachEnd(listOfStrings, directions));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
