package edu.metrostate.oodi.brewandbyte.view;

import java.util.List;

public class CounterScreen {
    public void showMenu(List<String> lines) {
        System.out.println("Counter: today's menu");
        for (String line : lines) {
            System.out.println("  " + line);
        }
    }
}
