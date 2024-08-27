package com.example.simonadvent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ZahlenzieherTest {

    @Test
    @DisplayName("simpleExtract(): aus String 12 erste und letzte Zahl ziehen und zusammensetzen")
    public void test() {
        Utils mockUtils = mock(Utils.class);
        var sut = new Zahlenzieher(mockUtils);

        // setup for the mock here, for example:
        when(mockUtils.giveFirstDigit("12".toCharArray())).thenReturn('1');
        when(mockUtils.giveFirstDigit("21".toCharArray())).thenReturn('2');
        when(mockUtils.reverse("12".toCharArray())).thenReturn("21".toCharArray());


        var expected = 12;
        int actualNumber = sut.simpleExtractFirstAndLastNumbers("12");

        Assertions.assertEquals(expected, actualNumber, "Expected and Actual numbers do not match");
    }

  /* @Test
    @DisplayName("advanceExtract(): dem String ha34ll66o werden die erste Zahl 3 und die letzte 6 entnommen und als 36 zurückgegeben")
    public void test4(){
        Utils mockUtils = mock(Utils.class);
        var sut = new Zahlenzieher(mockUtils);


        when(mockUtils.reverse(any(String.class))).thenCallRealMethod();
       when(mockUtils.reverse(any(char[].class))).thenCallRealMethod();
       when(mockUtils.getNumberForSearchterm(anyInt())).thenCallRealMethod();
       when(mockUtils.isFirst(any(), any(), anyInt())).thenCallRealMethod();
        var expected = 36;
        int actualNumber = sut.advanceExtract("ha34ll66o");
        Assertions.assertEquals(expected, actualNumber, "Expected and Actual numbers do not match");

    }

    @Test
    @DisplayName("advanceExtract(): dem String hathree4ll6sixo werden die erste Zahl 3 und die letzte 6 entnommen und als 36 zurückgegeben")
    public void test4_1(){
        Utils mockUtils = mock(Utils.class);
        var sut = new Zahlenzieher(mockUtils);


        when(mockUtils.reverse(any(String.class))).thenCallRealMethod();
        when(mockUtils.reverse(any(char[].class))).thenCallRealMethod();
        when(mockUtils.getNumberForSearchterm(anyInt())).thenCallRealMethod();
        when(mockUtils.isFirst(any(), any(), anyInt())).thenCallRealMethod();
        var expected = 36;
        int actualNumber = sut.advanceExtract("hathree4ll6sixo");
        Assertions.assertEquals(expected, actualNumber, "Expected and Actual numbers do not match");

    }
    @Test
    @DisplayName("advanceExtract(): eine Int")
    public void test4_2(){
        Utils mockUtils = mock(Utils.class);
        var sut = new Zahlenzieher(mockUtils);


        when(mockUtils.reverse(any(String.class))).thenCallRealMethod();
        when(mockUtils.reverse(any(char[].class))).thenCallRealMethod();
        when(mockUtils.getNumberForSearchterm(anyInt())).thenCallRealMethod();
        when(mockUtils.isFirst(any(), any(), anyInt())).thenCallRealMethod();
        var expected = 33;
        int actualNumber = sut.advanceExtract("3");
        Assertions.assertEquals(expected, actualNumber, "Expected and Actual numbers do not match");

    }

    */

    @ParameterizedTest
    @CsvSource({"hathree4ll6sixo, 36", "ha34ll66o, 36", "rrrrrninetwoffffour33six7, 97" })
    @DisplayName("parameterized advanceExtract()")
    public void test4_3(String input, int expected) {
        Utils mockUtils = mock(Utils.class);
        var sut = new Zahlenzieher(mockUtils);


        when(mockUtils.reverse(any(String.class))).thenCallRealMethod();
        when(mockUtils.reverse(any(char[].class))).thenCallRealMethod();
        when(mockUtils.getNumberForSearchterm(anyInt())).thenCallRealMethod();
        when(mockUtils.isFirst(any(), any(), anyInt())).thenCallRealMethod();

        int actualNumber = sut.advanceExtract(input);

        Assertions.assertEquals(expected, actualNumber, "Expected and Actual numbers do not match");
    }
}