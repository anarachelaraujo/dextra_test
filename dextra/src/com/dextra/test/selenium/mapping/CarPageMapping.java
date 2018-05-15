package com.dextra.test.selenium.mapping;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.dextra.test.selenium.utils.Page;

public class CarPageMapping extends Page{
	
	public CarPageMapping(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnQuantityDropdown(){
		waitForElementToBeClickable(".//*[@class='basket-productQuantity selectbox']");
		clickOn(".//*[@class='basket-productQuantity selectbox']");
	}
	
	public void selectQuantity(int quantity){
		waitForElementToBeClickable(".//*[@class='basket-productQuantity selectbox']//*[contains(text(), '"+quantity+"')]");
		clickOn(".//*[@class='basket-productQuantity selectbox']//*[contains(text(), '"+quantity+"')]");
				
	}
	
	public String getTotal(){
		return getText(".//*[@class='summary-total']/span[2]");
	}
	
	public String getTextSplit(){
		return getText(".//*[@class='summary-totalInstallments']");
	}
	
	public void validateTotal(double total){
		String value = this.getTextSplit();
		
		 if (value.length() > 2) 
			 	value = value.substring (2); 
		
		if(total > Double.parseDouble(value) ){
			
			Assert.fail();
		}
	}

}
