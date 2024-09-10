package com.example.simonadvent;

import org.springframework.stereotype.Component;

@Component
public class Utils {

    public static char giveFirstDigit(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                return arr[i];
            }
        }
        return '0'; //nur um Fehlermeldung zu beheben, Fall sollte nicht eintreffen, da Zahl vorhanden schon getestet und Methode vorher gestoppt
    }

    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static char[] reverse(char[] input) {
        char[ ] reverse = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            reverse[(input.length - 1) - i] = input[i];
        }
        return reverse;
    }

    public static boolean isFirst(String searchTerm, String line, int position) {
        return (line.contains(searchTerm) && line.indexOf(searchTerm) < position);
    }

    public static int getNumberForSearchterm(int indexOfSearchterms) {
        //return indexOfSearchterms < 9 ? indexOfSearchterms + 1 : indexOfSearchterms + 1 - 9;
        return (indexOfSearchterms%9)+1;
    }
}
