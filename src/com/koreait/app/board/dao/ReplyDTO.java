package com.koreait.app.board.dao;

public class ReplyDTO {
	private int shareboardnum;
	private int sharereplynum;
	private String memberid;
	private String sharereplycontents;
	
	public int getShareboardnum() {
		return shareboardnum;
	}
	public void setShareboardnum(int shareboardnum) {
		this.shareboardnum = shareboardnum;
	}
	public int getSharereplynum() {
		return sharereplynum;
	}
	public void setSharereplynum(int sharereplynum) {
		this.sharereplynum = sharereplynum;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getSharereplycontents() {
		return sharereplycontents;
	}
	public void setSharereplycontents(String sharereplycontents) {
		this.sharereplycontents = sharereplycontents;
	}
	
	
	
	
}
