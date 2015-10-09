package model;

import model.expr.Environment;
import model.expr.Expr;

public class Comment extends Expr {
	private String comment;
	
	public Comment(String comment){
		this.comment = comment;
	}

	@Override
	public String toString(int prec) {
		return comment;
	}

	@Override
	public double value(Environment env) {
		return 0;
	}

}
