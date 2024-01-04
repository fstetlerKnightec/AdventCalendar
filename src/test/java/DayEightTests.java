import org.advent.dayeight.DayEight;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayEightTests {

    @Test
    public void verifyNode() {

        List<String> listOfStrings = new ArrayList<>(List.of(
                "AAA = (BBB, CCC)"
        ));

        DayEight dayEight = new DayEight();

        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").address(), "AAA");
        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").leftPointer(), "BBB");
        assertEquals(dayEight.nodeMap(listOfStrings).get("AAA").rightPointer(), "CCC");

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

        assertEquals(6, dayEight.numberOfStepsToReachZZZ(listOfStrings, directions));

    }

    @Test
    public void verifyNumberOfStepsToReachNodesThatAllEndInZ() {

        List<String> listOfStrings = new ArrayList<>(Arrays.asList(
                "11A = (11B, XXX)",
                "11B = (XXX, 11Z)",
                "11Z = (11B, XXX)",
                "22A = (22B, XXX)",
                "22B = (22C, 22C)",
                "22C = (22Z, 22Z)",
                "22Z = (22B, 22B)",
                "XXX = (XXX, XXX)"
        ));

        String directions = "LR";

        DayEight dayEight = new DayEight();

        assertEquals(6, dayEight.LCMOfAllPaths(listOfStrings, directions));

    }

}
