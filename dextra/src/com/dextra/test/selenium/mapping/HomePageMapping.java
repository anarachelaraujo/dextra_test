package com.dextra.test.selenium.mapping;

import org.openqa.selenium.WebDriver;
import com.dextra.test.selenium.utils.Page;

public class HomePageMapping extends Page{
	
	public HomePageMapping(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnNewClient(){
		waitForElementToBeClickable(".//*[contains(text(), 'Cliente novo')]");
		clickOn(".//*[contains(text(), 'Cliente novo')]");
	}
	
	public void clickOnRegisterDropdown(){
		waitForElementToBeClickable(".//*[@id='h_usr-link']");
		clickOn(".//*[@id='h_usr-link']");
	}
	
	public void clickOnSearchInput(){
		waitForElementToBeClickable(".//*[@id='h_search-input']");
		clickOn(".//*[@id='h_search-input']");
	}
	
	public void typeSearchInput(String search){
		sendKeys(".//*[@id='h_search-input']", search);
	}
	
	public void clickOnFirstResult(){
		waitForElementToBeClickable(".//*[@class='ac-lst-it sz sz-1']");
		clickOn(".//*[@class='ac-lst-it sz sz-1']");
	}

}
