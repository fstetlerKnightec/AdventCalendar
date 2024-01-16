import org.advent.dayten.DayTen;
import org.advent.dayten.GridOfPipes;
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
        gridOfPipes.setUpGridWithPositionOfS(strings);
        gridOfPipes.setFirstValidStepFromS();
        gridOfPipes.setLoopThroughPositionsToFindS();

        assertEquals(1, gridOfPipes.getPositionOfS().coordinate().x());
        assertEquals(1, gridOfPipes.getPositionOfS().coordinate().y());
    }

    @Test
    public void verifyFirstValidStepFromGrid() {
        List<String> strings = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        GridOfPipes grid = new GridOfPipes();
        grid.setUpGridWithPositionOfS(strings);
        grid.setFirstValidStepFromS();
        grid.setLoopThroughPositionsToFindS();

        assertEquals(2, grid.firstValidPosition.coordinate().x());
        assertEquals(1, grid.firstValidPosition.coordinate().y());
    }


    @Test
    public void verifyNextStepFromPosition() {
        List<String> strings = List.of(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                ".....");

        GridOfPipes grid = new GridOfPipes();
        grid.setUpGridWithPositionOfS(strings);
        grid.setFirstValidStepFromS();
        grid.setLoopThroughPositionsToFindS();

        int numberOfSteps = grid.numberOfStepsToReachFurthestAwayFromS();
        assertEquals(4, numberOfSteps);
    }

    @Test
    public void verifyNumberOfInsideLoop() {
        List<String> strings = List.of(
                "...........",
                ".S-------7.",
                ".|F-----7|.",
                ".||.....||.",
                ".||.....||.",
                ".|L-7.F-J|.",
                ".|..|.|..|.",
                ".L--J.L--J.",
                "..........."
        );

        GridOfPipes grid = new GridOfPipes();
        grid.setUpGridWithPositionOfS(strings);
        grid.setFirstValidStepFromS();
        grid.setLoopThroughPositionsToFindS();



    }
}
