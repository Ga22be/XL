package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	private CurrentSlot cs;
	private String address;
	private Sheet sheet;
	private StatusLabel sl;
	private Handler handler;

	public SlotLabel(String address, CurrentSlot cs, Sheet sheet, StatusLabel sl, Handler handler) {
		super("                    ", Color.WHITE, RIGHT);
		this.cs = cs;
		this.address = address;
		this.sheet = sheet;
		this.sl = sl;
		this.handler = handler;
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		cs.setWhite();
		setBackground(Color.YELLOW);
		cs.set(this);
		sl.clear();
		handler.notifyObservers();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public String getAddress() {
		return address;
	}

	@Override
	public void update(Observable o, Object arg) {
//		setText(String.valueOf(sheet.getSlot(address).value(sheet)));
		// Vi behöver en metod i sheet som kollar om det som finns på den
		// addressen är en comment eller något annat och returnerar text om
		// comment och ett tal i text annars.
		
		// TODO DISSABLED
		setText(sheet.getSlotValue(address));
	}
}