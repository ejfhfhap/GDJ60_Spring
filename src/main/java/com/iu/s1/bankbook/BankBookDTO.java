package com.iu.s1.bankbook;

public class BankBookDTO {
	private Integer bookNumber;
	private String bookName;
	private double bookRate;
	private Integer bookSale;
	private String bookDetail;
	
	public Integer getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Integer bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookRate() {
		return bookRate;
	}
	public void setBookRate(double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
	
}
