package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	public OrderSummaryPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmorderbttn;
	
	public OrderConfirmationPage clickOnConfirmOrderbttn()
	{
		confirmorderbttn.click();
		return new OrderConfirmationPage();
	}

}
