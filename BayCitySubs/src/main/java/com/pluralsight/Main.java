package com.pluralsight;

import com.pluralsight.ui.AnimationHomeStart;
import com.pluralsight.ui.HomeScreen;

public class Main {
    public static void main(String[] args) {

        AnimationHomeStart.play();
        HomeScreen home = new HomeScreen();
        home.display();

    }
}