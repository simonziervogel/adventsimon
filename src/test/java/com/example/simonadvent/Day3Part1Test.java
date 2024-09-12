package com.example.simonadvent;

import com.example.simonadvent.Day3.Day3Part1;
import com.example.simonadvent.Day3.NumberLocation;
import com.example.simonadvent.Day3.Filter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

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
    @Test
    @DisplayName("returnFinalNumber(String lineTop, String line, String lineUnder) ")
    public void test2() {
        String lineTop =   ".........798...145.........629....579.....455.....................130.............243.................154........167........................";
        String line =      "............*.....*...........*...&...179.*........737...194.........*854........./...........52..560.............................699...&...";
        String lineUnder = "........459..489.817........880.........*..996........................................................................................36....";
        var sut = new Filter();
        int expected = 1033;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }
/*    @Test
    @DisplayName("Test with all lines having numbers at the same spots")
    public void test3() {
        String lineTop = "........123...456...789............";
        String line = "...123...*...456.*.789.........*...";
        String lineUnder = ".......123...456...789...........";
        var sut = new Filter();
        int expected = *//*expected result*//*;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("Test with no numbers in the lines")
    public void test4() {
        String lineTop = "....................................";
        String line = "...........................*.........";
        String lineUnder = "....................................";
        var sut = new Filter();
        int expected = *//*expected result*//*;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("Test with empty lines")
    public void test5() {
        String lineTop = "";
        String line = "";
        String lineUnder = "";
        var sut = new Filter();
        int expected = *//*expected result*//*;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("Test with lines of different lengths")
    public void test6() {
        String lineTop = "........123...456.";
        String line = "...123...*...456.*......789.........*...";
        String lineUnder = ".......123...456...";
        var sut = new Filter();
        int expected = *//*expected result*//*;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }

    @Test
    @DisplayName("Test with null lines")
    public void test7() {
        String lineTop = null;
        String line = null;
        String lineUnder = null;
        var sut = new Filter();
        int expected = *//*expected result*//*;
        int actual = sut.returnFinalNumber(lineTop, line, lineUnder);
        System.out.println("actual: " + actual);
        Assertions.assertEquals(expected, actual, "Expected and Actual integers do not match");
    }*/

    @Test
    @DisplayName("solve(input)8")
    public void test8(){
        FileReader mockFilereader = mock(FileReader.class);
        Filter filter = new Filter();
        var sut = new Day3Part1(mockFilereader, filter);
        List<String> lines = new ArrayList<>();
        lines.add("467..114..");
        lines.add("...*......");
        lines.add("..35..633.");
        lines.add("......#...");
        lines.add("617*......");
        lines.add(".....+.58.");
        lines.add("..592.....");
        lines.add("......755.");
        lines.add("...$.*....");
        lines.add(".664.598..");

        int expected = 4361;
        int actual = sut.solve(lines);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("solve(input)9")
    public void test9(){
        FileReader mockFilereader = mock(FileReader.class);
        Filter filter = new Filter();
        var sut = new Day3Part1(mockFilereader, filter);
        List<String> lines = new ArrayList<>();
        lines.add("467+...9..");


        int expected = 467;
        int actual = sut.solve(lines);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("solve(input) 10")
    public void test10(){
        FileReader mockFilereader = mock(FileReader.class);
        Filter filter = new Filter();
        var sut = new Day3Part1(mockFilereader, filter);
        List<String> lines = new ArrayList<>();

        lines.add(".617+...0.");
        lines.add("..........");
        lines.add(".....+.58.");
        lines.add("..592.....");
        lines.add("......755.");
        lines.add("...$.*....");
        lines.add(".664.598..");

        int expected = 3226;
        int actual = sut.solve(lines);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("solve(input) 10")
    public void test11(){
        FileReader mockFilereader = mock(FileReader.class);
        Filter filter = new Filter();
        var sut = new Day3Part1(mockFilereader, filter);
        List<String> lines = new ArrayList<>();

        lines.add(".........798...145.........629....579.....455.....................130.............243.................154........167........................");
        lines.add("............*.....*...........*...&...179.*........737...194.........*854........./...........52..560*............................699...&...");
        /*lines.add("");
        lines.add("");*/


        int expected = 4547;
        int actual = sut.solve(lines);
        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("solve(input) 10")
    public void test12(){
        FileReader mockFilereader = mock(FileReader.class);
        Filter filter = new Filter();
        var sut = new Day3Part1(mockFilereader, filter);
        List<String> lines = new ArrayList<>();

        lines.add(".........798...145.........629....579.....455.....................130.............243.................154........167........................");
        lines.add("............*.....*...........*...&...179.*........737...194.........*854........./...........52..560*............................699...&...");
        lines.add("........459..489.817........880.........*..996........*....*........................................................................*.36....");
        lines.add("...........@.........................813............234.552..307....184............370..................736.....960..............631........");


        int expected = 12263;
        int actual = sut.solve(lines);
        assertEquals(expected, actual);

    }
}
