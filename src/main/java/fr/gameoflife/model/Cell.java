package fr.gameoflife.model;

public class Cell {
    private boolean alive;
    private int x;
    private int y;

    public Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
