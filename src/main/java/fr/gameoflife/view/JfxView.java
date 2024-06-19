package fr.gameoflife.view;

import fr.gameoflife.controller.Controller;
import fr.gameoflife.model.Cell.Cell;
import fr.gameoflife.model.Cell.CellList;

import javax.swing.*;
import java.awt.*;

public class JfxView extends JPanel {
    private final int width;
    private final int height;
    private final int pixelSize;
    private Controller ctrl = null;

    public JfxView(Controller newCtrl) {
        ctrl = newCtrl;
        this.width = ctrl.getWidthCtrl();
        this.height = ctrl.getHeightCtrl();
        this.pixelSize = ctrl.getPixelSizeCtrl();
        setPreferredSize(new Dimension(width , height ));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Cell c : ctrl.getPixels().getCellList()) {
            g.setColor(Color.BLACK);
            g.fillRect(c.getX() * pixelSize, c.getY() * pixelSize, pixelSize, pixelSize);
        }
    }

}
