package model;

import model.expr.Environment;
import util.XLException;

public class CircularSlot implements Slot {

	private String command;
	
	public CircularSlot (String command){
		this.command = command;
	}

	@Override
	public double value(Environment env) {
		throw new XLException("Circular dependency in input");
	}
	
	@Override
	public String toString(){
		return command;
	}
}
