import org.advent.daytwelve.DayTwelve;
import org.junit.Test;

import java.util.List;

public class DayTwelveTests {

//    Loop through the row, and have a method that is called "fullfills criteria" of the 1,1,3 or whatever
//    Then for each row replace a ? with a

    @Test
    public void verifyRow() {
        List<String> strings = List.of(
                "#.#.### 1,1,3",
                ".#...#....###. 1,1,3",
                ".#.###.#.###### 1,3,1,6",
                "####.#...#... 4,1,1",
                "#....######..#####. 1,6,5",
                ".###.##....# 3,2,1"
        );


        DayTwelve dayTwelve = new DayTwelve();

//        System.out.println(dayTwelve.getOriginalArrangementFromString(rows.getFirst()));
//        dayTwelve.getSetupFromString(rows.getFirst());
        System.out.println(dayTwelve.getRows(strings).getFirst().getSetupRule());
        System.out.println(dayTwelve.getRows(strings).getFirst().getOriginalArrangement());




    }



}
