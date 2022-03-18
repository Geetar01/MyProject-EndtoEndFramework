package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class ShippingPage extends BaseClass{
	public ShippingPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name="cgv")
	WebElement clickterms;
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedtochkout;

	public void checkTheTerms()
	{
		clickterms.click();
	}
	public PaymentPage checkOnProceedToCheckOut()
	{
		proceedtochkout.click();
		return new PaymentPage();
	}
}
