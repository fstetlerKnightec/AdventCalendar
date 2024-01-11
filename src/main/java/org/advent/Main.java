package org.advent;

import org.advent.daySeven.DaySeven;
import org.advent.dayeight.DayEight;
import org.advent.dayfour.DayFour;
import org.advent.dayone.DayOne;
import org.advent.daysix.DaySix;
import org.advent.dayten.DayTen;
import org.advent.daythree.DayThree;
import org.advent.daytwo.DayTwo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // DAY ONE OUTPUT
        DayOne dayOne = new DayOne();
        dayOne.printPartOne();
        dayOne.printPartTwo();

        // DAY TWO OUTPUT
        DayTwo dayTwo = new DayTwo();
        dayTwo.printPartOne();
        dayTwo.printPartTwo();

        // DAY THREE OUTPUT
        DayThree dayThree = new DayThree();
        dayThree.printPartOne();
        dayThree.printPartTwo();

        // DAY FOUR OUTPUT
        DayFour dayFour = new DayFour();
        dayFour.printPartOne();
        dayFour.printPartTwo();

        // DAY SIX OUTPUT
        DaySix daySix = new DaySix();
        daySix.printPartOne();
        daySix.printPartTwo();

        // DAY SEVEN OUTPUT
        DaySeven daySeven = new DaySeven();
        daySeven.printPartOne();
        daySeven.printPartTwo();

        // DAY EIGHT OUTPUT
        DayEight dayEight = new DayEight();
        dayEight.printPartOne();
        dayEight.printPartTwo();

        // DAY TEN OUTPUT
        DayTen dayTen = new DayTen();
        dayTen.printPartOne();
        dayTen.printPartTwo();


    }
}