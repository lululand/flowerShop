package com.techelevator;

import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		FlowerShopOrder orderOne = new FlowerShopOrder("Basic", 12);
		
		System.out.println("ORDER - " + orderOne.getBouquetType() + " - " + orderOne.getNumberOfRoses() + " roses - " + orderOne.calculateSubtotal(orderOne.getNumberOfRoses()));
		
		Scanner scanner = new Scanner();
		
	}

	public double caclulateDeliveryTotal(boolean sameDayDelivery, String zipCode) {
//		* the delivery fee is $3.99 if the zipcode falls between 20000 and 29999 
//		(+$5.99 for same day delivery)
		double deliveryTotal = 0;
		double sameDayFee = 5.99;
		int zipCodeInt = Integer.parseInt(zipCode.trim());
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
		if (sameDayDelivery && (zipCodeInt >= 10000 && zipCodeInt <= 19999))
			try {
				deliveryTotal = sameDayFee;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		if (!sameDayDelivery && (zipCodeInt >= 10000 && zipCodeInt <= 19999))
			try {
				deliveryTotal = 0.00;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
//	    * all other zipcodes cost $19.99 (same day delivery is not an option)
		if ((sameDayDelivery || !sameDayDelivery) && (zipCodeInt < 10000 && zipCodeInt > 39999))
			try {
				deliveryTotal = 19.99;
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException: " + nfe.getMessage());
			}
		return deliveryTotal;
	}
}


