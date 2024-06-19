package fr.gameoflife.controller;

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
}
