package fr.gameoflife.view;

import fr.gameoflife.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JfxView extends JPanel {
    private final int width;
    private final int height;
    private final int pixelSize;
    private final List<Cell> pixels;

    public JfxView(int width, int height, int pixelSize) {
        this.width = width;
        this.height = height;
        this.pixelSize = pixelSize;
        this.pixels = new ArrayList();
        setPreferredSize(new Dimension(width , height ));

        //DEBUG
        Cell c1 = new Cell(10,10,true);
        pixels.add(c1);
        Cell c2 = new Cell(15,10,true);
        pixels.add(c2);
        Cell c3 = new Cell(10,15,true);
        pixels.add(c3);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell c : pixels) {
            g.setColor(Color.BLACK);
            g.fillRect(c.getX() * pixelSize, c.getY() * pixelSize, pixelSize, pixelSize);
        }
    }

}
