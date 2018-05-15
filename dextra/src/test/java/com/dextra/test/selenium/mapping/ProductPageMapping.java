package com.dextra.test.selenium.mapping;

import org.openqa.selenium.WebDriver;

import com.dextra.test.selenium.utils.Page;

public class ProductPageMapping extends Page {
	
	public ProductPageMapping(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnBuyButton(){
		waitForElementToBeClickable(".//*[@id='btn-buy']");
		clickOn(".//*[@id='btn-buy']");
	}

}
