package com.example.simonadvent;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplRunner implements ApplicationRunner {

    Day1Part1 day1Part1;
    Day1Part2 day1Part2;

    public ApplRunner(Day1Part1 day1Part1, Day1Part2 day1Part2) {
        this.day1Part1 = day1Part1;
        this.day1Part2 = day1Part2;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello, Rätsel wird gelöst");
        day1Part2.solve();
    }


}
