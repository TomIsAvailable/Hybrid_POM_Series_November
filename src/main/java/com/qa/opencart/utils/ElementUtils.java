package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String data) {
		getElement(locator).sendKeys(data);
	}

	public void clickAnElement(By locator) {
		getElement(locator).click();
	}

	public String getElementText(By locator) {
		return getElement(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public List<String> getAllElementText(By locator) {
		List<String> allLabels = new ArrayList<>();
		List<WebElement> elements = getElements(locator);
		for (WebElement element : elements) {
			allLabels.add(element.getText());
		}
		return allLabels;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {

		return driver.getCurrentUrl();
	}

}
