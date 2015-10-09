package model;

import model.expr.Environment;

public interface Slot {
	
	public double value(Environment env);
	
	public String address();
	
	public String toString();
}
