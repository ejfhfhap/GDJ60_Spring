package com.iu.s1.board;

public class BoardDTO extends BbsDTO{
	private String title;
	private Integer hit;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	
}
