package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtils;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By productMap = By.xpath("//*[@class='btn-group']/../ul[1]/li");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}

	public Map<String, String> getProdutMap() {

		List<String> maps = elementUtils.getAllElementText(productMap);
		
		System.out.println(maps);

		Map<String, String> prodMap = new HashMap<>();

		for (String map : maps) {

			String[] split = map.trim().split(":");

			prodMap.put(split[0], split[1]);

		}

		return prodMap;

	}

}
