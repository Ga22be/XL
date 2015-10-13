package gui;

import java.util.Observable;
import java.util.Observer;

public class Handler extends Observable implements Observer{
	
	@Override
	public void notifyObservers(){
		setChanged();
		super.notifyObservers();
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyObservers();
	}

}
