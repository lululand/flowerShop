package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

				for (int i = 0; i < flowerOrderList.size(); i++) {
					System.out.println("ORDER - bouquet type: " + flowerOrderList.get(i).getBouquetType() + " with "
							+ flowerOrderList.get(i).getNumberOfRoses() + " roses - subtotal: $"
							+ flowerOrderList.get(i).calculateSubtotal(flowerOrderList.get(i).getNumberOfRoses()));
				}

				System.out.println("********************************");

				System.out.println("The grand total for all of the flower orders is: $"
						+ calculateAllOrdersSubtotal(flowerOrderList));

				scanner.close();

			} catch (FileNotFoundException e) {
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

}
