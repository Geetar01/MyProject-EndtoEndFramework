package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class PaymentPage extends BaseClass{
	public PaymentPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement bankwiredmethod;
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement paybycheck;
	
	public OrderSummaryPage clickOnPaymentMethod()
	{
		bankwiredmethod.click();
		return new OrderSummaryPage();
	}
	
}
