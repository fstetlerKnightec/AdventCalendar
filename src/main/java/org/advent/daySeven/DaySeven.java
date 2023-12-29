package org.advent.daySeven;

import org.advent.PrintSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.advent.daySeven.Hand.getHandFromString;

public class DaySeven implements PrintSolution {


    public ArrayList<Hand> getListOfHands(List<String> listOfStrings) {
        ArrayList<Hand> arrayList = new ArrayList<>();
        for (String listOfString : listOfStrings) {
            arrayList.add(getHandFromString(listOfString));
        }
        return arrayList;
    }

    public List<Hand> sortedHandsByRank(ArrayList<Hand> listOfHands, boolean isPartOne) {



        if (!isPartOne) {
            for (Hand currentHand : listOfHands) {

                Map<Character, Long> charCounts = currentHand.handString
                        .chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));


                boolean hasThreeJsAndTwoIdentical = charCounts.getOrDefault('J', 0L) == 3
                        && charCounts.values().stream().anyMatch(count -> count == 2);

                if (charCounts.getOrDefault('J', 0L) == 5
                        || charCounts.getOrDefault('J', 0L) == 4
                        || hasThreeJsAndTwoIdentical) {
                    currentHand.setType(Type.FIVE_OF_A_KIND);
                    continue;
                }

                if (charCounts.getOrDefault('J', 0L) == 3) {
                    currentHand.setType(Type.FOUR_OF_A_KIND);
                    continue;
                }

                int increaseValue = (int) currentHand.getHandString().chars().filter(c -> c == 'J').count();
                if (increaseValue > 0) {
                    for (int i = 0; i < increaseValue; i++) {
                        currentHand.setType(currentHand.getType().next());
                    }
                    if (currentHand.getType().getValue() == 3 || currentHand.getType().getValue() == 5) {
                        currentHand.setType(currentHand.getType().next());
                    }
                }
                System.out.println("string = " + currentHand.getHandString() + " " + currentHand.getType());
            }
        }

        listOfHands.sort(new HandComparatorByRank(isPartOne));
        return listOfHands;
    }

    public int totalWinnings(ArrayList<Hand> listOfSortedHands) {
        int value = 0;

        for (int i = 0; i < listOfSortedHands.size(); i++) {
            value += listOfSortedHands.get(i).getBid()*(i+1);
        }

        return value;
    }

    @Override
    public void printPartOne(int result) {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total winnings are = " + result);
    }

    @Override
    public void printPartTwo(int result) {
        System.out.println(" ");
        System.out.println(this.getClass().getSimpleName() + " ---------------------------");
        System.out.println("Total winnings from part two are = " + result);
    }


//
//    public int setCardValue(char card) {
//
//        ))
//    }



}
