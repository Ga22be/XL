package model;

import model.expr.Expr;

public interface Slot {
	
	void setExpr(Expr expr);
	
	void getExpr(Expr expr);
	
	double value();
	
	String address();
}
