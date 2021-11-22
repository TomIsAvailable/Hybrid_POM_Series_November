package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.utils.ExcelUtils;

public class BaseTest {

	public DriverFactory driverFactory;
	public WebDriver driver;
	public LoginPage loginPage;
	public Properties prop;
	public ExcelUtils excelUtils;
	public AccountsPage accountsPage;
	public SearchResultsPage searchResultsPage;
	public SoftAssert softAssert;
	public ProductInfoPage productInfoPage;

	@BeforeTest
	public void setUp() {
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();
		driver = driverFactory.init_driver(prop);
		loginPage = new LoginPage(driver);
		excelUtils = new ExcelUtils();
		softAssert = new SoftAssert();
		searchResultsPage = new SearchResultsPage(driver);
		productInfoPage = new ProductInfoPage(driver);

	}

	@AfterTest
	public void tearDown() {

//		driver.quit();

	}

}
