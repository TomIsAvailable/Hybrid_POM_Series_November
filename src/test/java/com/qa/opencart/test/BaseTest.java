package com.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.ExcelUtils;

public class BaseTest {

	public DriverFactory driverFactory;
	public WebDriver driver;
	public LoginPage loginPage;
	public Properties prop;
	public ExcelUtils excelUtils;
	public AccountsPage accountsPage;

	@BeforeTest
	public void setUp() {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();

		prop = driverFactory.init_prop();
		loginPage = new LoginPage(driver);

		excelUtils = new ExcelUtils();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
