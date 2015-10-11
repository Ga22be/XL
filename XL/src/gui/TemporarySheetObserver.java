package gui;

import java.util.Observable;
import java.util.Observer;

public class TemporarySheetObserver implements Observer{
	private Handler handler;
	
	public TemporarySheetObserver(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Sheet notified observer");
		handler.notifyObservers();
	}
	
	
}
