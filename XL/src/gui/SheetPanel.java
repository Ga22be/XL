package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentSlot cs, Handler handler, Sheet sheet, StatusLabel sl) {
    	SlotLabels sls = new SlotLabels(rows, columns, cs, handler, sheet, sl);
        add(WEST, new RowLabels(rows));
        add(CENTER, sls);
    }
}