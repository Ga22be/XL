package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements MouseListener{
    private List<SlotLabel> labelList;
    private Current current;
    private SlotLabel lastLabel = new SlotLabel(null);

    public SlotLabels(int rows, int cols, Current current) {
        super(rows + 1, cols);
        this.current = current;
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel(String.valueOf(ch)+row);
                label.addMouseListener(this);
                add(label);
                labelList.add(label);
            }
        }
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		lastLabel.setBackground(Color.WHITE);
		lastLabel = (SlotLabel) e.getSource();
		lastLabel.setBackground(Color.YELLOW);
		setAsCurrent(lastLabel.getAddress());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    public void setAsCurrent(String address){
    	current.setAddress(address);
    }
}
