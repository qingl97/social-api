package com.amundi.social.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Comment extends AbstractActivity {
	
	@JsonIgnore
	private int commentId;
	private int note;
	private String content;
//	private int parent;
//	private int level;
	
	@Override
	public ActivityType getType() {
		return ActivityType.COMMENT;
	}
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

//	public void setParent(int id) {
//		this.parent = id;
//	}
//
//	public int getParent() {
//		return parent;
//	}
//
//	public int getLevel() {
//		return level;
//	}
//
//	public void setLevel(int level) {
//		this.level = level;
//	}
}
