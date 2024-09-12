package com.example.simonadvent.Day3;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.simonadvent.Utils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Filter {



    public int returnFinalNumber(String lineTop, String line, String lineUnder) {
        List<NumberLocation> allNumbersInLine = extractNumbersWithLocations(line);     // Liste des DatenTyps Number+Location der Number speichert für line alle nummern und location
        if(!lineTop.equals("0")) { // Exception Handling aber manuell
            allNumbersInLine = this.setCountable(allNumbersInLine, lineTop);     //setCountableRegardingTop, topline prüfen
        }
        allNumbersInLine = this.setCountable(allNumbersInLine, line);   //steCountableRegardingLine

        if(!lineUnder.equals("0")) {
            allNumbersInLine = this.setCountable(allNumbersInLine, lineUnder);     //setCountable Regarding Under
        }

        //alle nummern in allnumbersinline countabletrue/false setzen und dann alle zusammenaddieren die true
        /*for (NumberLocation nl : allNumbersInLine) {
            System.out.println("Number:     " + nl.getNumber() + ", Location:   " + nl.getLocation() + ", Countable:    " + nl.getCountable());

        }*/
        int returnvalue = 0;
        /*for(NumberLocation nl : allNumbersInLine) {
            if(nl.getCountable().equals(true)){
            returnvalue = returnvalue + Integer.parseInt(nl.getNumber());
            }
        }*/
        for(int i = 0; i < allNumbersInLine.size(); i++) {
            System.out.println("Number: " + allNumbersInLine.get(i).getNumber() + ", Location: " + allNumbersInLine.get(i).getLocation() + ", Countable: " + allNumbersInLine.get(i).getCountable());
            if(allNumbersInLine.get(i).getCountable()) {
                //System.out.println("Für diese Nummer wird gezählt" + allNumbersInLine.get(i).getNumber());
                returnvalue += Integer.parseInt(allNumbersInLine.get(i).getNumber());
            }
        }


        return returnvalue;
    }



    public List<NumberLocation> setCountable(List<NumberLocation> allNumbersInLine, String line) {// wieder private!!!!
       /* int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        var neueliste = allNumbersInLine.stream().;*/
        for(int i = 0; i < allNumbersInLine.size(); i++) {
            int temp = 0;
            int lengthOfCurrentNumber = allNumbersInLine.get(i).getNumber().length();
            int indexOfLastNumber = allNumbersInLine.get(i).getLocation() + lengthOfCurrentNumber;
            int lastPositionOfNumberOrCharacterAfter = 0;
            if (indexOfLastNumber == line.length()) {
                lastPositionOfNumberOrCharacterAfter = indexOfLastNumber;
            } else {
                lastPositionOfNumberOrCharacterAfter = indexOfLastNumber + 1;

            }
            if(allNumbersInLine.get(i).getLocation()==0){
                temp = 0;
            }
            /*else if(allNumbersInLine.get(i).getLocation()==line.length()){

            }*/
            else {
                temp = allNumbersInLine.get(i).getLocation() - 1;} //-1 damit er bei 1 vor start des ints beginnt zu scannen
            while (temp < lastPositionOfNumberOrCharacterAfter) {             //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Testklassen funktionieren mit +1, ohne nicht, ganzes Programm genau umgekehrt
                /*if(temp>=0 && isSymbol(line.charAt(temp)) == true && temp <= line.length()) {
                allNumbersInLine.get(i).setCountableTrue();
                }
                temp++;*/
                    if (isSymbol(line.charAt(temp)) == true) {
                        allNumbersInLine.get(i).setCountableTrue();
                    }
                    temp++;
                }
            }

        return allNumbersInLine;
    }

    private boolean isSymbol(char char1) {
        if(char1 == '*' | char1 == '&' | char1 == '/' | char1 == '#' | char1 == '@' | char1 == '+' | char1 == '%' | char1 == '$' | char1 == '=') {
            return true;
        }
        else{
            return false;
        }
    }

    public List<NumberLocation> extractNumbersWithLocations(String str) {
            /*List<NumberLocation> numbersWithLocations = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                int location = matcher.start();
                String number = matcher.group();
                NumberLocation numberLocation = new NumberLocation(location, number);
                numbersWithLocations.add(numberLocation);
            }
            return numbersWithLocations;*/
        StringBuilder sb = new StringBuilder();
        List<NumberLocation> resultsForLine = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int location = i;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    i++;
                }


                resultsForLine.add(new NumberLocation(location, str.substring(location, i)));

            } else{
                i++;
            }

        }
        return resultsForLine;
    }

    /*public List<NumberLocation> setListCountable(List<NumberLocation> resultsForLine){
        for(int i = 0; i < resultsForLine.size(); i++){

        }
    }*/

}

