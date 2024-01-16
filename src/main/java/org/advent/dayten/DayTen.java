package org.advent.dayten;

import org.advent.PrintSolution;
import org.advent.Util;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayTen implements PrintSolution {


    // FOR PART TWO
//     Go around the edges of the pipes and find every ., that will be a a O (replace with O)
//    Go through every dot, and see if any dot is connected to a O. If so, repeat the "go through every dot"
//    once no more dots are made into O, finish the loop. The rest of the dots are now tiles that are enclosed

    @Override
    public void printPartOne() throws IOException {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
//        System.out.println("Number of steps to reach furthest away = " + grid.numberOfStepsToReachFurthestAwayFromS(getStringsFromFile()));
    }

    @Override
    public void printPartTwo() throws IOException {

    }



//
//    private GridOfPipes startGrid(List<String> strings) {
//        GridOfPipes gridOfPipes = new GridOfPipes();
//        gridOfPipes.setUpGridWithPositionOfS(strings);
//        gridOfPipes.setFirstValidStepFromS();
//        gridOfPipes.
//        return gridOfPipes;
//    }

    private List<String> getStringsFromFile() {
        List<String> allStrings;
        try {
            allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayTen.txt").toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allStrings;
    }
}
