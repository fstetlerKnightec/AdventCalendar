package org.advent.daynine;

import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    private final Row startRow;
    private final List<Row> listOfRows = new ArrayList<>(); //is it a bad idea to instantiate objects in the field?

    public Pyramid(Row startRow) {
        this.startRow = startRow;
    }

    public void setListOfRowsUntilZero() {
        Row row = startRow;
        listOfRows.add(row);
        while (!listOfRows.getLast().integerList().stream().allMatch(value -> value == 0)) {
            row = new Row(differencesBetweenValuesInList(row.integerList()));
            listOfRows.add(row);
        }
    }

    public List<Integer> differencesBetweenValuesInList(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < listOfIntegers.size() - 1; i++) {
            newList.add(listOfIntegers.get(i + 1) - listOfIntegers.get(i));
        }
        return newList;
    }

    public List<Integer> resultList(boolean isPartTwo) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = listOfRows.size() - 1; i > 0; i--) {
            if (isPartTwo) {
                result.add(0, listOfRows.get(i - 1).integerList().getFirst() - result.getFirst());
            } else {
                result.add(0, listOfRows.get(i - 1).integerList().getLast() + result.getFirst());
            }
        }
        return result;
    }

    public List<Row> getListOfRows() {
        return listOfRows;
    }
}
