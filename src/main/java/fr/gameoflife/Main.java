package fr.gameoflife;

import fr.gameoflife.controller.Controller;
import fr.gameoflife.model.GameProcessor;
import fr.gameoflife.view.JfxView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameProcessor processor = new GameProcessor(1024, 1024, 10);
        Controller controller = new Controller(processor);

        JFrame frame = new JFrame("Pixel Grid");
        JfxView panel = new JfxView(controller);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Thread.sleep(30000);
        controller.doATick();
        panel.repaint();
    }
}