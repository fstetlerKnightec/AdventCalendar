import org.advent.dayeleven.Galaxy;
import org.junit.Test;

import java.util.List;

public class DayElevenTests {

    @Test
    public void testColumnAndRowPositionIsTheSame() {

        List<String> strings = List.of(
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
        );

        Galaxy galaxy = new Galaxy(strings);
    }
}
