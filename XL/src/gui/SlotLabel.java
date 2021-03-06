package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import model.Sheet;
import util.XLException;

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
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

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

	}
	
	public String getAddress() {
		return address;
	}

	@Override
	public void update(Observable o, Object arg) {
		try{
			setText(sheet.getSlotValue(address));			
		} catch (XLException e) {
			sl.setText(e.getMessage());
		}
	}
	
	
}