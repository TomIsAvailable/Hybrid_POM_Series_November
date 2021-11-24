package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

/*
 * 1. By locators
 * 2. Constructor
 * 3. Page Actions
*/
public class AccountsPage {

	private By accountPageHeaders = By.xpath("//div[@id='content']/h2");
	private By accountPageList = By.xpath("//div[@class='list-group']/a");
	private By accountFooterLinks = By.xpath("//*[text()='Information']/../../div/h5");
	private By MyAccountLink = By.xpath("//*[@class='dropdown']");
	private By logOutLink = By.xpath("//*[@class='dropdown open']/ul/li[last()]");
	private By searchText = By.name("search");
	private By searchButton = By.xpath("//*[@type='button']/i");

	private WebDriver driver;
	private ElementUtils elementUtils;

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}

	public List<String> getaccountPageHeaders() {
		return elementUtils.getAllElementText(accountPageHeaders);
	}

	public List<String> getaccountPageList() {
		return elementUtils.getAllElementText(accountPageList);
	}

	public List<String> getaccountPageFooters() {
		return elementUtils.getAllElementText(accountFooterLinks);
	}

	public String getaccountPageUrl() {
		return elementUtils.getPageUrl();
	}

	public boolean logOutExist() {
		elementUtils.clickAnElement(MyAccountLink);
		return elementUtils.isElementDisplayed(logOutLink);
	}

	public void clickLogOut() {
		if (logOutExist())
			elementUtils.clickAnElement(logOutLink);
	}

	public SearchResultsPage doSearchProduct(String productName) {
		elementUtils.pressEscape();
		elementUtils.doSendKeys(searchText, productName);
		elementUtils.clickAnElement(searchButton);
		return new SearchResultsPage(driver);
	}

}
