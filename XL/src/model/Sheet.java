package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import model.expr.Environment;
import util.XLException;

public class Sheet extends Observable implements Environment{
	private Map<String, Slot> sheet;
	
	public Sheet(){
		sheet = new HashMap<String, Slot>();
	}
	
	public void save(String fileName) throws FileNotFoundException{
		XLPrintStream printer = new XLPrintStream(fileName);
		printer.save(sheet.entrySet());
	}
	
	public void load(String fileName) throws FileNotFoundException{
		clearAll();
		XLBufferedReader reader = new XLBufferedReader(fileName);
        reader.load(sheet);
        setChanged();
        notifyObservers();
	}
	
	public void put(String address, Slot slot){
		checkOverflow(address, slot);
		sheet.put(address, slot);
		setChanged();
		notifyObservers();
	}
	
	private void checkOverflow(String address, Slot slot){
		Slot oldSlot = sheet.get(address);
		CircularSlot cSlot = new CircularSlot("Detta bör aldrig någonsin synas");
		sheet.put(address, cSlot);
		try{
			slot.value(this);
		} finally {
			sheet.put(address, oldSlot);
		}
	}
	
	public void remove(String address){
		sheet.remove(address);
		setChanged();
		notifyObservers();
	}
	
	public String getSlotValue(String address){
		Slot s = sheet.get(address);
		if(s == null){
			return "                    ";
		} else if (s instanceof CommentSlot){
			return ((CommentSlot) s).getCommentValue();
		}
		
		return String.valueOf(sheet.get(address).value(this));
	}
	
	public String getSlotString(String address){
		Slot s = sheet.get(address);
		if(s == null){
			return "";
		}
		return sheet.get(address).toString();
	}
	
	@Override
	public double value(String address) {
		Slot s = sheet.get(address);
		if(s == null){
			throw new XLException("Empty Slot " + address);
		}
		return s.value(this);
	}
	
	public void clearAll(){
		sheet = new HashMap<String, Slot>();
		setChanged();
		notifyObservers();
	}

}
