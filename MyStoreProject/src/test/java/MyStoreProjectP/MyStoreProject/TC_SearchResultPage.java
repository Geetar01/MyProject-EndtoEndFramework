package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.SearchResultPage;

public class TC_SearchResultPage extends BaseClass {
	
	IndexPage ip;
	SearchResultPage srp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})     
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		getDriver().getTitle();
	}
	@Test(groups = "Smoke")
	public void productAvailabilityTest()
	{
		ip=new IndexPage();
		ip.searchProduct("t-shirt");
		srp=ip.searchButn();
		boolean result=srp.isProductAvailable();
		Assert.assertTrue(result);
		System.out.println(result+ "Is present");
	}

}
