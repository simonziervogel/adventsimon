package com.example.simonadvent;

import com.example.simonadvent.Day3.NumberLocation;
import com.example.simonadvent.Day3.Filter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3Part1Test {

    @Test
    @DisplayName("extractNumbersWithLocations(String str): returns all numbers in string in List")
    public void test() {
        List<NumberLocation> allNumbersInLine = new ArrayList<>();
        allNumbersInLine.add(new NumberLocation(1, "798"));
        allNumbersInLine.add(new NumberLocation(7, "145"));
        allNumbersInLine.add(new NumberLocation(19, "629"));
        allNumbersInLine.add(new NumberLocation(26, "579"));
        allNumbersInLine.add(new NumberLocation(34, "455"));
        allNumbersInLine.add(new NumberLocation(58, "130"));
        allNumbersInLine.add(new NumberLocation(74, "243"));
        allNumbersInLine.add(new NumberLocation(94, "154"));
        allNumbersInLine.add(new NumberLocation(105, "167"));

        var sut = new Filter();
        List<NumberLocation> actual = sut.extractNumbersWithLocations(".798...145.........629....579.....455.....................130.............243.................154........167.");
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(allNumbersInLine.get(i).getLocation(), actual.get(i).getLocation());
            assertEquals(allNumbersInLine.get(i).getNumber(), actual.get(i).getNumber());
            assertEquals(allNumbersInLine.get(i).getCountable(), actual.get(i).getCountable());
        }
    }

    @Test
    @DisplayName("setCountable(List<NumberLocation> allNumbersInLine, String line): checks for symbols !!IN!! line")
    public void test1() {
        List<NumberLocation> allNumbersInLine = new ArrayList<>();
        allNumbersInLine.add(new NumberLocation(1, "798"));
        allNumbersInLine.add(new NumberLocation(7, "145"));
        allNumbersInLine.add(new NumberLocation(19, "629"));
        allNumbersInLine.add(new NumberLocation(26, "579"));
        allNumbersInLine.add(new NumberLocation(34, "455"));
        allNumbersInLine.add(new NumberLocation(58, "130"));
        allNumbersInLine.add(new NumberLocation(74, "243"));
        allNumbersInLine.add(new NumberLocation(94, "154"));
        allNumbersInLine.add(new NumberLocation(105, "167"));

        List<NumberLocation> expected = allNumbersInLine;
        expected.get(4).setCountableTrue();

        var sut = new Filter();

        //when mockutils method to int

        List<NumberLocation> actual = sut.setCountable(allNumbersInLine, ".798...145.........629....579.....455#....................130.............243.................154........167.");
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i).getLocation(), actual.get(i).getLocation());
            assertEquals(expected.get(i).getNumber(), actual.get(i).getNumber());
            assertEquals(expected.get(i).getCountable(), actual.get(i).getCountable());
            System.out.println("Expected:   " + expected.get(i).getCountable() + "      Actual:   " + actual.get(i).getCountable());
        }
    }
}
