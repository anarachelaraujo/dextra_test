package com.dextra.test.selenium.mapping;

import org.openqa.selenium.WebDriver;

import com.dextra.test.selenium.utils.Page;

public class ProductListPageMapping extends Page{
	
	public ProductListPageMapping(WebDriver driver) {
		super(driver);
	}

	public void clickOnFirstProduct(){
		waitForElementToBeClickable(".//*[@class='product-grid-item col-lg-3 col-sm-4 col-xs-6'][1]");
		clickOn(".//*[@class='product-grid-item col-lg-3 col-sm-4 col-xs-6'][1]");
	}
}
