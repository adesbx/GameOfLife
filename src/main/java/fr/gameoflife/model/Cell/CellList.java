package fr.gameoflife.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellList {
    private final List<Cell> CellList = new ArrayList<>();

    public CellList() {
        //DEBUG
        Cell c1 = new Cell(10,10,true);
        CellList.add(c1);
        Cell c2 = new Cell(15,10,true);
        CellList.add(c2);
        Cell c3 = new Cell(10,15,true);
        CellList.add(c3);
    }

    public List<Cell> getCellList() {
        return CellList;
    }
}
