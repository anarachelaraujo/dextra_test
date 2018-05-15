package com.dextra.test.selenium.utils;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    private WebDriver driver;

    public Page(final WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        this.driver.get(Base.serverUrl + url);
    }

    public void clickOn(String path) {
        this.driver.findElement(By.xpath(path)).click();
    }

    public void findElementByLinkText(String path) {
        this.driver.findElement(By.linkText(path));
    }

    public void find(String path) {
        this.driver.findElement(By.xpath(path));
    }

    public void clear(String path) {
        this.driver.findElement(By.xpath(path)).clear();
    }

    public void findElements(String path) {
        this.driver.findElements(By.xpath(path));
    }

    public void waitForElementPresence(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, 90);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

    }

    public void waitForElementToBeInvisible(String xpath) {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

    }

    public void waitPleaseWaitToBeInvisible() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[contains(text(), 'Please wait')]")));

    }

    public void waitBlockUIToBeInvisible() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@id='customBlockUI']/div[1]")));

    }

    public void waitURLToContain(String pageName) {

        WebDriverWait wait = new WebDriverWait(this.driver, 180);
        wait.until(ExpectedConditions.urlContains(pageName));

    }

    public void waitForElementToBeClickable(String xpath) {

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

    }

    public void waitForTextToBe(String xpath, String value) {

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.textToBe(By.xpath(xpath), value));

    }

    public void waitAnAttributeValue(String xpath, String atribute, String value) {

        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.attributeContains(By.xpath(xpath), atribute, value));

    }

    public void waitPageToLoad() {

        this.waitAnAttributeValue(".//*[@data-ta='isLoaded']", "value", "true");

    }

    public void waitForTableElementsToLoad(String xpath, int numberOfRows) {

        WebDriverWait wait = new WebDriverWait(this.driver, 30);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), numberOfRows));
    }

    public void sendKeys(String path, String keys) {
        this.driver.findElement(By.xpath(path)).sendKeys(keys);
    }

    public void sendKeysById(String id, String keys) {
        this.driver.findElement(By.id(id)).sendKeys(keys);
    }

    public void clickOnLink(String text) {
        this.driver.findElement(By.linkText(text)).click();
        waitBlockUIToBeInvisible();
    }

    public String getClass(String xpath) {
        return this.driver.findElement(By.xpath(xpath)).getAttribute("class");
    }

    public String getAttribute(String xpath, String attibute) {
        return this.driver.findElement(By.xpath(xpath)).getAttribute(attibute);
    }

    public String getText(String xpath) {
        return this.driver.findElement(By.xpath(xpath)).getText();
    }

    public String getAtribute(String xpath, String atribute) {
        return this.driver.findElement(By.xpath(xpath)).getAttribute(atribute);
    }

    public int getSize(String xpath) {
        this.driver.findElement(By.xpath(xpath)).getSize();
        return 0;
    }

    public void getTableSize(String path, int rowNumber) {

        List<WebElement> rows = this.driver.findElements(By.xpath(path));
        System.out.println(rows.size());
        Assert.assertTrue(rowNumber == rows.size());

    }

    public void mouseOver(String path) {
        Actions action = new Actions(this.driver);
        WebElement we = this.driver.findElement(By.xpath(path));
        action.moveToElement(we).build().perform();
    }

    public void compareString(String string1, String string2) {
        Assert.assertEquals(string1, string2);
    }

    public void refreshPage() {
        this.driver.navigate().refresh();
        this.waitPleaseWaitToBeInvisible();
    }


    public WebDriver getDriver() {
        return driver;
    }

}
