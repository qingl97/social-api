package com.amundi.social.common.model;

public class Comment extends AbstractAction {
	
	private int note;
	
	public Comment(String appId, String productId, String userId, int note) {
		super(appId, productId, userId);
		this.note = note;
	}

	@Override
	public ActionType getType() {
		return ActionType.COMMENT;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}

}
