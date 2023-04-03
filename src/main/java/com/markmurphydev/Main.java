package com.markmurphydev;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        try (InputStream romStream = Main.class.getResourceAsStream("/roms/test.ch8")) {
            System.out.println("Hello world!");

            assert romStream != null;
            var rom = romStream.readAllBytes();

            var cpu = new Cpu();
            var memory = new Memory(rom);
            var console = new Console(cpu, memory);

//            var graphics = new Chip8Graphics(console);

            console.step();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}