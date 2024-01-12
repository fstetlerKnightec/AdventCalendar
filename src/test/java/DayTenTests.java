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

//        int count = 0;
//        CoordinateDirection direction
//        while (position.character() != 'S') {
//            CoordinateDirection direction = position.nextStep(previousPosition);
//            System.out.println(direction);
//            char nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.yPosition()).character();
//            previousPosition = position;
//            position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
//            count += 1;
//            System.out.println(position.character());
//        }
//
//        System.out.println(count);


        CoordinateDirection direction = position.nextStep(previousPosition);
        System.out.println("prev = " + previousPosition);
        System.out.println("pos = " + position);
        System.out.println("dir = " + direction);
        char nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.yPosition()).character();
        previousPosition = position;
        position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
        System.out.println("next pos = " + position);

        System.out.println(" ");


        direction = position.nextStep(previousPosition);
        System.out.println("prev = " + previousPosition);
        System.out.println("pos = " + position);
        System.out.println("dir = " + direction);
        nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
        previousPosition = position;
        position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
        System.out.println("next pos = " + position);

        System.out.println(" ");

        direction = position.nextStep(previousPosition);
        System.out.println("prev = " + previousPosition);
        System.out.println("pos = " + position);
        System.out.println("dir = " + direction);
        nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
        previousPosition = position;
        position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
        System.out.println("next pos = " + position);

        System.out.println(" ");

        direction = position.nextStep(previousPosition);
        System.out.println("prev = " + previousPosition);
        System.out.println("pos = " + position);
        System.out.println("dir = " + direction);
        nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
        previousPosition = position;
        position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
        System.out.println("next pos = " + position);

        System.out.println(" ");

        direction = position.nextStep(previousPosition);
        System.out.println("prev = " + previousPosition);
        System.out.println("pos = " + position);
        System.out.println("dir = " + direction);
        nextCharacter = gridOfPipes.getPositionFromGrid(position.nextX(direction), position.nextY(direction)).character();
        previousPosition = position;
        position = new Position(position.nextX(direction), position.nextY(direction), nextCharacter);
        System.out.println("next pos = " + position);
//
//        System.out.println(" ");
    }
}
