package com.dextra.test.selenium.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Base {

    public final static String serverUrl = "https://www.americanas.com.br/";

    public ChromeDriver driver;

    @Before
    public void startBrowser() throws IOException {

        ChromeDriverManager.getInstance().version("2.36").setup();
        
            this.driver = new ChromeDriver();

            List<String> command = new ArrayList<String>();
            command.add("/bin/bash");
            command.add("-c");
            command.add("osascript -e \"tell application \\\"Chrome\\\" to activate\"");
            ProcessBuilder pb2 = new ProcessBuilder(command);
            pb2.start();
       
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().setSize(new Dimension(1280, 800));
        this.driver.get(serverUrl);

    }

    @After
    public void closeBrowser() throws IOException {
        this.driver.quit();
    }

    public ChromeDriver getDriver() {
        return this.driver;
    }

}
