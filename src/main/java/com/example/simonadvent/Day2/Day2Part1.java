package com.example.simonadvent.Day2;

import com.example.simonadvent.FileReader;
import com.example.simonadvent.Day2.CubeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class Day2Part1 {

    private FileReader fileReader;
    private CubeCalculator cubeCalculator;

    @Autowired
    public void Day2Part1(FileReader fileReader, CubeCalculator cubeCalculator) {
        this.fileReader = fileReader;
        this.cubeCalculator = cubeCalculator;

    }

    public void solve() {
        try {
            List<String> lines = fileReader.readLinesFromResourceFile("2put.txt");
            int part = 1;
            int local = 0;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                System.out.println("Line" + (i + 1) + "=" + line);
                try {
                    local = local + cubeCalculator.calculateLine(line,part);
                } catch (NullLineException e) {
                    System.out.println("Invalid line: " + e.getMessage());
                    continue;

                }
                catch (Exception e) {

                        System.out.println("Invalid  " + e.getMessage());
                        continue;

                }

                System.out.println("Progressive end result:" + local);
            }
        }
            catch(IOException ex){
                System.err.println("Error reading file: " + ex.getMessage());
            }
        }
    }



