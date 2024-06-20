package fr.gameoflife.controller;

import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.Cell.CellList;
import fr.gameoflife.model.GameProcessor;

public class Controller {
    private GameProcessor processor = null;

    public Controller(final GameProcessor proc) {
        this.processor = proc;
    }

    public CellList getPixels() {
        return processor.getPixels();
    }

    public int getWidthCtrl() {
        return processor.getWidth();
    }

    public int getHeightCtrl() {
        return processor.getHeight();
    }

    public int getPixelSizeCtrl() {
        return processor.getPixelSize();
    }

    public void doATick() {
        processor.computeTick();
    }

    public void addPixels(Cell c){
        processor.getPixels().add(c);
    }

    public void delPixels(Cell c){
        processor.getPixels().deleteOneCell(c);
    }

    public boolean alive(int x, int y) {
        return processor.getPixels().contains(new Cell(x, y, true));
    }
}
