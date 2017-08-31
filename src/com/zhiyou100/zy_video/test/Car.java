package com.zhiyou100.zy_video.test;

public class Car {

	private String name;
	private String price;
	@Override
	public String toString() {
		return "CarJsonTest [name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
