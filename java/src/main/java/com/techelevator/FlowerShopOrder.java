package com.techelevator;

public class FlowerShopOrder {
	
	private String bouquetType;
	private int numberOfRoses;
	private double subtotal; // order subtotal before shipping by adding $19.99 for the standard bouquet plus $2.99 for each rose
	
	public FlowerShopOrder(String bouquetType, int numberOfRoses) {
		this.setBouquetType(bouquetType);
		this.setNumberOfRoses(numberOfRoses);
	}
	
	public FlowerShopOrder() {
		// TODO Auto-generated constructor stub 
	}

	public double calculateSubtotal(int numberOfRoses) {
		double standardBouquet = 19.99;
		double subtotal = 0;
		if(numberOfRoses == 0) {
			subtotal = 19.99;
		}
		else if(numberOfRoses > 0) {
			subtotal = standardBouquet + (numberOfRoses * 2.99);
		}
		return subtotal;
	}
	
	@Override
	public String toString() {
		return "Order [type=" + bouquetType + ", numberOfRoses=" + numberOfRoses + "]";
	}

	public String getBouquetType() {
		return bouquetType;
	}

	public void setBouquetType(String bouquetType) {
		this.bouquetType = bouquetType;
	}

	public int getNumberOfRoses() {
		return numberOfRoses;
	}

	public void setNumberOfRoses(int numberOfRoses) {
		this.numberOfRoses = numberOfRoses;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	} 
}
