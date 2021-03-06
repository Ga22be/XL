package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import gui.SlotLabels;
import model.Sheet;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	
    public ClearAllMenuItem(Sheet sheet) {
        super("Clear all");
        addActionListener(this);
        this.sheet = sheet;
    }

    public void actionPerformed(ActionEvent e) {
    	sheet.clearAll();
    }
}