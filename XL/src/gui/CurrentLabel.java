package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer{
	private CurrentSlot cs;
	
    public CurrentLabel(CurrentSlot cs, Handler handler) {
        super("  ", Color.WHITE);
        this.cs = cs;
        handler.addObserver(this);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(cs.getAddress());
	}
}