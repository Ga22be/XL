package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import model.Sheet;
import model.Slot;
import model.SlotFactory;

public class CurrentSlot extends Observable {
	private SlotLabel currentSlotLabel;
	private Handler handler;
	
	public CurrentSlot(Handler handler) {
		this.handler = handler;
	}
	
	public String getAddress(){
		return currentSlotLabel.getAddress();
	}
	
	public void set(SlotLabel slotLabel) {
		currentSlotLabel = slotLabel;
		handler.notifyObservers();
//		handler.addObserver(slotLabel);
	}
	
	public void clear(){
		currentSlotLabel.setText("");
	}
	
	public void setWhite(){
		currentSlotLabel.setBackground(Color.WHITE);
	}
	
}
