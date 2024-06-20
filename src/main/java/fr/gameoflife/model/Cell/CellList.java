package fr.gameoflife.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellList {
    private List<Cell> CellList = new ArrayList<>();

    public CellList() {
        //DEBUG should turn
        Cell c1 = new Cell(10,10,true);
        this.CellList.add(c1);
        Cell c2 = new Cell(9,10,true);
        this.CellList.add(c2);
        Cell c3 = new Cell(8,10,true);
        this.CellList.add(c3);

        //should stay alive
//        Cell c1 = new Cell(10,10,true);
//        this.CellList.add(c1);
//        Cell c2 = new Cell(9,10,true);
//        this.CellList.add(c2);
//        Cell c3 = new Cell(10,11,true);
//        this.CellList.add(c3);
//        Cell c4 = new Cell(9,11,true);
//        this.CellList.add(c4);
    }

    public CellList(CellList list) {
        this.CellList = new ArrayList<>();
        for (Cell cell : list.getCellList()) {
            this.CellList.add(new Cell(cell.getX(), cell.getY(), true));
        }
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

    public boolean contains(Cell c) {
        return this.CellList.contains(c);
    }
}
