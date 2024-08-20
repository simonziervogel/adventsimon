package com.example.simonadvent;

import org.springframework.stereotype.Component;

import java.util.OptionalInt;

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
        }
        else
            return 0;
    }

    public int simpleExtractFirstAndLastNumbers(String str) {
        char first;
        char last;
        char[] arr = str.toCharArray();
        // Schritt 1: prüfe ob str eine Zahl enthält
        if(str.length()>0 && arrayContainsDigit(arr) == true){
            first = this.giveFirstDigit(arr);
            last = this.giveLastDigit(arr);
            return first * 10 + last;
        }
        else {
            return 0;
        }
    }

    private char giveLastDigit(char[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            if(Character.isDigit(arr[i])){
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


        }
        // Schritt 1.2: wenn doch extrahiere erste und zweite zahl
            // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für erste Zahl
            // Iteriere / Schleife über String Einträge + Prüfung ob Zahl für letzte Zahl Array/Liste umdrehen

        // Schritt 2: Füge die einzelnen Character/Strings zu einem String zusammen



    private boolean arrayContainsDigit(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                return true;
            }
        }
         return fals
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

