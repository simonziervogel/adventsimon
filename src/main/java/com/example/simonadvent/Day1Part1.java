package com.example.simonadvent;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Component
public class Day1Part1 {

    private final FileReader fileReader;
    private final Zahlenzieher zahlenzieher;

    @Autowired
    public Day1Part1(FileReader fileReader, Zahlenzieher zahlenzieher) {
        this.fileReader = fileReader;
        this.zahlenzieher = zahlenzieher;
    }

        public void solve() {
            try {
                List<String> lines = fileReader.readLinesFromResourceFile("test.txt");
                 int local = 0;

                for(int i=0; i<lines.size(); i++) {
                    String line = lines.get(i);
                    System.out.println("Line" + (i+1) + "=" + line);
                    local=local+ zahlenzieher.simpleExtractFirst(line);
                    System.out.println("Progressive end result:" + local);
                }


            } catch(IOException ex) {
                System.err.println("Error reading file: " + ex.getMessage());
            }

        }
    }
