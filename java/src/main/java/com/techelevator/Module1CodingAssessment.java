package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {

		FlowerShopOrder orderOne = new FlowerShopOrder("Basic", 12);
		System.out.println("ORDER - " + orderOne.getBouquetType() + " - " + orderOne.getNumberOfRoses() + " roses - "
				+ orderOne.calculateSubtotal(orderOne.getNumberOfRoses()) + "\n");

//		List<FlowerShopOrder> flowerShopOrdersList = new ArrayList<>();
//		FlowerShopOrder(flowerShopOrders.getBouquetType(), flowerShopOrders.getNumberOfRoses());
		
		File inputFile = new File("data-files/FlowerInput.csv");

		if (inputFile.exists()) {
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile()).useDelimiter(System.lineSeparator())) {
				
				List<String> stringList = new ArrayList<String>();
				List<FlowerShopOrder> orderList = new ArrayList<FlowerShopOrder>(stringList.size());
				
				while (inputScanner.hasNext()) {
					String lineInput = inputScanner.nextLine();
					// now put each line into an array 
					String[] eachLineArray = lineInput.split("\r\n"); 
//					System.out.println(Arrays.toString(eachLineArray));
					
					// add the string at each index into an array list
					for(String string : eachLineArray) {
						stringList.add(string);
						// take each string "Basic,0" in the array list, split and convert to int to use for object list
						for(String order : stringList) {  
							String temp = order;
							String[] tempSplit = temp.split(","); // split it by the comma to be ["Elite", "12"] 	
							int tempNum = Integer.parseInt(tempSplit[1]); // turn the number-string into an int for the bouquetType 
							// create a new object for each index-item of stringList 
							FlowerShopOrder tempObject = new FlowerShopOrder(tempSplit[0], tempNum); 
							// add each new object to the object list
							orderList.add(tempObject);
//							System.out.println(tempSplit[1]);
//							System.out.println(((Object)tempNum).getClass().getName()); // it does change to integer
//							System.out.println(orderList.getClass().getName());
						}
					}
				}
//				System.out.println(orderList);
//				System.out.println(stringList.get(1));
//				System.out.println(orderList.get(1));
			}
		}
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
