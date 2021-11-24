package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions co = new ChromeOptions();

		co.addArguments("--incognito");

		/*
		 * WebDriver driver = new FirefoxDriver(fo);
		 * 
		 * ChromeOptions co = new ChromeOptions();
		 * 
		 * co.addArguments("--headless");
		 */
		WebDriver driver = new ChromeDriver(co);

		driver.get("https://www.google.com");

		driver.manage().window().maximize();

		Assert.assertEquals(driver.getTitle(), "Google");

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");

		System.out.println("Successfully asserted url and Title");

	}

}
