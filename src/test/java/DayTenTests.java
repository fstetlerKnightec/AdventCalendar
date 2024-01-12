import org.advent.dayten.CoordinateDirection;
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
        gridOfPipes.createGrid(strings);
        Position position = gridOfPipes.getPositionOfS();

        assertEquals(1, position.xPosition());
        assertEquals(1, position.yPosition());

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
        gridOfPipes.createGrid(strings);
        Position position = gridOfPipes.findFirstValidStepFromS();

        assertEquals(2, position.xPosition());
        assertEquals(1, position.yPosition());

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
        gridOfPipes.createGrid(strings);
        Position position = gridOfPipes.findFirstValidStepFromS();
        Position previousPosition = gridOfPipes.getPositionOfS();

        CoordinateDirection direction = position.nextStep(previousPosition);
        System.out.println(previousPosition);
        System.out.println(position);
        System.out.println(direction);

    }
}
