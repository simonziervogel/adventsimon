package com.example.simonadvent.Day3;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Filter {
    public int returnFinalNumber(String lineTop, String line, String lineUnder) {
        List<NumberLocation> allNumbersInLine = extractNumbersWithLocations(line);     // Liste des DatenTyps Number+Location der Number speichert für line alle nummern und location
        if(!lineTop.equals("0")) { // Exception Handling aber manuell
            //setCountableRegardingTop, topline prüfen
        }
        //steCountableRegardingLine
        if(!lineUnder.equals("0")) {
            allNumbersInLine = this.setCountable(allNumbersInLine, line);//setCountable Regarding Under
        }

        //alle nummern in allnumbersinline countabletrue/false setzen und dann alle zusammenaddieren die true
        for (NumberLocation nl : allNumbersInLine) {
            System.out.println("Number: " + nl.getNumber() + ", Location: " + nl.getLocation() + ", Countable: " + nl.getCountable());

        }
        return 0;
    }

    private List<NumberLocation> setCountable(List<NumberLocation> allNumbersInLine, String line) {
        for(int i = 0; i < allNumbersInLine.size(); i++) {
            if(i !=0 && isSymbol(line.charAt(allNumbersInLine.get(i).getLocation()-1)) == true) {
                allNumbersInLine.get(i).setCountable();
            }
            else if(i != allNumbersInLine.size()-1 && isSymbol(line.charAt(allNumbersInLine.get(i).getLocation()+1)) == true) {

            }
        }
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

