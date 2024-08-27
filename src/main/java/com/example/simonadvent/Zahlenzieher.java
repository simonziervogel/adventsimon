package com.example.simonadvent;

import jdk.jshell.execution.Util;
import org.springframework.stereotype.Component;

import java.util.OptionalInt;

@Component
public class Zahlenzieher {

    private Utils utils;

    public Zahlenzieher(Utils utils) {
        this.utils = utils;
    }

    private static final String[] SEARCH_TERMS = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public Integer simpleExtractFirstAndLastNumbers(String str) {
        char first;
        char last;
        char[] arr = str.toCharArray();
        var hasDigit = utils.giveFirstDigit(arr) > 0;
        // Schritt 1: prüfe ob str eine Zahl enthält
        if (!str.isEmpty() && hasDigit) {
            first = utils.giveFirstDigit(arr);
            last = utils.giveFirstDigit(utils.reverse(arr));
            return Integer.parseInt(String.valueOf(first)) * 10 + Integer.parseInt(String.valueOf(last));
        } else {
            return 0;
        }
    }



    // Schritt 1.1: wenn nicht gebe 0 zurück (optional gebe nicht 0 zurück, sondern werfe eine Exception)


    // Schritt 1.2: wenn doch extrahiere erste und zweite zahl
    // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für erste Zahl
    // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für letzte Zahl Array/Liste umdrehen

    // Schritt 2: Füge die einzelnen Character/Strings zu einem String zusammen


    public int advanceExtract(String line){
        int first;
        int last;

        first = this.advanceExtract(line, false);  //returns int/number string which comes first in str
        last = this.advanceExtract(line, true);

        return first * 10 + last;
    }

    private int advanceExtract(String line, boolean reversed) {
        int temp = Integer.MAX_VALUE;
        int candidate= 0;
        String strToCheck = reversed ? utils.reverse(line) : line;
        String[] searchTerms = SEARCH_TERMS;

        System.out.println("Für diesen String wird berechnet:" + strToCheck);

        for (int i = 0; i < searchTerms.length; i++) {
            var searchTerm = reversed ? utils.reverse(searchTerms[i]) : searchTerms[i];
            if (utils.isFirst(searchTerm, strToCheck, temp)) {
                temp = strToCheck.indexOf(searchTerm);              //HIER line anstatt strToCheck, indizes von falscher seite gezählt, deswegen zunächst doch das erste vom straight string
                candidate = utils.getNumberForSearchterm(i);
            }
        }

        //temp ist jetzt die Stelle im String, an der die erste Ziffer/Ziffer in String auftaucht
        //candidate gibt mir die ziffer/ziffer ausgeschrieben, beides jeweils als String ("9" oder "nine"), die als erstes in der line kommt
        //char charAtTemp = str.charAt(temp);
        System.out.println("number found by standardadvanceextract:       "+ candidate);
        return candidate;
    }



}