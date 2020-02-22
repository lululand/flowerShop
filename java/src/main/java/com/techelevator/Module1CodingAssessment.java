package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {

//		FlowerShopOrder orderOne = new FlowerShopOrder("Basic", 12);
//		System.out.println("ORDER - " + orderOne.getBouquetType() + " - " + orderOne.getNumberOfRoses() + " roses - "
//				+ orderOne.calculateSubtotal(orderOne.getNumberOfRoses()) + "\n");

		List<String> stringList = new ArrayList<String>();
		List<FlowerShopOrder> flowerOrderList = new ArrayList<FlowerShopOrder>(stringList.size());
		File inputFile = new File("data-files/FlowerInput.csv");

		if (inputFile.exists()) {
			try (Scanner scanner = new Scanner(inputFile.getAbsoluteFile())) {
				while (scanner.hasNext()) {
					String lineInput = scanner.nextLine();
					// put each line into an array
					String[] thisLineArr = lineInput.split(","); 

					String type = thisLineArr[0];
					int numOfFlowers = Integer.parseInt(thisLineArr[1]);

					FlowerShopOrder thisOrder = new FlowerShopOrder(type, numOfFlowers);
//					System.out.println(thisOrder.toString());
//					System.out.println("********");
					
					flowerOrderList.add(thisOrder);
				}
				
				for(int i = 0; i < flowerOrderList.size(); i++) {
				System.out.println("ORDER - bouquet type: " + flowerOrderList.get(i).getBouquetType() + " with " 
						+ flowerOrderList.get(i).getNumberOfRoses() + " roses - subtotal: $" 
						+ flowerOrderList.get(i).calculateSubtotal(flowerOrderList.get(i).getNumberOfRoses()));
				}
				
				System.out.println("********************************");
				
				System.out.println("The grand total for all of the flower orders is: $" 
				+ calculateAllOrdersSubtotal(flowerOrderList));
				
				scanner.close();

			}  catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static double calculateAllOrdersSubtotal(List<FlowerShopOrder> orderList) {
		int sizeNum = orderList.size();
		double subtotalsTotal = 0;
//		get the subtotal of each Order in the list and add them together.
		for (int i = 0; i < sizeNum; i++) {
			double eachSubtotal = orderList.get(i).calculateSubtotal(orderList.get(i).getNumberOfRoses());
			subtotalsTotal += eachSubtotal;
		}
		return subtotalsTotal;
	}

	public double calculateDeliveryTotal(boolean sameDayDelivery, String zipCode) {
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
