package fr.gameoflife.view;

import fr.gameoflife.controller.Controller;
import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.Cell.CellList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfxView extends JPanel {
    private final int width;
    private final int height;
    private final int pixelSize;
    private Controller ctrl = null;

    private boolean stop = false;

    public JfxView(Controller newCtrl) {
        ctrl = newCtrl;
        this.width = ctrl.getWidthCtrl();
        this.height = ctrl.getHeightCtrl();
        this.pixelSize = ctrl.getPixelSizeCtrl();
        setPreferredSize(new Dimension(width , height ));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell c : ctrl.getPixels().getCellList()) {
            g.setColor(Color.BLACK);
            g.fillRect(c.getX() * pixelSize, c.getY() * pixelSize, pixelSize, pixelSize);
        }
    }

    public void play() throws InterruptedException {
        JPanel p1 = new JPanel();
        JButton button1 = new JButton("Stop");
        //the button do nothing now
        p1.add(button1);
        add(p1);

        while (!stop) {
            Thread.sleep(200);
            ctrl.doATick();
            repaint();
        }
    }

}
