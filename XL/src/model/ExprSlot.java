package model;

import model.expr.Expr;
import model.expr.Environment;

public class ExprSlot implements Slot {
	
	private Expr expr;
	
	public ExprSlot(Expr expr){
		this.expr = expr;
	}

	@Override
	public double value(Environment env) {
		return expr.value(env);
	}

	@Override
	public String toString(){
		return expr.toString();
	}

}
