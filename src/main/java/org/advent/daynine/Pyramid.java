package org.advent.daynine;

import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    public final Row startRow;
    public List<Row> listOfRows = new ArrayList<>();

    public Pyramid(Row startRow) {
        this.startRow = startRow;
    }

    public void setListOfRowsUntilZero() {
        Row row = startRow;
        listOfRows.add(row);

        int stopValue = row.integerList.getLast();
        while (stopValue != 0) {
            row = new Row(differencesBetweenValuesInList(row.integerList));
            listOfRows.add(row);
            stopValue = row.integerList.getLast();
        }
    }

    public List<Integer> differencesBetweenValuesInList(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < listOfIntegers.size() - 1; i++) {
            newList.add(listOfIntegers.get(i + 1) - listOfIntegers.get(i));
        }
        return newList;
    }
}
