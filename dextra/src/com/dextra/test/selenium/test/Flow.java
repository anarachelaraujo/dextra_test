package com.dextra.test.selenium.test;

import org.junit.Test;

import com.dextra.test.selenium.mapping.CarPageMapping;
import com.dextra.test.selenium.mapping.HomePageMapping;
import com.dextra.test.selenium.mapping.ProductListPageMapping;
import com.dextra.test.selenium.mapping.ProductPageMapping;
import com.dextra.test.selenium.mapping.RegisterPageMapping;
import com.dextra.test.selenium.mapping.SecurePageMapping;
import com.dextra.test.selenium.utils.Base;

public class Flow extends Base{
	
	final private HomePageMapping home = new HomePageMapping(this.getDriver());
	final private RegisterPageMapping register = new RegisterPageMapping(this.getDriver());
	final private ProductPageMapping product = new ProductPageMapping(this.getDriver());
	final private ProductListPageMapping productList = new ProductListPageMapping(this.getDriver());
	final private SecurePageMapping secure = new SecurePageMapping(this.getDriver());
	final private CarPageMapping car = new CarPageMapping(this.getDriver());
	
	@Test
	public void addProductOnCarList(){
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
				
		//send email already register
		register.typeEmail("vbbbnn@hotmail.com"); 
				
		//fill all other information correctly 
		register.clickOnPassword();
		register.typePassword("tests");
						
		register.clickOnCPF();
		register.typeCPF("11111111111");
						
		register.clickOnName();
		register.typeName("test test");
						
		register.clickOnBirthday();
		register.typeBirthday("16101995");
						
		register.selectFemale();
		register.typePhone("99999999999");
				
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
