package com.dextra.test.selenium.test;

import org.junit.Test;

import com.dextra.test.selenium.mapping.HomePageMapping;
import com.dextra.test.selenium.mapping.RegisterPageMapping;
import com.dextra.test.selenium.utils.Base;

public class Register extends Base {
	
	final private HomePageMapping home = new HomePageMapping(this.getDriver());
	final private RegisterPageMapping register = new RegisterPageMapping(this.getDriver());
	
	@Test
	public void validateEmailAlreadyRegisterMessage() throws InterruptedException{
		
		
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
		
		//send email already register
		register.typeEmail("teste@hotmail.com"); 
		
		//fill all other information correctly 
		register.clickOnPassword();
		register.typePassword("tests");
		
		register.clickOnCPF();
		register.typeCPF("36029896407");
		
		register.clickOnName();
		register.typeName("test test");
		
		register.clickOnBirthday();
		register.typeBirthday("16101995");
		
		register.selectFemale();
		register.typePhone("99999999999");
		
		
		//send new register
		register.clickOnRegisterButton();
		
		//validate email already exist
		register.compareString(register.getEmaiAlreadyRegisterMessage(), "E-mail já cadastrado");
	}
	
	@Test
	public void validateWeakPassword() throws InterruptedException{
		
		
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
		
		//send email already register
		register.typeEmail("asdfgtyu@hotmail.com"); 
		
		//fill all other information correctly 
				register.clickOnPassword();
				register.typePassword("te");
				
				register.clickOnCPF();
				register.typeCPF("36029896407");
				
				register.clickOnName();
				register.typeName("test test");
				
				register.clickOnBirthday();
				register.typeBirthday("16101995");
				
				register.selectFemale();
				register.typePhone("99999999999");
		
		//send new register
		register.clickOnRegisterButton();
		
		//validate email already exist
		register.compareString(register.getPasswordStrenght(), "fraca");
		//not find this message Senha precisa ter entre 6 a 50 caracteres.

	}

	
	@Test
	public void validateInvalidCPF() throws InterruptedException{
		
		
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
		
		//send email already register
		register.typeEmail("vbbbnn@hotmail.com"); 
		
		//fill all other information correctly 
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
		
		//validate email already exist
		register.compareString(register.getCPFInvalid(), "Campo inválido");
	}
}
