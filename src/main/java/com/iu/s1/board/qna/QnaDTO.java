package com.iu.s1.board.qna;

import com.iu.s1.board.BoardDTO;

public class QnaDTO extends BoardDTO {
	private Integer ref;
	private Integer step;
	private Integer depth;
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
}
