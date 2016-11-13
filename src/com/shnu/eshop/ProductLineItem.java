package com.shnu.eshop;

public class ProductLineItem {
	
	private int id;
	private String name;
	private int price;
	private int quantity;
	private int subtotal = 0;
	ProductLineItem(int id,String name,int price,int quantity){
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public ProductLineItem() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int calSubtotal(){
		subtotal += quantity*price;
		return subtotal;
	}
	public int getSubtotal(){
		return subtotal;
	}
}
