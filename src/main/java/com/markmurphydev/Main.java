package com.markmurphydev;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Console console = new Console();
        Chip8Graphics graphics = new Chip8Graphics(console);
    }
}