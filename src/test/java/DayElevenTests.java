import org.advent.dayeleven.Column;
import org.advent.dayeleven.Galaxy;
import org.advent.dayeleven.Position;
import org.advent.dayeleven.Row;
import org.junit.Test;

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

        Galaxy galaxy = new Galaxy();

        galaxy.makeRows(strings);
        galaxy.makeColumnsFromExistingRows();

        List<Position> columnWithG = galaxy.getColumns().get(7).getPositions();
        List<Position> rowWithG = galaxy.getRows().get(1).getPositions();

        assertEquals(rowWithG.get(7), columnWithG.get(1));
        assertEquals('2', rowWithG.get(7).getCharacter());
    }
}
