package com.example.simonadvent.Day3;
import com.example.simonadvent.FileReader;
import com.example.simonadvent.Day2.CubeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class Day3Part1 {

    private FileReader fileReader;
    private Filter filter;

    @Autowired
    public Day3Part1(FileReader fileReader, Filter filter) {
        this.fileReader = fileReader;
        this.filter = filter;
    }
    public void solve() throws IOException {

        int solvevariable =0;

        try{
            List<String> lines = fileReader.readLinesFromResourceFile("test.txt");
            String lineTop;
            String lineUnder;
            for (int i = 0; i < lines.size(); i++) {
                if(i == 0){
                    lineTop = "0"; // top line does not exist for first line
                } else {
                    lineTop = lines.get(i - 1);
                }

                String line = lines.get(i);

                if (i == lines.size() - 1) {
                    lineUnder = "0"; // next line does not exist for last line
                } else {
                    lineUnder = lines.get(i + 1);
                }
                System.out.println("Line" + (i + 1) + "=" + line);

                solvevariable = solvevariable + filter.returnFinalNumber(lineTop, line, lineUnder);
            }
        }
        catch (IOException ex){
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }
}
