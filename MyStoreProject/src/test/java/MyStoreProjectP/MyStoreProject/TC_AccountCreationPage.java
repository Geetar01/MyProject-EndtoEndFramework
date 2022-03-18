package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.AccountCreationPage;
import com.MyStore.pageObjects.HomePage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.LoginPage;

public class TC_AccountCreationPage extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage acp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})    
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		//getDriver().getTitle();
	}
	@Test(groups = "Sanity")
	public void validateCreateAccountPageTest()
	{
		ip=new IndexPage();
		lp=ip.clickOnSignInButn();
		acp=lp.createNewAccount(randomString()+"@gmail.com");
		boolean result=acp.validateCreateAccntPage();
		Assert.assertTrue(result);	
		//form Filling
		acp.enterPersonalInfo("Geeta", "Devi", "adbv@gmail.com", "12345");
		acp.enterAddress("Geeta", "Devi","fggh","sant nagar", "Airforce Gate", "Bareilly", "34465", "345678990", "ba");
		System.out.println("Successfully Registered");
	} 

}
