import org.advent.dayten.DayTen;
import org.advent.dayten.GridOfPipes;
import org.advent.dayten.Position;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTenTests {

    @Test
    public void verifyPositionOfS() {
        List<String> strings = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        GridOfPipes gridOfPipes = new GridOfPipes();
        gridOfPipes.setUpGrid(strings);
        Position position = gridOfPipes.getPositionOfS();

        assertEquals(1, position.coordinate().getX());
        assertEquals(1, position.coordinate().getY());
    }

    @Test
    public void verifyFirstValidStepFromGrid() {
        List<String> strings = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        GridOfPipes gridOfPipes = new GridOfPipes();
        gridOfPipes.setUpGrid(strings);
        Position position = gridOfPipes.findFirstValidStepFromS();

        assertEquals(2, position.coordinate().getX());
        assertEquals(1, position.coordinate().getY());
    }

    @Test
    public void verifyNextStepFromPosition() {
        List<String> strings = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        GridOfPipes gridOfPipes = new GridOfPipes();
        gridOfPipes.setUpGrid(strings);
        DayTen dayTen = new DayTen();

        int numberOfSteps = dayTen.numberOfStepsToReachFurthestAwayFromS(strings);

        assertEquals(4, numberOfSteps);
    }
}
