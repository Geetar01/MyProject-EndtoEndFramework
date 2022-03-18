package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class HomePage extends BaseClass{

	public HomePage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'My wishlists')]")
	WebElement mywishlist;
	@FindBy(xpath="//span[contains(text(),'Order history and details')]")
	WebElement orderHistory;
	
	public boolean validateMyWishList()
	{
		return mywishlist.isDisplayed();
	}
	public boolean validateOrderHistory()
	{
		return orderHistory.isDisplayed();
	}
public String getCurrentUrl()
{
String homePageUrl=getDriver().getCurrentUrl();
return homePageUrl;
}

}

