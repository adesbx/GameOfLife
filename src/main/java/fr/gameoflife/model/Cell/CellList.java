package fr.gameoflife.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellList {
    private List<Cell> CellList = new ArrayList<>();

    public CellList() {
        //DEBUG
        Cell c1 = new Cell(10,10,true);
        this.CellList.add(c1);
        Cell c2 = new Cell(15,10,true);
        this.CellList.add(c2);
        Cell c3 = new Cell(10,15,true);
        this.CellList.add(c3);
    }

    public CellList(CellList list) {
        this.CellList = list.getCellList();
    }

    public List<Cell> getCellList() {
        return  this.CellList;
    }

    public void add(Cell c) {
        this.CellList.add(c);
    }

    public void deleteOneCell(Cell c) {
        this.CellList.remove(c);
    }
}
