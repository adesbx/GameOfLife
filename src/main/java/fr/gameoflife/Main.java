package fr.gameoflife;

import fr.gameoflife.controller.Controller;
import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.GameProcessor;
import fr.gameoflife.view.JfxView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameProcessor processor = new GameProcessor(512, 512, 10);
        Controller controller = new Controller(processor);

        JFrame frame = new JFrame("Game of life");
        JfxView panel = new JfxView(controller);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true) {
            Thread.sleep(2000);
            controller.doATick();
            panel.repaint();
        }
    }
}