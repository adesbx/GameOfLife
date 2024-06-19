package fr.gameoflife.model;

import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.Cell.CellList;

import java.awt.*;

public class GameProcessor {

    private CellList pixels = null;

    public GameProcessor() {
        this.pixels = new CellList();
    }

    public void computeTick() {
//        for (Cell c : pixels.getCellList()) {
//            g.setColor(Color.BLACK);
//            g.fillRect(c.getX() * pixelSize, c.getY() * pixelSize, pixelSize, pixelSize);
//        }
    }

    public CellList getPixels() {
        return pixels;
    }
}
