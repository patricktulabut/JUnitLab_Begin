package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void testGetIssuingStore() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());

	}
	
	@Test
	public void testGetBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test 
	public void deduct_RemainingBalance()  
	{  
		double balance;  
		GiftCard card;  
		int issuingStore;  
		String s;  
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		s = "Remaining Balance: " + String.format("%6.2f",  95.00);
		assertEquals("deduct(5.00)", s, card.deduct(5.00));
	}
	
	@Test 
	public void deduct_AmountDue()  
	{  
		double balance;  
		GiftCard card;  
		int issuingStore;  
		String s;  
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		s = "Amount Due: " + String.format("%6.2f", 5.00);
		assertEquals("deduct(100.00)", s, card.deduct(105.00));
	}
	
	@Test 
	public void invalidTransaction() 
	{
		double balance;  
		GiftCard card;  
		int issuingStore;  
		String s;  
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		s = "Invalid Transaction";
		assertEquals("deduct(-5.00)", s, card.deduct(-5.00));
		
	}


	@Test
	public void constructor_IncorrectBalance()  
	{  
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);}); 
	}  
	
	@Test
	public void constructor_IncorrectID_LOW()  
	{  
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,-100.00);}); 
	} 
	
	@Test
	public void constructor_IncorrectID_HIGH()  
	{  
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,-100.00);}); 
	} 

}
