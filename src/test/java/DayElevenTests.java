import org.advent.dayeleven.*;
import org.junit.Test;

import java.util.*;
import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayElevenTests {

    public SpaceFactory spaceFactory = new SpaceFactory();
    @Test
    public void verifyColumnAndRowPositionIsTheSame() {

        List<String> strings = List.of(
                "...1......",
                ".......2..",
                "3.........",
                "..........",
                "......4...",
                ".5........",
                ".........6",
                "..........",
                ".......7..",
                "8...9....."
        );

        Space space = spaceFactory.spaceCreator(strings, 2);

        List<Position> columnWithG = space.getColumns().get(7).positions();
        List<Position> rowWithG = space.getRows().get(1).positions();

        char charOnRow = rowWithG.get(7).character();
        char charOnColumn = columnWithG.get(1).character();

        assertEquals(charOnRow, charOnColumn);
        assertEquals('2', charOnRow);
    }

    @Test
    public void verifyWidthOfRowAndColumnWithOrWithoutSpace() {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."
        ));

        Space space = spaceFactory.spaceCreator(strings, 2);
        RowCol column1 = space.getColumns().get(1);
        RowCol column2 = space.getColumns().get(2);

        RowCol row1 = space.getRows().get(2);
        RowCol row2 = space.getRows().get(3);

        assertEquals(1, column1.getWidth());
        assertEquals(2, column2.getWidth());

        assertEquals(1, row1.getWidth());
        assertEquals(2, row2.getWidth());
    }

    @Test
    public void verifyMinimumStepsBetweenGalaxyInRowOneAndRowFive() {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."
        ));

        Space space = spaceFactory.spaceCreator(strings, 2);
        Position pos1 = space.getRows().get(1).positions().get(7);
        Position pos2 = space.getRows().get(5).positions().get(1);

        ToIntFunction<Position> posX = p -> p.coordinate().x();
        ToIntFunction<Position> posY = p -> p.coordinate().y();

        long stepsX = space.minimumStepsBetweenTwoPositions(pos1, pos2, space.columns, posX);
        long stepsY = space.minimumStepsBetweenTwoPositions(pos1, pos2, space.rows, posY);
        long totalSteps = stepsX + stepsY;

        assertEquals(13, totalSteps);
    }

    @Test
    public void verifySumOfAllMinimumStepsBetweenGalaxies() {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."
        ));

        Space space = spaceFactory.spaceCreator(strings, 2);
        List<Position> positions = space.galaxyPositions();
        long steps = space.loopPositionsAndFindSum(positions);
        assertEquals(374, steps);
    }


    @Test
    public void verifySumOfAllMinimumStepsBetweenGalaxiesForPartTwo() {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."
        ));

        Space space = spaceFactory.spaceCreator(strings, 100);
        List<Position> positions = space.galaxyPositions();
        long steps = space.loopPositionsAndFindSum(positions);
        assertEquals(8410, steps);


    }
}
