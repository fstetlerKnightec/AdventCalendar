package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        List<String> listOfStrings = dayOne.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");
        System.out.println(dayOne.calculateSumOfAllValues(listOfStrings));
    }
}