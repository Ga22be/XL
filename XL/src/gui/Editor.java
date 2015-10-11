package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import model.SlotFactory;
import util.XLException;

public class Editor extends JTextField implements ActionListener, Observer {
	private Sheet sheet;
	private StatusLabel sl;
	private CurrentSlot cs;
	private Handler handler;
	
    public Editor(CurrentSlot cs, StatusLabel sl, Sheet sheet, Handler handler) {
        setBackground(Color.WHITE);
        this.cs = cs;
        this.sl = sl;
        this.sheet = sheet;
        this.handler = handler;
        addActionListener(this);
        handler.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		String address = cs.getAddress();
		setText(sheet.getSlotString(address));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		sl.clear();
		System.out.println("Wrote");
		String address = cs.getAddress();
		if(getText().isEmpty()){
			try {
				sheet.remove(address);
			} catch (XLException exc) {
				sl.setText(exc.getMessage());
			}
		} else {
			try {
				sheet.put(address, SlotFactory.generateSlot(address, getText()));
//				sheet.put(address, SlotFactory.generateSlot(getText(), address));
			} catch (XLException exc) {
				sl.setText(exc.getMessage());
			}
		}
	}
}