package com.dextra.test.selenium.mapping;

import org.openqa.selenium.WebDriver;

import com.dextra.test.selenium.utils.Page;

public class SecurePageMapping extends Page{
	
	public SecurePageMapping(WebDriver driver) {
		super(driver);
	}

	public void clickOnContiuneButton(){
		clickOn(".//*[@id='btn-continue']"); 
	}
}
