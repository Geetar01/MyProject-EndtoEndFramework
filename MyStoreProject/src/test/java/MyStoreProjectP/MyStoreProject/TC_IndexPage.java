package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.IndexPage;

public class TC_IndexPage extends BaseClass {
	IndexPage ip;
	//@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})      //not needed when we use @beforeclass in base
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		//driver.getTitle();
	}
	@Test(groups = "Smoke")
	public void verifyLogo()
	{
		ip=new IndexPage();
		boolean result=ip.validateLogo();
		Assert.assertTrue(result);	
	} 
	@Test(groups = "Smoke")
	public void VerifyTitle()
	{
		ip=new IndexPage();
		String actualtitle=ip.getMyStoreTitle();
		Assert.assertEquals(actualtitle,"My Store");	
	} 


}
