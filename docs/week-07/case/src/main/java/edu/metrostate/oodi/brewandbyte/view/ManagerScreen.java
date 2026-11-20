package edu.metrostate.oodi.brewandbyte.view;

import java.util.List;

public class ManagerScreen {
    public void showMenu(List<String> lines) {
        System.out.println("Manager: the menu");
        for (String line : lines) {
            System.out.println("  " + line);
        }
    }

    public void showMessage(String message) {
        System.out.println("Manager: " + message);
    }
}
