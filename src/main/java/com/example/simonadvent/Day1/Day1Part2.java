package com.example.simonadvent.Day1;


import com.example.simonadvent.FileReader;
import com.example.simonadvent.Zahlenzieher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.io.IOException;


@Component
public class Day1Part2 {

    private final FileReader fileReader;
    private final Zahlenzieher zahlenzieher;

    @Autowired
    public Day1Part2(FileReader fileReader, Zahlenzieher zahlenzieher) {
        this.fileReader = fileReader;
        this.zahlenzieher = zahlenzieher;
        /*String bla = "bsodif";
        bla.indexOf("o");*/
    }

    public void solve(){
        try{
            int temp = 0;
            List<String> lines = fileReader.readLinesFromResourceFile("input.txt");
            for(int i=0; i<lines.size(); i++) {
                String line = lines.get(i);
                System.out.println("Line" + (i+1) + "=" + line);
                temp = temp + zahlenzieher.advanceExtract(line); //MEthode gibt erste und letzte zahl (int oder zahlwort) als 2stelligen int zusammengesetzt vom übergebenen string line aus
                System.out.println("prog end result" + temp);
            }
        }
        catch (IOException ex){
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }
}
