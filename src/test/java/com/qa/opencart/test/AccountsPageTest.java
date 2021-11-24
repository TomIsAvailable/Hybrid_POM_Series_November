package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constant;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountsPageSetup() {

		accountsPage = loginPage.loginOpenCart(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void accountPageUrlTest() {

		Assert.assertEquals(accountsPage.getaccountPageUrl(), Constant.ACCOUNTS_PAGE_URL);
	}

	@Test(priority = 1)
	public void accountPageHeadersTest() {

		Assert.assertEquals(accountsPage.getaccountPageHeaders(),
				excelUtils.readDataFromExcel(Constant.ACCOUNT_HEADER_SHEETNAME));

	}

	@Test(priority = 2)
	public void accountsPageFootersTest() {

		softAssert.assertEquals(accountsPage.getaccountPageFooters().size(), Constant.ACCOUNT_FOOTER_SIZE);
		Assert.assertEquals(accountsPage.getaccountPageFooters(),
				excelUtils.readDataFromExcel(Constant.ACCOUNT_FOOTER_SHEETNAME));
		softAssert.assertAll();
	}

	@Test
	public void accountsPageList() {

		Assert.assertTrue(accountsPage.getaccountPageList()
				.containsAll(excelUtils.readDataFromExcel(Constant.ACCOUNT_PAGE_LIST)));

	}

	@Test(priority = 3)
	public void logOutTest() {

		Assert.assertTrue(accountsPage.logOutExist());
	}

	// Imac, Macbook Pro, Macbook Air

	@DataProvider(name = "PRODUCTS")
	public Object[][] getProductList() {

		return new Object[][] { { "IMac" }, { "Macbook Pro" }, { "Macbook Air" } };
	}

	@Test(dataProvider = "PRODUCTS", priority = 4)
	public void searchTest(String productName) {

		accountsPage.doSearchProduct(productName);
	}

	@DataProvider(name = "PRO_LIST")
	public Object[][] PRO_LIST() {

		return new Object[][] { { "Macbook", "MacBook Pro" } };

	}

	@Test(dataProvider = "PRO_LIST", priority = 5)
	public void selectProductTest(String productName, String mainProduct) {

		searchResultsPage = accountsPage.doSearchProduct(productName);
		softAssert.assertTrue(searchResultsPage.getProductCount() > 0);
		productInfoPage = searchResultsPage.clickProduct(mainProduct);
		softAssert.assertAll();

	}

	@DataProvider
	public Object[][] getBrand() {

		return new Object[][] { { "Brand", "Apple" } };
	}

	@Test(dataProvider = "getBrand", priority = 7)
	public void checkProductBrand(String brandName, String brandValue) {

		Map<String, String> produtMap = productInfoPage.getProdutMap();

		String value = produtMap.get(brandName).trim();

		Assert.assertEquals(value, brandValue);

	}

}
