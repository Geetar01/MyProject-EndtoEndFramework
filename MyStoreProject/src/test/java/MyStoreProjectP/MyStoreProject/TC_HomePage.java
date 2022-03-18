package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.HomePage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.LoginPage;

public class TC_HomePage extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})     
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		//driver.getTitle();
	}
	@Test(groups = "Smoke")
	public void wishListTest()
	{
		ip=new IndexPage();
		lp=ip.clickOnSignInButn();
		hp=lp.login1(username, password);
		boolean result=hp.validateMyWishList();
		Assert.assertTrue(result);	
	} 
	
	@Test(groups = "Smoke")
	public void orderHistoryDetailsTest()
	{
		ip=new IndexPage();
		lp=ip.clickOnSignInButn();
		hp=lp.login1(username, password);
		boolean result=hp.validateOrderHistory();
		Assert.assertTrue(result);	
	} 

}
