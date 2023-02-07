package com.iu.s1.product;

import org.springframework.stereotype.Component;

@Component
public class ProductDTO {
	private Integer productnum;
	private String productname;
	private String productdetail;
	private Double productjumsu;
	public Integer getProductnum() {
		return productnum;
	}
	public void setProductnum(Integer productnum) {
		this.productnum = productnum;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}
	public Double getProductjumsu() {
		return productjumsu;
	}
	public void setProductjumsu(Double productjumsu) {
		this.productjumsu = productjumsu;
	}
	
	
	

	
}
