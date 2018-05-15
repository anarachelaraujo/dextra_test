package com.dextra.test.selenium.mapping;

import org.openqa.selenium.WebDriver;
import com.dextra.test.selenium.utils.Page;

public class RegisterPageMapping extends Page{
	
	public RegisterPageMapping(WebDriver driver) {
		super(driver);
	}
	public void clickOnEmail (){
		waitForElementToBeClickable(".//*[@id='email-input']");
		clickOn(".//*[@id='email-input']");
	}
	
	public void typeEmail (String email){
		sendKeys(".//*[@id='email-input']", email);
	}
	
	public void clickOnPassword (){
		waitForElementToBeClickable(".//*[@id='password-input']");
		clickOn(".//*[@id='password-input']");
	}
	
	public void typePassword (String password){
		sendKeys(".//*[@id='password-input']", password);
	}
	
	public void clickOnCPF (){
		waitForElementToBeClickable(".//*[@id='cpf-input']");
		clickOn(".//*[@id='cpf-input']");
	}
	
	public void typeCPF (String cpf){
		sendKeys(".//*[@id='cpf-input']", cpf);
	}
	
	public void clickOnName (){
		waitForElementToBeClickable(".//*[@id='name-input']");
		clickOn(".//*[@id='name-input']");
	}
	
	public void typeName (String name){
		sendKeys(".//*[@id='name-input']", name);
	}
	
	public void clickOnBirthday (){
		waitForElementToBeClickable(".//*[@id='birthday-input']");
		clickOn(".//*[@id='birthday-input']");
	}
	
	public void typeBirthday (String birthday){
		sendKeys(".//*[@id='birthday-input']", birthday);
	}
	
	public void clickOnPhone (){
		waitForElementToBeClickable(".//*[@id='phone-input']");
		clickOn(".//*[@id='phone-input']");
	}
	
	public void typePhone (String email){
		sendKeys(".//*[@id='phone-input']", email);
	}
	
	public String getEmaiAlreadyRegisterMessage(){
		return getText(".//*[@id='email']/div");
	}
	
	public void selectFemale(){
		waitForElementToBeClickable(".//*[@id='gender_F']/following-sibling::label");
		clickOn(".//*[@id='gender_F']/following-sibling::label");
	}
	
	public void selectMale(){
		clickOn(".//*[@id='gender_M']/following-sibling::label");
	}
	
	public String getPasswordStrenght (){
		return getText(".//*[@id='password']/div[2]");
	}
	
	public void clickOnRegisterButton(){
		clickOn(".//*[@type='submit']");
	}
	
	public String getCPFInvalid(){
		return getText(".//*[@id='cpf']/div");
	}

}
