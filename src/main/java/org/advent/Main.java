package org.advent;

import org.advent.dayeight.DayEight;
import org.advent.dayeight.Node;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

//        // DAY ONE OUTPUT
//        DayOne dayOne = new DayOne();
//        dayOne.printPartOne();
//        dayOne.printPartTwo();
//
//        // DAY TWO OUTPUT
//        DayTwo dayTwo = new DayTwo();
//        dayTwo.printPartOne();
//        dayTwo.printPartTwo();
//
//        // DAY THREE OUTPUT
//        DayThree dayThree = new DayThree();
//        dayThree.printPartOne();
//        dayThree.printPartTwo();
//
//        // DAY FOUR OUTPUT
//        DayFour dayFour = new DayFour();
//        dayFour.printPartOne();
//        dayFour.printPartTwo();
//
//        // DAY SIX OUTPUT
//        DaySix daySix = new DaySix();
//        daySix.printPartOne();
//        daySix.printPartTwo();

        // DAY EIGHT OUTPUT
        DayEight dayEight = new DayEight();
        List<String> allStrings = Util.readStringsFromFile(Paths.get("src/main/resources/dayEight.txt").toString());
        List<String> leftRightNodeStrings = dayEight.allLeftRightNodes(allStrings);
        String directions = dayEight.rightLeftDirectionFromFile();

//        System.out.println(dayEight.findNodeMapFromPointer(nodeMap, nodeMap.get("BRR"), 'L').getLeftPointer());
        System.out.println(dayEight.numberOfStepsToReachEnd(leftRightNodeStrings, directions));


//        List<Node> listOfNodes = dayEight.nodeList(leftRightNodeStrings);
//        System.out.println(listOfNodes.get(listOfNodes.size() - 1).getAddress());


    }
}