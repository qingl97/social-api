package com.amundi.social.common.model;

public class Comment extends AbstractAction {
	
	private int note;
	private String content;
	
	@Override
	public ActionType getType() {
		return ActionType.COMMENT;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String text) {
		this.content = text;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}

}
