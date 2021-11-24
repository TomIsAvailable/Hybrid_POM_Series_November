package com.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {

	private WebDriver driver;
	private JavascriptExecutor jse;

	public JSUtils(WebDriver driver) {

		this.driver = driver;

		jse = (JavascriptExecutor) this.driver;

	}

	public void drawBorder(WebElement ele) {

		jse.executeScript("arguments[0].style.border = '3px solid red'", ele);

	}

	public void scrollDownToElement(WebElement ele) {

		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void clickAnElementJs(WebElement ele) {

		jse.executeScript("arguments[0].click();", ele);

	}

}
