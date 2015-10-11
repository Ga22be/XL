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
		sheet.put(address, slot);
		setChanged();
		notifyObservers();
	}
	
	public void replace(String address, Slot slot){
		sheet.put(address, slot);
		setChanged();
		notifyObservers();	
	}
	
	public void remove(String address){
		sheet.remove(address);
		setChanged();
		notifyObservers();
	}
	
	public String getSlotValue(String address){
		Slot s = getSlot(address);
		if(s == null){
			return "                    ";
		} else if (s instanceof CommentSlot){
			return ((CommentSlot) s).getCommentValue();
		}
		
		return String.valueOf(getSlot(address).value(this));
	}
	
	public String getSlotString(String address){
		Slot s = getSlot(address);
		if(s == null){
			return "";
		}
		return getSlot(address).toString();
	}
	
	public Slot getSlot(String address){
		return sheet.get(address);
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
