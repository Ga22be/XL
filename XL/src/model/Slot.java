package model;

import model.expr.Environment;

public interface Slot {
	
	double value(Environment env);
	
	String address();
}
