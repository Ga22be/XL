package gui;

import java.util.Observable;

public class Current extends Observable{
	private String address;
	
	public void setAddress(String address) {
		this.address = address;
		setChanged();
		notifyObservers(address);
	}
}
