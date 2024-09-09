package com.example.simonadvent.Day2;


import org.springframework.stereotype.Component;

@Component
public class CubeCalculator {
    public int calculateLine(String line, int part) throws Exception {
        System.out.println("line                    " + line);
        String[] idSeparator = line.split(": ");
        System.out.println("HIER MUSS GAME 1:" + idSeparator[0]);
        int iD = this.getID(idSeparator[0]); //aus part 1 "game 1:" wird die iD = 1 rausgezogen
        System.out.println("HIER MUSS 1:" + idSeparator[1]);

        /*String lineWithoutID = idSeparator[1];
        String[] subsets = lineWithoutID.split(";");*/
        String[] subsets = idSeparator[1].split("; ");   // alles hinter der gameID nach ";" trennen --> daten subsets in String array
        //System.out.println("first subset:              " + subsets[0]);
        //System.out.println("2nd subset:                  " + subsets[1]);

        if(part == 1) {
            for (int i = 0; i < subsets.length; i++) {
                System.out.println(" SUBSET :" + i + "          " + subsets[i]);
                if (this.gameNotPossible(subsets[i])) {//wenn eine der Farben zu oft vorkommt wird hier die if schleife ausgeführt --> 0 wird returned für diese line --> pro result wird nicht verändert und nächste line wird ausgeführt;
                    //System.out.println("DIESES SUBSET KLAPPT NICHT:" + subsets[i]);
                    throw new NullLineException("NullLineException in Subset " + i + " von Line " + iD);
                }
            }
            //System.out.println(subsets);
            return iD;    //hier muss die game id zurückgegeben werden
        }
        else if (part == 2) {
            int tempred = 0;
            int tempgreen = 0;
            int tempblue = 0;

            tempred = this.findHighestCountFor("red", subsets);
            tempgreen = this.findHighestCountFor("green", subsets);
            tempblue = this.findHighestCountFor("blue", subsets);

            return tempred * tempgreen * tempblue;


            }
        else {
            throw new Exception("Invalid GamePart ID");

        }
    }

    public boolean gameNotPossible(String subset) {//returns true wenn ein Game nicht möglich ist, mehr Würfel gezeigt wurden als eig da sind
        String[] lowest = subset.split(", ");
        for(int i = 0; i < lowest.length; i++){
            System.out.println("EINE ZEILE MIT INT UND FARBNAME:" + lowest[i]);
            if (lowest[i].contains("red")) {
                int red = Integer.parseInt(lowest[i].split(" ")[0]);
                if (red > 12) {
                    return true;
                }
            }
            if (lowest[i].contains("green")) {
                int green = Integer.parseInt(lowest[i].split(" ")[0]);
                if (green > 13) {
                    return true;
                }
            }
            if (lowest[i].contains("blue")) {
                int blue = Integer.parseInt(lowest[i].split(" ")[0]);
                if (blue > 14) {
                    return true;
                }
            }
        }


        //int red = this.filterFor("red", subset);
        return false;
    }

    /*public int filterFor(String keyword, String subset){               // diese methode soll mir die anzahl "keyword" farbigen Cubes in einem bestimmten subset ausgeben

    }*/

    public int getID(String input){
        return Integer.parseInt(input.split(" ")[1]);
    }



    /*public int calculatePowerOf(String line) {
        String[] idSeparator = line.split(": ");
        System.out.println("HIER MUSS GAME 1:" + idSeparator[0]);
        int iD = this.getID(idSeparator[0]); //aus part 1 "game 1:" wird die iD = 1 rausgezogen
        System.out.println("HIER MUSS 1:" + idSeparator[1]);


    }*/

    /*public <T> int findHighestCountFor(String color, T[] input){
        String[] lowest = input.split(", ");
    }*/

    public int findHighestCountFor(String color, String[] input) {
        int returnValue = 0;


        for (int i = 0; i < input.length; i++) {

            String[] lowest = input[i].split(", ");


            for (int j = 0; j < lowest.length; j++)
            {
                if (lowest[j].contains(color)) {
                    int numberT = Integer.parseInt(lowest[j].split(" ")[0]);
                    if (numberT > returnValue) {
                        returnValue = numberT;
                    }

                }
            }

        }
        return returnValue;
    }
}