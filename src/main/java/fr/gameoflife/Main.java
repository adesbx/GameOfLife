package fr.gameoflife;

import fr.gameoflife.view.JfxView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int width =  1024;
        int height = 1024;
        int pixelSize = 10;

        JFrame frame = new JFrame("Pixel Grid");
        JfxView panel = new JfxView(width, height, pixelSize);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}