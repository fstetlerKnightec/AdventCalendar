import org.advent.dayeleven.Column;
import org.advent.dayeleven.Row;
import org.advent.dayeleven.Space;
import org.advent.dayeleven.Position;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayElevenTests {

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

        Space space = new Space();

        space.makeRows(strings);
        space.makeColumnsFromExistingRows();

        List<Position> columnWithG = space.getColumns().get(7).getPositions();
        List<Position> rowWithG = space.getRows().get(1).getPositions();

        char charOnRow = rowWithG.get(7).getCharacter();
        char charOnColumn = columnWithG.get(1).getCharacter();

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

        Space space = new Space();

        space.makeRows(strings);
        space.makeColumnsFromExistingRows();

        Column column1 = space.getColumns().get(1);
        Column column2 = space.getColumns().get(2);

        Row row1 = space.getRows().get(2);
        Row row2 = space.getRows().get(3);

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

        Space space = new Space();

        space.makeRows(strings);
        space.makeColumnsFromExistingRows();

        Position pos1 = space.getRows().get(1).getPositions().get(7);

//        System.out.println(space.getRows().get(6).getPositions().get(9));
        Position pos2 = space.getRows().get(5).getPositions().get(1);


        int stepsX = space.minimumXStepsBetweenTwoCoordinates(pos1, pos2);
        int stepsY = space.minimumYStepsBetweenTwoCoordinates(pos1, pos2);

        int totalSteps = stepsX + stepsY;

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

        Space space = new Space();
        space.makeRows(strings);
        space.makeColumnsFromExistingRows();

        List<Position> positions = space.galaxyPositions();

        int steps = space.loopPositionsAndFindSum(positions);

        assertEquals(374, steps);


    }
}
