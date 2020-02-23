package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


public class FlowerShopOrderTest {

	FlowerShopOrder testOrder = new FlowerShopOrder();
	double sameDayFee = 5.99;
	
	@Test
	public void calculateSubtotalWithZeroRoses() {
		double testSubtotal = testOrder.calculateSubtotal(0);
		
		Assert.assertEquals(19.99, testSubtotal, 0.001);
	}
	
	@Test
	public void calculateSubtotalWith12Roses() {
		double testSubtotal = testOrder.calculateSubtotal(12);
		
		Assert.assertEquals(55.87, testSubtotal, 0.001);
	}
	
	@Test
	public void calculateSubtotalWith48Roses() {
		double testSubtotal = testOrder.calculateSubtotal(48);
		
		Assert.assertEquals(163.51, testSubtotal, 0.001);
	}
		
	@Test
	public void calculateDeliveryFeefor20202RegularDelivery() {
		double expectedTotal = 3.99;
		double actualTotal = testOrder.calculateDeliveryTotal(false, "20202");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	
	@Test
	public void calculateDeliveryFeefor20202SameDayDelivery() {
		double expectedTotal = 3.99 + sameDayFee;
		double actualTotal = testOrder.calculateDeliveryTotal(true, "20202");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	
	@Test
	public void calculateDeliveryFeefor30303RegularDelivery() {
		double expectedTotal = 6.99;
		double actualTotal = testOrder.calculateDeliveryTotal(false, "30303");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	
	@Test
	public void calculateDeliveryFeefor30303SameDayDelivery() {
		double expectedTotal = 6.99 + sameDayFee;
		double actualTotal = testOrder.calculateDeliveryTotal(true, "30303");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	
	@Test
	public void calculateDeliveryFeefor10101RegularDelivery() {
		double expectedTotal = 0.00;
		double actualTotal = testOrder.calculateDeliveryTotal(false, "10101");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	
	@Test
	public void calculateDeliveryFeefor50505() {
		double expectedTotal = 19.99;
		double actualTotal = testOrder.calculateDeliveryTotal(true, "50505");
		Assert.assertEquals(expectedTotal, actualTotal, .001);
	}
	


}
