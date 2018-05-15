package com.dextra.test.selenium.test;

import org.junit.Test;

import com.dextra.test.selenium.utils.Base;

public class Register extends Base {

	
	@Test
	public void validateEmailAlreadyRegisterMessage() throws InterruptedException{
		
		
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
		
		Thread.sleep(1000);
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
		register.typeEmail("test_1234@hotmail.com"); 
		
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
		
		//validate weak password
		register.compareString(register.getPasswordStrenght(), "Senha precisa ter entre 6 a 50 caracteres.");

	}

	
	@Test
	public void validateInvalidCPF() throws InterruptedException{
		
		
		//open register form
		home.clickOnRegisterDropdown();
		home.clickOnNewClient();
		
		//send email already register
		register.typeEmail("test_123@hotmail.com"); 
		
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
		
		//validate invalid cpf
		register.compareString(register.getCPFInvalid(), "Campo inválido");
	}
}
