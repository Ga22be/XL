package model;

import model.expr.Expr;
import model.expr.Environment;

public class ExprSlot implements Slot {
	
	private Expr expr;
	private String address;
	
	public ExprSlot(Expr expr, String address){
		this.expr = expr;
		this.address = address;
	}
	
	@Override
	public void setExpr(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Expr getExpr() {
		return expr;
	}

	@Override
	public double value(Environment env) {
		return expr.value(env);
	}

	@Override
	public String address() {
		return address;
	}

}
