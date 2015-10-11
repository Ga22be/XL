package model;

import model.expr.Environment;

public class CommentSlot implements Slot {
	private String comment;
	private String address;
	
	public CommentSlot(String address, String comment) {
		this.address = address;
		this.comment = comment;
	}
	
	@Override
	public double value(Environment env) {
		return 0;
	}
	@Override

	public String address() {
		return address;
	}

	@Override
	public String toString(){
		return "#" + comment;
	}
	
	public String getCommentValue(){
		return comment;
	}
}