package model;

import model.expr.Environment;

public class CircularSlot implements Slot {

	private String command;
	private String address;
	
	public CircularSlot (String command, String address){
		this.command = command;
		this.address = address;
	}

	@Override
	public double value(Environment env) {
		throw new IllegalArgumentException("Circular dependency in input");
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
