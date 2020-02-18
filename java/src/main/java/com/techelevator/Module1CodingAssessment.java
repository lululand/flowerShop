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

		FlowerShopOrder orderOne = new FlowerShopOrder("Basic", 12);
		System.out.println("ORDER - " + orderOne.getBouquetType() + " - " + orderOne.getNumberOfRoses() + " roses - "
				+ orderOne.calculateSubtotal(orderOne.getNumberOfRoses()) + "\n");

//		List<FlowerShopOrder> flowerShopOrdersList = new ArrayList<>();
//		FlowerShopOrder(flowerShopOrders.getBouquetType(), flowerShopOrders.getNumberOfRoses());

		List<String> stringList = new ArrayList<String>();
		List<FlowerShopOrder> flowerOrderList = new ArrayList<FlowerShopOrder>(stringList.size());
		File inputFile = new File("data-files/FlowerInput.csv");

		if (inputFile.exists()) {
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
				while (inputScanner.hasNext()) {
					String lineInput = inputScanner.nextLine();
					// put each line into an array
					String[] eachLineArray = lineInput.split("\\n"); // it's not splitting by line? 
					
//					System.out.println(lineInput + "\r");
//					System.out.println(eachLineArray[0]);
//					eachLineArray.split("\r");
//					System.out.println(Arrays.toString(eachLineArray)); // this makes it look like it is split
//					System.out.println(Arrays.deepToString(eachLineArray));
//					System.out.println(eachLineArray.length); 
//					System.out.println(eachLineArray[0]); // 
//					System.out.println(eachLineArray[1]); //  this is out of bounds

					// add each string at eachLineArray[i] into an array list
					for (String string : eachLineArray) {
						stringList.add(string);
						
						// take each string ("Basic,0") in the array list, split it and convert the new
						// index[1]
						// to an int to use in 2nd parameter for object list
						for (String order : stringList) {
							String temp = order;
							String[] tempSplit = temp.split(","); // split it by the comma to be ["Elite", "12"]
							int tempNum = Integer.parseInt(tempSplit[1]); // turn the number-string into an int for the
																			// bouquetType
							// *** create a new object for each index-item of stringList
//							FlowerShopOrder tempObject = new FlowerShopOrder(tempSplit[0], tempNum); 
							// add each new object to the object list
							flowerOrderList.add(new FlowerShopOrder(tempSplit[0], tempNum));
						}
					}
				}
//				System.out.println(orderList.get(0).getBouquetType() + " - " + orderList.get(0).getNumberOfRoses());
//				System.out.println(orderList.get(0).calculateSubtotal(orderList.get(0).getNumberOfRoses()));
//				System.out.println(calculateAllOrdersSubtotal(flowerOrderList));
				}
		}
//		
//		System.out.println(flowerOrderList.get(0).getBouquetType() + " bouquet with " + flowerOrderList.get(0).getNumberOfRoses() + " roses = " + flowerOrderList.get(0).calculateSubtotal(flowerOrderList.get(0).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(1).getBouquetType() + " bouquet with " + flowerOrderList.get(1).getNumberOfRoses() + " roses = " + flowerOrderList.get(1).calculateSubtotal(flowerOrderList.get(1).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(2).getBouquetType() + " bouquet with " + flowerOrderList.get(2).getNumberOfRoses() + " roses = " + flowerOrderList.get(2).calculateSubtotal(flowerOrderList.get(2).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(3).getBouquetType() + " bouquet with " + flowerOrderList.get(3).getNumberOfRoses() + " roses = " + flowerOrderList.get(3).calculateSubtotal(flowerOrderList.get(3).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(4).getBouquetType() + " bouquet with " + flowerOrderList.get(4).getNumberOfRoses() + " roses = " + flowerOrderList.get(4).calculateSubtotal(flowerOrderList.get(4).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(5).getBouquetType() + " bouquet with " + flowerOrderList.get(5).getNumberOfRoses() + " roses = " + flowerOrderList.get(5).calculateSubtotal(flowerOrderList.get(5).getNumberOfRoses()));
//		System.out.println(flowerOrderList.get(6).getBouquetType() + " bouquet with " + flowerOrderList.get(6).getNumberOfRoses() + " roses = " + flowerOrderList.get(6).calculateSubtotal(flowerOrderList.get(6).getNumberOfRoses()));
//	
	}

	public static double calculateAllOrdersSubtotal(List<FlowerShopOrder> orderList) {
		// testing
		double subtotal0 = orderList.get(0).calculateSubtotal(orderList.get(0).getNumberOfRoses());
		double subtotal1 = orderList.get(1).calculateSubtotal(orderList.get(1).getNumberOfRoses());
		double subtotal2 = orderList.get(2).calculateSubtotal(orderList.get(2).getNumberOfRoses());
		double subtotal3 = orderList.get(3).calculateSubtotal(orderList.get(3).getNumberOfRoses());
		double subtotal4 = orderList.get(4).calculateSubtotal(orderList.get(4).getNumberOfRoses());
		double subtotal5 = orderList.get(5).calculateSubtotal(orderList.get(5).getNumberOfRoses());
		
		// get the subtotal of each Order in the list.
//		for (int i = 0; i < ordersList.size(); i++) {
//			System.out.println(ordersList.get(i).calculateSubtotal(ordersList.get(i).getNumberOfRoses()));
//		}
//		
//		for (int i = 0; i < ordersList.size(); i++) {
//			double sum = +ordersList.get(i).calculateSubtotal(ordersList.get(i).getNumberOfRoses());
////			double sum =+ tempSubtotal;
////		    System.out.println(orderList.get(0).calculateSubtotal(orderList.get(0).getNumberOfRoses()));
//		}
		double subtotalsTotal = subtotal0 + subtotal1 + subtotal2 + subtotal3 + subtotal4 + subtotal5; 
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
