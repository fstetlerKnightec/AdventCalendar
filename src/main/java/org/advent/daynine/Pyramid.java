package org.advent.daynine;

import java.util.ArrayList;
import java.util.List;

public class Pyramid {

    private final List<Row> listOfRows = new ArrayList<>();

    public Pyramid(Row startRow) {
        listOfRows.add(startRow);
    }

    public void setListOfRowsUntilZero() {
        Row row = listOfRows.getLast();
        while (!listOfRows.getLast().integerList().stream().allMatch(value -> value == 0)) {
            row = new Row(row.differencesBetweenValuesInList(row.integerList()));
            listOfRows.add(row);
        }
    }

    public List<Integer> resultList(boolean isPartTwo) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = listOfRows.size() - 1; i > 0; i--) {
            List<Integer> lastRowInList = listOfRows.get(i - 1).integerList();
            if (isPartTwo) {
                result.addFirst(lastRowInList.getFirst() - result.getFirst());
            } else {
                result.addFirst(lastRowInList.getLast() + result.getFirst());
            }
        }
        return result;
    }

    public List<Row> getListOfRows() {
        return listOfRows;
    }
}
