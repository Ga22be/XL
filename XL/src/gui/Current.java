package gui;

import java.util.Observable;
import model.Slot;

public class Current extends Observable{
	private String address;
	private Slot currentSlot;
	
	
	public void setAddress(String address) {
		this.address = address;
		setChanged();
		notifyObservers(address);
	}
	
	public void setExpr(String command){
		
	}
	
	public String getAddress(){
		return address;
	}
}
