package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;

public class SearchResultsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}

	private By searchResutlsProduct = By.xpath("//*[@class='caption']/h4");

	public int getProductCount() {

		return elementUtils.getElements(searchResutlsProduct).size();

	}

	public ProductInfoPage clickProduct(String productName) {

		List<WebElement> productsText = elementUtils.getElements(searchResutlsProduct);

		for (WebElement product : productsText) {

			if (product.getText().equals(productName)) {

				product.click();
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
