package com.koreait.app.board.dao;

public class BoardDTO {
	private int shareboardnum;
	private String memberid;
	private String useraddr;
	private String shareboardtitle;
	private String shareboardcontents;
	private String shareboarddate;
	private int shareboardreadcnt;
	
	public BoardDTO() {;}

	public int getShareboardnum() {
		return shareboardnum;
	}

	public void setShareboardnum(int shareboardnum) {
		this.shareboardnum = shareboardnum;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getUseraddr() {
		return useraddr;
	}

	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}

	public String getShareboardtitle() {
		return shareboardtitle;
	}

	public void setShareboardtitle(String shareboardtitle) {
		this.shareboardtitle = shareboardtitle;
	}

	public String getShareboardcontents() {
		return shareboardcontents;
	}

	public void setShareboardcontents(String shareboardcontents) {
		this.shareboardcontents = shareboardcontents;
	}

	public String getShareboarddate() {
		return shareboarddate;
	}

	public void setShareboarddate(String shareboarddate) {
		this.shareboarddate = shareboarddate;
	}

	public int getShareboardreadcnt() {
		return shareboardreadcnt;
	}

	public void setShareboardreadcnt(int shareboardreadcnt) {
		this.shareboardreadcnt = shareboardreadcnt;
	}
	
	
	
}
	