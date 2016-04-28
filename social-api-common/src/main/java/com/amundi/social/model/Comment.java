package com.amundi.social.model;

public class Comment extends AbstractAction {
	
	private int note;
	
	public Comment(int note) {
		this.note = note;
	}

	@Override
	public Action getType() {
		return Action.COMMENT;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}

}
