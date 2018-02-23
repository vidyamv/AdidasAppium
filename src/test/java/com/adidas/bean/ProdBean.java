package com.adidas.bean;

public class ProdBean {
	
	public String prodName;
	public String prodPrice;
public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
		System.out.println(this.prodName);
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
		System.out.println(this.prodPrice);
	}



}
