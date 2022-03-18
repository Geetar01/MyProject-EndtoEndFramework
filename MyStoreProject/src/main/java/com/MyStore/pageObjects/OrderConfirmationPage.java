package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	public OrderConfirmationPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmmessgae;
	
	public String validateConfirmMessage()
	{
		String confirmmsg= confirmmessgae.getText();
		return confirmmsg;
	}
}
