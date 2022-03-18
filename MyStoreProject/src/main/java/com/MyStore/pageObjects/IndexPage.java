package com.MyStore.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

	public class IndexPage extends BaseClass{
		
		Actions a=new Actions(getDriver()); //is used to utilize the keyboard n mouse action
		
		public IndexPage() //this constructor is used to initialize the driver
		{
			PageFactory.initElements(getDriver(), this);
		}
		
	@FindBy(css="a.login")
	WebElement signinbtn;

	@FindBy(xpath="//img[contains(@class,'logo img-responsive')]")
	WebElement mystorelogo;

	@FindBy(id= "search_query_top")
	WebElement searchProductbox;
		
	@FindBy(name="submit_search")
	WebElement searchbtn;
	
	public LoginPage clickOnSignInButn()
	{
		signinbtn.click();
		return new LoginPage();     //whn we clck on login buttn it will land on login page so aftr clicking this func 'll land on loginpage so newis used to create he object of loginpage
	}
	
	public boolean validateLogo()
	{
		return (mystorelogo.isDisplayed());   //this fun chks the logo n returns boolean
	}
	
	public String getMyStoreTitle() {
		
		return getDriver().getTitle();  //or we can simply return the title into an string object and then return that string object
	}
	
	public void searchProduct(String Productname)
	{
		//a.moveToElement(searchProductbox).keyDown(Keys.SHIFT).sendKeys(Productname).build().perform();
		//a.moveToElement(searchProductbox).click().keyDown(Keys.SHIFT).sendKeys(Productname).doubleClick().build().perform();
		searchProductbox.sendKeys(Productname);
		//productname= "huda beauty lipstick" from the test we can pass
	}
	public SearchResultPage searchButn()
	{
		
		searchbtn.click();
		return new SearchResultPage(); //after clicling on search button it will land on searchresultpage
	}

	}
