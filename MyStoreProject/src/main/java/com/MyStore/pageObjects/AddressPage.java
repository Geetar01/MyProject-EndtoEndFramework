package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class AddressPage extends BaseClass {
	public AddressPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedtochkout;
	
	public ShippingPage clickOnCheckOut()
	{
		//System.out.println("entered func");
		proceedtochkout.click();
		return new ShippingPage();
	}
	
}
