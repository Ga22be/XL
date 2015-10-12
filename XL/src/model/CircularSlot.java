package model;

import model.expr.Environment;
import util.XLException;

public class CircularSlot implements Slot {

	private String address;
	private String command;
	
	public CircularSlot (String address, String command){
		this.address = address;
		this.command = command;
	}

	@Override
	public double value(Environment env) {
		throw new XLException("Circular dependency in input");
	}
	
	@Override
	public String address() {
		return address;
	}
	
	@Override
	public String toString(){
		return command;
	}
}
