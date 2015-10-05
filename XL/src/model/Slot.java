package model;

import model.expr.Expr;
import model.expr.Environment;

public interface Slot {
	
	void setExpr(Expr expr);
	
	Expr getExpr();
	
	double value(Environment env);
	
	String address();
}
