package org.advent.dayten;

import java.util.ArrayList;
import java.util.List;

public class GridOfPipes {

    private final List<String> listOfStrings;

    public GridOfPipes(List<String> listOfStrings) {
        this.listOfStrings = listOfStrings;
    }

    public List<List<Character>> grid() {
        List<List<Character>> grid = new ArrayList<>();
        for (int i = 0; i < listOfStrings.size(); i++) {
            List<Character> characters = new ArrayList<>();
            String currentLine = listOfStrings.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                characters.add(currentLine.charAt(j));
            }
            grid.add(characters);
        }
        return grid;
    }

    public Position getPositionOfS() {
        List<List<Character>> grid = grid();
        for (int i = 0; i < grid.size(); i++) {
            List<Character> currentRow = grid.get(i);
            for (int j = 0; j < currentRow.size(); j++) {
                if (currentRow.get(j).equals('S')) {
                    return new Position(j, i);
                }
            }
        }
        return null;
    }

    public Character getCharacterFromGrid(Position position) {
        return grid().get(position.yPosition).get(position.xPosition);
    }

    public Position setNextPositionOnPipePath(Position currentPosition) {

    }
}
