package org.advent.daynine;

import java.util.Arrays;
import java.util.List;

public class PyramidFactory {

    public Pyramid createPyramid(String startString) {
        Pyramid pyramid = new Pyramid(new Row(getListOfIntegerFromString(startString)));
        pyramid.setListOfRowsUntilZero();
        return pyramid;
    }

    public List<Integer> getListOfIntegerFromString(String string) {
        return Arrays.stream(string.split(" ")).toList().stream().map(Integer::parseInt).toList();
    }


}
