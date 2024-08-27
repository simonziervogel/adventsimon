package com.example.simonadvent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    @DisplayName(".reverse(String): should reverse String hallo to String ollah")
    public void test(){
        var sut = new Utils();

        var expected = "ollah";
        String actualString = sut.reverse("hallo");

        Assertions.assertEquals(expected, actualString, "Expected and Actual strings do not match");

    }

    @Test
    @DisplayName(".reverse(char[]): should reverse char[] hallo to char[] ollah")
    public void test1(){
        var sut = new Utils();

        char[] input = new char[]{'h', 'a', 'l', 'l', 'o'};
        char[] actualString = sut.reverse(input);
        char[] expected = new char[]{'o', 'l', 'l', 'a', 'h'};

        Assertions.assertArrayEquals(expected, actualString, "Expected and Actual char arrays do not match");

    }

    @Test
    @DisplayName("isFirst(): is the searchTerm the current first int in the line")
    public void test2()
    {
        var sut = new Utils();
        boolean isFirst = sut.isFirst("1", "12", 1);
        Assertions.assertTrue(isFirst, "Search term is not the first in the line");
    }

    @Test
    @DisplayName("isFirst(): is the searchTerm the current first int in the line")
    public void test2_1()
    {
        var sut = new Utils();
        boolean isFirst = sut.isFirst("2", "12", 1);
        Assertions.assertFalse(isFirst, "Search term is the first in the line");
    }

    @Test
    @DisplayName("getNumbersForSearchterm((<9)): should return int associated with the index parameter")
    public void test3(){
        var sut = new Utils();
        int actual = sut.getNumberForSearchterm(7);
        int expected = 8;
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("getNumbersForSearchterm((>=9)): should return int associated with the index parameter")
    public void test4(){
        var sut = new Utils();
        int actual = sut.getNumberForSearchterm(10);
        int expected = 2;
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("giveFirstDigit() for char[] array parameter")
    public void test5() {
        var sut = new Utils();
        char[] input = new char[]{'h', '3', 'l', 'l', '0'};
        char actualChar = sut.giveFirstDigit(input);
        char expected = '3';
        Assertions.assertEquals(expected, actualChar, "Expected and Actual characters do not match");
    }
}