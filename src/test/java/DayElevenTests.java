import org.advent.dayeleven.Space;
import org.advent.dayeleven.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayElevenTests {

    @Test
    public void testColumnAndRowPositionIsTheSame() {

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
    public void testInsertLineOnColumnOrRowWithNospace() {
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
        System.out.println(space.getColumns().get(0).getPositions().get(2).getCoordinate().getX());
    }
}
