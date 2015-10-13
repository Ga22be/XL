package model;

import model.expr.Environment;

public class CommentSlot implements Slot {
	private String comment;
	
	public CommentSlot(String comment) {
		this.comment = comment;
	}
	
	@Override
	public double value(Environment env) {
		return 0;
	}

	@Override
	public String toString(){
		return "#" + comment;
	}
	
	public String getCommentValue(){
		return comment;
	}
}