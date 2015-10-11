package model;

import model.expr.Environment;

public class CommentSlot implements Slot {

	private String address;
	private Comment comment;
	
	public CommentSlot (String address, Comment comment) {
		this.address = address;
		this.comment = comment;
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

	@Override
	public String toString(){
		return comment.toString();
	}
}
