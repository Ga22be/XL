package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlotLabel extends ColoredLabel{
	private String address;
	
	public SlotLabel(String address) {
        super("                    ", Color.WHITE, RIGHT);
        this.address = address;
    }
	
	public String getAddress(){
		return address;
	}
}