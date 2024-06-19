package fr.gameoflife;

import fr.gameoflife.controller.Controller;
import fr.gameoflife.model.GameProcessor;
import fr.gameoflife.view.JfxView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int width =  1024;
        int height = 1024;
        int pixelSize = 10;

        GameProcessor processor = new GameProcessor();
        Controller controller = new Controller(processor);

        JFrame frame = new JFrame("Pixel Grid");
        JfxView panel = new JfxView(width, height, pixelSize, controller);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}