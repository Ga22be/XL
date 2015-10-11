package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import java.util.Observable;
import java.util.Observer;

public class StatusPanel extends BorderPanel{
    protected StatusPanel(StatusLabel statusLabel, CurrentSlot cs, Handler handler) {
        add(WEST, new CurrentLabel(cs, handler));
        add(CENTER, statusLabel);
    }
}