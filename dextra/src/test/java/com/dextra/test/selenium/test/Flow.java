package com.dextra.test.selenium.test;

import org.junit.Test;

import com.dextra.test.selenium.utils.Base;

public class Flow extends Base{
	
	
	@Test
	public void addProductOnCarList(){
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
				
		//send email already register
		register.typeEmail("test_12345@hotmail.com"); 
				
		//fill all other information correctly 
		register.clickOnPassword();
		register.typePassword("tests@123");
						
		register.clickOnCPF();
		register.typeCPF("31400693241");
						
		register.clickOnName();
		register.typeName("test test");
						
		register.clickOnBirthday();
		register.typeBirthday("16101995");
						
		register.selectFemale();
		register.typePhone("19987227898");
				
		//send new register
		register.clickOnRegisterButton();
				
		home.clickOnSearchInput();
		home.typeSearchInput("moto g6");
		home.clickOnFirstResult();
		
		productList.clickOnFirstProduct();
		product.clickOnBuyButton();
		
		secure.clickOnContiuneButton();
		
		car.clickOnQuantityDropdown();
		car.selectQuantity(2);
		
		car.validateTotal(5000);
		car.compareString(car.getTextSplit(), "Em até 10x s/ juros");
	}


}
