package fr.gameoflife.model;

import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.Cell.CellList;

import java.awt.*;

public class GameProcessor {
    private final int width;
    private final int height;
    private final int pixelSize;

    private CellList pixels = null;

    public GameProcessor(int w, int h, int size) {
        this.width = w;
        this.height = h;
        this.pixelSize = size;
        this.pixels = new CellList();
    }

    public void computeTick() {
        CellList temp = new CellList(pixels);

        //for the alive cell
        for (Cell c : temp.getCellList()) {
            int numbNeighbor = getNumberOfNeighbor(c.getX(), c.getY());
            if(numbNeighbor != 2 || numbNeighbor != 3) {
                temp.deleteOneCell(c);
            }
        }

        //for new cell
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!isAlive(x, y)) {
                    int numbNeighbor = getNumberOfNeighbor(x, y);
                    if(numbNeighbor == 3) {
                        temp.add(new Cell(x, y, true));
                    }
                }
            }
        }

        pixels = temp;
    }

    public int getNumberOfNeighbor(int x, int y) {
        int compt = 0;
        if(x-1 >= 0 && y+1 <= height && isAlive(x-1, y+1))
            compt++;
        if(x-1 >= 0 && isAlive(x-1, y))
            compt++;
        if(x-1 >= 0 && y-1 >= 0 && isAlive(x-1, y-1))
            compt++;

        if(y-1 >= 0 && isAlive(x, y-1))
            compt++;
        if(y+1 <= height && isAlive(x, y+1))
            compt++;

        if(x+1 <= width && y+1 <= height && isAlive(x+1, y+1))
            compt++;
        if(x+1 <= width && isAlive(x+1, y))
            compt++;
        if(x+1 <= width && y-1 >= 0 && isAlive(x+1, y-1))
            compt++;

        return compt;
    }

    public boolean isAlive(int x, int y) {
        for (Cell c : pixels.getCellList()) {
            if (c.getX() == x && c.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public CellList getPixels() {
        return pixels;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPixelSize() {
        return pixelSize;
    }
}
