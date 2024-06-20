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

    private boolean running = true;

    public JfxView(Controller newCtrl) {
        ctrl = newCtrl;
        this.width = ctrl.getWidthCtrl();
        this.height = ctrl.getHeightCtrl();
        this.pixelSize = ctrl.getPixelSizeCtrl();
        setPreferredSize(new Dimension(width , height ));

        JPanel p1 = new JPanel();
        JButton button1 = new JButton("Stop");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    running = false;
                    button1.setText("Start");
                } else {
                    synchronized (JfxView.this) {
                        running = true;
                        JfxView.this.notify();
                    }
                    button1.setText("Stop");
                }
            }
        });
        p1.add(button1);
        add(p1);
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
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (JfxView.this) {
                            while (!running) {
                                JfxView.this.wait();
                            }
                        }
                        Thread.sleep(200);
                        ctrl.doATick();
                        repaint();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        gameThread.start();
    }

}
