package model;

import model.expr.Environment;

public class CommentSlot implements Slot {

	private Comment comment;
	private String address;
	
	public CommentSlot (Comment comment, String address) {
		this.comment = comment;
		this.address = address;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Comment getComment() {
		return comment;
	}

	@Override
	public double value(Environment env) {
		return 0;
	}

	@Override
	public String address() {
		return address;
	}

}
