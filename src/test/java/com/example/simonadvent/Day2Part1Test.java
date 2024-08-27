package com.example.simonadvent;

import com.example.simonadvent.Day2.CubeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Day2Part1Test {
    @Test
    @DisplayName("getID()")
    public void test() {
        var sut = new CubeCalculator();
        int expected = 83;
        int actual = sut.getID("Game 83");
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("gameNotPossible(String subset): muss für input '6 blue, 6 red, 2 green' false zurückgeben, da game = possible")
    public void test2() {
        var sut = new CubeCalculator();
        boolean gameNotPossible = sut.gameNotPossible("6 blue, 6 red, 2 green");
        Assertions.assertFalse(gameNotPossible, "Search term is not the first in the line");


    }

    @Test
    @DisplayName("gameNotPossible(String subset): muss für input '6 blue, 6 red, 22 green' true zurückgeben, da game = impossible")
    public void test2_1() {
        var sut = new CubeCalculator();
        boolean gameNotPossible = sut.gameNotPossible("6 blue, 6 red, 22 green");
        Assertions.assertTrue(gameNotPossible, "Search term is not the first in the line");


    }
}