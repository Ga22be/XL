package gui;

import java.util.Observable;

public class Handler extends Observable {
	
	@Override
	public void notifyObservers(){
		setChanged();
		super.notifyObservers();
	}

}
