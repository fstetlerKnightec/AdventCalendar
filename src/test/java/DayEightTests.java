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
                "AAA = (BBB, CCC)"
        ));

        DayEight dayEight = new DayEight();

        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").getIndex(), 0);
        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").getAddress(), "AAA");
        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").getLeftPointer(), "BBB");
        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").getRightPointer(), "CCC");

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
