package com.example.simonadvent;

import com.example.simonadvent.Day1.Day1Part1;
import com.example.simonadvent.Day1.Day1Part2;
import com.example.simonadvent.Day2.Day2Part1;
import com.example.simonadvent.Day2.Day2Part2;
import com.example.simonadvent.Day3.Day3Part1;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplRunner implements ApplicationRunner {

    Day1Part1 day1Part1;
    Day1Part2 day1Part2;
    Day2Part1 day2Part1;
    Day2Part2 day2Part2;
    Day3Part1 day3Part1;

    public ApplRunner(Day1Part1 day1Part1, Day1Part2 day1Part2, Day2Part1 day2Part1, Day2Part2 day2Part2, Day3Part1 day3Part1) {
        this.day1Part1 = day1Part1;
        this.day1Part2 = day1Part2;
        this.day2Part1 = day2Part1;
        this.day2Part2 = day2Part2;
        this.day3Part1 = day3Part1;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello, Rätsel wird gelöst");
        day3Part1.solve();
    }


}
