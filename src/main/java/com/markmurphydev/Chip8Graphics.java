package com.markmurphydev;

import javax.swing.*;
import java.awt.*;

public class Chip8Graphics {
    public static final int PIXELS_PER_ROW = 0x40;
    public static final int ROWS = 0x20;
    public static final int PIXEL_LENGTH = 20;

    public static final Dimension SCREEN_DIMENSIONS = new Dimension(
            PIXEL_LENGTH * PIXELS_PER_ROW, PIXEL_LENGTH * ROWS
    );

    static class GraphicsFrame extends JFrame {
        public GraphicsFrame(Console console) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);

            setLayout(new BorderLayout());
            add(new GraphicsPane(console), BorderLayout.CENTER);
            pack();
            setLocationRelativeTo(null);
        }
    }

    static class GraphicsPane extends JComponent {

        Console console;

        public GraphicsPane(Console console) {
            this.console = console;
            setPreferredSize(SCREEN_DIMENSIONS);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.fillRect(0, 0, 20, 20);
        }
    }

    public Chip8Graphics(Console console) {
        GraphicsFrame frame = new GraphicsFrame(console);
        frame.setVisible(true);
    }
}
