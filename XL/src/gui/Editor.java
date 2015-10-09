package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import model.SlotFactory;
import model.expr.Environment;

public class Editor extends JTextField implements Observer {
	private Sheet sheet;
	private Current current = new Current();
	
    public Editor(Sheet sheet) {
    	this.sheet = sheet;
        setBackground(Color.WHITE);
    }

	@Override
	public void update(Observable o, Object arg) {
		current.setExpr(getText());
		sheet.put(String.valueOf(arg), SlotFactory.generateSlot(String.valueOf(arg), getText()));
		// TODO Auto-generated method stub
		current = (Current) o;
	}
}