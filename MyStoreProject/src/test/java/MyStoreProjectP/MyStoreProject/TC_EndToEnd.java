package MyStoreProjectP.MyStoreProject;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.MyStore.base.BaseClass;
import com.MyStore.dataProvider.DataProviders;
import com.MyStore.pageObjects.AddToCartPage;
import com.MyStore.pageObjects.AddressPage;
import com.MyStore.pageObjects.IndexPage;
import com.MyStore.pageObjects.LoginPage;
import com.MyStore.pageObjects.OrderConfirmationPage;
import com.MyStore.pageObjects.OrderPage;
import com.MyStore.pageObjects.OrderSummaryPage;
import com.MyStore.pageObjects.PaymentPage;
import com.MyStore.pageObjects.SearchResultPage;
import com.MyStore.pageObjects.ShippingPage;
import com.MyStore.utility.Log;

public class TC_EndToEnd extends BaseClass {
	IndexPage ip;
	SearchResultPage srp;
	AddToCartPage atcp;
	OrderPage op;
	LoginPage lp;
	AddressPage ap;
	ShippingPage sp;
	PaymentPage pp;
	OrderSummaryPage osp;
	OrderConfirmationPage ocp;
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})     
	public void driverInitialiser() throws IOException 
	{
		initializeDriver();
		getDriver().getTitle();
	}
	
	@Test(groups = "Regression")
	//@Test(dataProvider= "credentials", dataProviderClass= DataProviders.class) //name of dataprovider(frm newexcellibrary)and classname(frmDataProvider.java) we linked here
	public void addToCartTest() throws Throwable
	{
		ip=new IndexPage();
		ap=new AddressPage();
		pp=new PaymentPage();
		Log.startTestCase("End to End Test");
		ip.searchProduct("t-shirt");
		Log.info("user is searching for a product");
		srp=ip.searchButn();
		atcp=srp.clickOnProduct();
		Log.info("Enter qntity n size of the item");
		atcp.enterQuantitySize("2","M");
		atcp.clickOnAddToCart();
		op=atcp.clickOnCheckOut();
		lp=op.clickOnCheckOut();// ths will return login page when you are already logged in chk the navigation
		Log.info("Enter username n password");
		lp.login2(username,password); //here we arefetching the data from config.properties file
		//lp.login2(uname, pswd); //here we are fetching the data from excel using dataprovider file : uname, pswd pass frm  addToTestcard(string uname,strng pswd )
		sp=ap.clickOnCheckOut();
		sp.checkTheTerms();
		sp.checkOnProceedToCheckOut();
		osp=pp.clickOnPaymentMethod();
		System.out.println("------");
		ocp=osp.clickOnConfirmOrderbttn();
		String actualmsg=ocp.validateConfirmMessage();
		String expectedmsg="Your order on My Store is complete.";
		Log.info("Verifying if user is able to successfully done the transaction");
		Assert.assertEquals( actualmsg, expectedmsg);
		Log.info("ent to end test is successful");
		Log.endTestCase("End to End Test");
		
		
		
	}

}
