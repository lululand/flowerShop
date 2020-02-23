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
	
	public double calculateDeliveryTotal(boolean sameDayDelivery, String zipCode) {
		double deliveryTotal = 0;
		double sameDayFee = 5.99;
		int zipCodeInt = Integer.parseInt(zipCode.trim());
		
//		* the delivery fee is $3.99 if the zipcode falls between 20000 and 29999 
//		(+$5.99 for same day delivery)
		if (sameDayDelivery && (zipCodeInt >= 20000 && zipCodeInt <= 29999))
			try {
				deliveryTotal = 3.99 + sameDayFee;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		if (!sameDayDelivery && (zipCodeInt >= 20000 && zipCodeInt <= 29999))
			try {
				deliveryTotal = 3.99;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		
//	    * the delivery fee is $6.99 if the zipcode falls between 30000 and 39999 
//		(+$5.99 for same day delivery)
		if (sameDayDelivery && (zipCodeInt >= 30000 && zipCodeInt <= 39999))
			try {
				deliveryTotal = 6.99 + sameDayFee;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		if (!sameDayDelivery && (zipCodeInt >= 30000 && zipCodeInt <= 39999))
			try {
				deliveryTotal = 6.99;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		
//	    * the delivery fee is waived ($0.00) if the zipcode falls between 10000 and 19999 
		if (zipCodeInt >= 10000 && zipCodeInt <= 19999)
			try {
				deliveryTotal = 0.00;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		
//	    * all other zipcodes cost $19.99 (same day delivery is not an option)
		if (zipCodeInt < 10000 || zipCodeInt > 39999)
			try {
				deliveryTotal = 19.99;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		return deliveryTotal;
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
