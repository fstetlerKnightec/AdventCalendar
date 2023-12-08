package org.example;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        DayTwo dayTwo = new DayTwo();
//        System.out.println(dayTwo.totalSumOfPowerValues(dayTwo.listOfGames));


        DayOneClean dayOneClean = new DayOneClean();
        List<String> listOfStrings = dayOneClean.readFileAndReturnList("C:\\Programming\\Java\\AdventCalendar\\src\\main\\resources\\dayOne.txt");


    }
}