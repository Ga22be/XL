package model;

import model.expr.Expr;
import model.expr.Environment;

public class CommentSlot implements Slot {

	private Comment comment;
	private String address;
	
	@Override
	public void setExpr(Expr expr) {
		// TODO Auto-generated method stub

	}

	@Override
	public Expr getExpr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String address() {
		// TODO Auto-generated method stub
		return null;
	}

}
