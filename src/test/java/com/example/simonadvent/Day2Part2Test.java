package com.example.simonadvent;

import com.example.simonadvent.Day2.CubeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Day2Part2Test {

    @Test
    @DisplayName("findHighestCountFor(String colorName and String[] Array of Subsets")
    public void test() {
        var sut = new CubeCalculator();
        String[] inputArray = new String[]{"3 red, 4 blue", "11 blue, 12 red", "2 green, 1 red"};
        int expected = 12;
        int actual = sut.findHighestCountFor("red", inputArray);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("calculateline().")
    public void test2() {

        var sut = new CubeCalculator();

        int expected = 132;


        try {
            int actual = sut.calculateLine("Game 100: 10 red; 11 blue, 12 red; 1 green, 7 blue, 6 red", 2);
            Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
        } catch (Exception e) {

        }
    }
}