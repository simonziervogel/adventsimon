package com.example.simonadvent;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;

import static org.springframework.aot.hint.TypeReference.listOf;

@Component
public class Zahlenzieher {

    public int extractFirstAndLastNumbers(String str) {
        OptionalInt firstNumber = str.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> Character.toString((char) c))
                .mapToInt(Integer::parseInt)
                .findFirst();

        OptionalInt lastNumber = str.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> Character.toString((char) c))
                .mapToInt(Integer::parseInt)
                .reduce((first, second) -> second);

        //System.out.println("First number: " + (firstNumber.isPresent() ? firstNumber.getAsInt() : "none"));
        //System.out.println("Last number: " + (lastNumber.isPresent() ? lastNumber.getAsInt() : "none"));


        if (firstNumber.isPresent() && lastNumber.isPresent()) {
            return firstNumber.getAsInt() * 10 + lastNumber.getAsInt();
        } else
            return 0;
    }

    public Integer simpleExtractFirstAndLastNumbers(String str) {
        char first;
        char last;
        String lineresult;
        char[] arr = str.toCharArray();
        // Schritt 1: prüfe ob str eine Zahl enthält
        if (str.length() > 0 && arrayContainsDigit(arr) == true) {
            first = this.giveFirstDigit(arr);
            last = this.giveLastDigit(arr);
            //return first * 10 + last;
            StringBuilder sb = new StringBuilder();
            sb.append(first);
            sb.append(last);
            lineresult = sb.toString();
            return Integer.valueOf(lineresult);
        } else {
            return 0;
        }
    }

    private char giveLastDigit(char[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Character.isDigit(arr[i])) {
                return arr[i];
            }
        }
        return '0'; //nur um Fehlermeldung zu beheben, Fall sollte nicht eintreffen, da Zahl vorhanden schon getestet
    }

    private char giveFirstDigit(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                return arr[i];
            }
        }
        return '0'; //nur um Fehlermeldung zu beheben, Fall sollte nicht eintreffen, da Zahl vorhanden schon getestet und Methode vorher gestoppt
    }
    // Schritt 1.1: wenn nicht gebe 0 zurück (optional gebe nicht 0 zurück, sondern werfe eine Exception)


    // Schritt 1.2: wenn doch extrahiere erste und zweite zahl
    // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für erste Zahl
    // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für letzte Zahl Array/Liste umdrehen

    // Schritt 2: Füge die einzelnen Character/Strings zu einem String zusammen


    private boolean arrayContainsDigit(char[] arrtemp) {
        for (int i = 0; i < arrtemp.length; i++) {
            if (Character.isDigit(arrtemp[i])) {
                return true;
            }
        }
        return false;
    }
    public int advanceExtract(String str){
        int first;
        int last;
        String reverse ="";
        String lineresult;

        first = this.standardAdvanceExtract(str);  //returns int/number string which comes first in str

       /*StringBuilder sb = new StringBuilder();
        reverse = sb.reverse().toString();*/

        for (int i = 0; i < str.length(); i++) {
            reverse = str.charAt(i) + reverse;
        }
        System.out.println("Das ist der reversed String:" + reverse);
        last =standardAdvanceExtractReverse(reverse);

        StringBuilder sb2  = new StringBuilder();
        sb2.append(first);
        sb2.append(last);
        lineresult = sb2.toString();
        return Integer.valueOf(lineresult);

    }
    public int standardAdvanceExtract(String str) {
        int temp = 100;
        int candidate= 0;
        char first;

        System.out.println("Für diesen String wird berechnet:" + str);


        /*var map = new HashMap<String, Integer>();

        map.put("1", str.indexOf("1") == -1 ? Integer.MAX_VALUE : str.indexOf("1"));
        var occurence2 = str.indexOf("2") == -1 ? Integer.MAX_VALUE : str.indexOf("2");
        var occurence3 = str.indexOf("3");
        var occurenceNine = str.indexOf("nine");

        var minimum = Collections.min(map.values());

        var minimum = Math.min */

        if (str.contains("1") && str.indexOf("1") < temp) {
            temp = str.indexOf("1");
            candidate = 1;
        }
        if (str.contains("2") && str.indexOf("2") < temp) {
            temp = str.indexOf("2");
            candidate = 2;
        }
        if (str.contains("3") && str.indexOf("3") < temp) {
            temp = str.indexOf("3");
            candidate = 3;
        }
        if (str.contains("4") && str.indexOf("4") < temp) {
            temp = str.indexOf("4");
            candidate = 4;
        }
        if (str.contains("5") && str.indexOf("5") < temp) {
            temp = str.indexOf("5");
            candidate = 5;
        }
        if (str.contains("6") && str.indexOf("6") < temp) {
            temp = str.indexOf("6");
            candidate = 6;
        }
        if (str.contains("7") && str.indexOf("7") < temp) {
            temp = str.indexOf("7");
            candidate = 7;
        }
        if (str.contains("8") && str.indexOf("8") < temp) {
            temp = str.indexOf("8");
            candidate = 8;
        }
        if (str.contains("9") && str.indexOf("9") < temp) {
            temp = str.indexOf("9");
            candidate = 9;
        }

        if (str.contains("one") && str.indexOf("one") < temp) {
            temp = str.indexOf("one");
            candidate = 1;
        }
        if (str.contains("two") && str.indexOf("two") < temp) {
            temp = str.indexOf("two");
            candidate = 2;
        }
        if (str.contains("three") && str.indexOf("three") < temp) {
            temp = str.indexOf("three");
            candidate = 3;
        }
        if (str.contains("four") && str.indexOf("four") < temp) {
            temp = str.indexOf("four");
            candidate = 4;
        }
        if (str.contains("five") && str.indexOf("five") < temp) {
            temp = str.indexOf("five");
            candidate = 5;
        }
        if (str.contains("six") && str.indexOf("six") < temp) {
            temp = str.indexOf("six");
            candidate = 6;
        }
        if (str.contains("seven") && str.indexOf("seven") < temp) {
            temp = str.indexOf("seven");
            candidate = 7;
        }
        if (str.contains("eight") && str.indexOf("eight") < temp) {
            temp = str.indexOf("eight");
            candidate = 8;
        }
        if (str.contains("nine") && str.indexOf("nine") < temp) {
            temp = str.indexOf("nine");
            candidate = 9;
        }

        //temp ist jetzt die Stelle im String, an der die erste Ziffer/Ziffer in String auftaucht
        //candidate gibt mir die ziffer/ziffer ausgeschrieben, beides jeweils als String ("9" oder "nine"), die als erstes in der line kommt
        //char charAtTemp = str.charAt(temp);
        System.out.println("number found by standardadvanceextract:       "+ candidate);
        return candidate;
    }

    public int standardAdvanceExtractReverse(String str) {
        int temp = 100;
        int candidate= 0;
        char first;

        System.out.println("Für diesen String wird berechnet:" + str);


        /*var map = new HashMap<String, Integer>();

        map.put("1", str.indexOf("1") == -1 ? Integer.MAX_VALUE : str.indexOf("1"));
        var occurence2 = str.indexOf("2") == -1 ? Integer.MAX_VALUE : str.indexOf("2");
        var occurence3 = str.indexOf("3");
        var occurenceNine = str.indexOf("nine");

        var minimum = Collections.min(map.values());

        var minimum = Math.min */

        if (str.contains("1") && str.indexOf("1") < temp) {
            temp = str.indexOf("1");
            candidate = 1;
        }
        if (str.contains("2") && str.indexOf("2") < temp) {
            temp = str.indexOf("2");
            candidate = 2;
        }
        if (str.contains("3") && str.indexOf("3") < temp) {
            temp = str.indexOf("3");
            candidate = 3;
        }
        if (str.contains("4") && str.indexOf("4") < temp) {
            temp = str.indexOf("4");
            candidate = 4;
        }
        if (str.contains("5") && str.indexOf("5") < temp) {
            temp = str.indexOf("5");
            candidate = 5;
        }
        if (str.contains("6") && str.indexOf("6") < temp) {
            temp = str.indexOf("6");
            candidate = 6;
        }
        if (str.contains("7") && str.indexOf("7") < temp) {
            temp = str.indexOf("7");
            candidate = 7;
        }
        if (str.contains("8") && str.indexOf("8") < temp) {
            temp = str.indexOf("8");
            candidate = 8;
        }
        if (str.contains("9") && str.indexOf("9") < temp) {
            temp = str.indexOf("9");
            candidate = 9;
        }

        if (str.contains("eno") && str.indexOf("eno") < temp) {
            temp = str.indexOf("eno");
            candidate = 1;
        }
        if (str.contains("owt") && str.indexOf("owt") < temp) {
            temp = str.indexOf("owt");
            candidate = 2;
        }
        if (str.contains("eerht") && str.indexOf("eerht") < temp) {
            temp = str.indexOf("eerht");
            candidate = 3;
        }
        if (str.contains("ruof") && str.indexOf("ruof") < temp) {
            temp = str.indexOf("ruof");
            candidate = 4;
        }
        if (str.contains("evif") && str.indexOf("evif") < temp) {
            temp = str.indexOf("evif");
            candidate = 5;
        }
        if (str.contains("xis") && str.indexOf("xis") < temp) {
            temp = str.indexOf("xis");
            candidate = 6;
        }
        if (str.contains("neves") && str.indexOf("neves") < temp) {
            temp = str.indexOf("neves");
            candidate = 7;
        }
        if (str.contains("thgie") && str.indexOf("thgie") < temp) {
            temp = str.indexOf("thgie");
            candidate = 8;
        }
        if (str.contains("enin") && str.indexOf("enin") < temp) {
            temp = str.indexOf("enin");
            candidate = 9;
        }

        //temp ist jetzt die Stelle im String, an der die erste Ziffer/Ziffer in String auftaucht
        //candidate gibt mir die ziffer/ziffer ausgeschrieben, beides jeweils als String ("9" oder "nine"), die als erstes in der line kommt
        //char charAtTemp = str.charAt(temp);
        System.out.println("number found by standardadvanceextractREVERSE:       "+ candidate);
        return candidate;
    }


    /*private boolean containsDigit(String str) {
        char[] arr= str.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if (Character.isDigit(arr[i])) {
                return true;
            }
        }
        return false;
    }*/


}