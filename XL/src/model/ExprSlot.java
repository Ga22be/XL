package model;

import model.expr.Expr;
import model.expr.Environment;

public class ExprSlot implements Slot {
	
	private String address;
	private Expr expr;
	
	public ExprSlot(String address, Expr expr){
		this.address = address;
		this.expr = expr;
	}
	
	public void setExpr(Expr expr) {
		this.expr = expr;
	}

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
	
	@Override
	public String toString(){
		return expr.toString();
	}

}
