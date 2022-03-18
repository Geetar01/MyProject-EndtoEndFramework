package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.pageObjects.HomePage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.LoginPage;

public class TC_LoginPage extends BaseClass {
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})      //not needed when we use @beforeclass in base
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		getDriver().getTitle();
	}
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest()
	{
		ip=new IndexPage();
		lp=ip.clickOnSignInButn();
		hp=lp.login1(username, password);//we are fetching these values directly frm base class OR //(prop.getProperty(username),prop.getProperty(password))
		String actualUrl=hp.getCurrentUrl();
		System.out.println(actualUrl);
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl,expectedUrl);
	} 
}
