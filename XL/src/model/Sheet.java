package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import model.expr.Environment;
import model.expr.Expr;

public class Sheet extends Observable implements Environment{
	private Map<String, Slot> sheet;
	
	public Sheet(){
		sheet = new HashMap<String, Slot>();
	}
	
	public void save(String fileName) throws FileNotFoundException{
		XLPrintStream printer = new XLPrintStream(fileName);
	}
	
	public void load(String fileName) throws FileNotFoundException{
		XLBufferedReader reader = new XLBufferedReader(fileName);
//		reader.load(sheet);
	}
	
	public void put(String address, Slot slot){
		sheet.put(address, slot);
	}
	
	public void replace(String address, Slot slot){
		sheet.replace(address, slot);
	}
	
	public void remove(String address){
		sheet.remove(address);
		
	}
	
	public Slot getSlot(String address){
		return sheet.get(address);
	}
	
	@Override
	public double value(String address) {
		return sheet.get(address).value(this);
	}

}
