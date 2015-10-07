package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.util.Observable;
import java.util.Observer;

public class StatusPanel extends BorderPanel{
    protected StatusPanel(StatusLabel statusLabel, Current current) {
    	CurrentLabel cl = new CurrentLabel();
    	current.addObserver(cl);
    	current.addObserver(statusLabel);
        add(WEST, cl);
        add(CENTER, statusLabel);
    }
}