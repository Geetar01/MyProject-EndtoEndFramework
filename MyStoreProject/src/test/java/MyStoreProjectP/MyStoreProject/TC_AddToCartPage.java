package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.AddToCartPage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.SearchResultPage;

public class TC_AddToCartPage extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})     
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		//getDriver().getTitle();
	}
	@Test(groups = {"Sanity","Regression"})
	public void addToCartTest() throws Throwable
	{
		ip=new IndexPage();
		ip.searchProduct("t-shirt");
		srp=ip.searchButn();
		atcp=srp.clickOnProduct();
		atcp.enterQuantitySize("2","M");
		atcp.clickOnAddToCart();
		boolean result=atcp.validateAddoToCart();
		Assert.assertTrue(result);
	}
	}

