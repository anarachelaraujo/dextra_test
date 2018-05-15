package com.dextra.test.selenium.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.dextra.test.selenium.mapping.CarPageMapping;
import com.dextra.test.selenium.mapping.HomePageMapping;
import com.dextra.test.selenium.mapping.ProductListPageMapping;
import com.dextra.test.selenium.mapping.ProductPageMapping;
import com.dextra.test.selenium.mapping.RegisterPageMapping;
import com.dextra.test.selenium.mapping.SecurePageMapping;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Base {
	
	protected static HomePageMapping home;
	protected static RegisterPageMapping register;
	protected static ProductPageMapping product;
	protected static ProductListPageMapping productList;
	protected static SecurePageMapping secure;
	protected static CarPageMapping car;

	protected static WebDriver driver;
	
	
	

	public static String serverUrl = "https://www.americanas.com.br/";

	

	@Before
	public void startBrowser() throws IOException {

		ChromeDriverManager.getInstance().version("2.36").setup();
		
		if (System.getProperty("headless") != null && System.getProperty("headless").equals("true")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.setCapability("acceptInsecureCerts", true);
			driver = new ChromeDriver(options);
			
		} else {
			driver = new ChromeDriver();
			
			List<String> command = new ArrayList<String>();
			command.add("/bin/bash");
			command.add("-c");
			command.add("osascript -e \"tell application \\\"Chrome\\\" to activate\"");
			ProcessBuilder pb2 = new ProcessBuilder(command);
			pb2.start();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1280, 800));

		driver.get(serverUrl);

		home = new HomePageMapping(driver);
		register = new RegisterPageMapping(driver);
		product = new ProductPageMapping(driver);
		productList = new ProductListPageMapping(driver);
		secure = new SecurePageMapping(driver);
		car = new CarPageMapping(driver);
		
	}

	@After
	public void closeBrowser() throws IOException {

		driver.quit();
	}

}
