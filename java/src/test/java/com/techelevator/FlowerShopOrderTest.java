package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


public class FlowerShopOrderTest {

	@Test
	public void calculateSubtotalWithZeroRoses() {
		FlowerShopOrder testOrder = new FlowerShopOrder();
		double testSubtotal = testOrder.calculateSubtotal(0);
		
		Assert.assertEquals(19.99, testSubtotal, 0.001);

	}
	
	@Test
	public void calculateSubtotalWith12Roses() {
		FlowerShopOrder testOrder = new FlowerShopOrder();
		double testSubtotal = testOrder.calculateSubtotal(12);
		
		Assert.assertEquals(55.87, testSubtotal, 0.001);

	}
	
	@Test
	public void calculateSubtotalWith48Roses() {
		FlowerShopOrder testOrder = new FlowerShopOrder();
		double testSubtotal = testOrder.calculateSubtotal(48);
		
		Assert.assertEquals(163.51, testSubtotal, 0.001);

	}

}
