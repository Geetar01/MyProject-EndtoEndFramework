package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.AddToCartPage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.OrderPage;
import com.MyStore.pageObjects.SearchResultPage;

public class TC_OrderPage extends BaseClass{
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})     
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		getDriver().getTitle();
	}
	@Test(groups = "Regression")
	public void addToCartTest() throws Throwable
	{
		ip=new IndexPage();
		ip.searchProduct("t-shirt");
		srp=ip.searchButn();
		atcp=srp.clickOnProduct();
		atcp.enterQuantitySize("2","M");
		atcp.clickOnAddToCart();
		op=atcp.clickOnCheckOut();
		Double unitprice=op.getUnitPrice();
		Double totalprice=op.getTotalPrice();
		Double totexpectedprice=(unitprice*2)+2; // 2 qntity, 2is the shipping price
		//Double totexpectedprice=(unitprice*Double.parseDouble(qty)))+2;// here qty value we hv provided frn excel usng dataProvider
		Assert.assertEquals(totalprice, totexpectedprice);
	}
}
