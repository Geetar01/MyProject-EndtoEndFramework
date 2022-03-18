package com.MyStore.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyStore.base.BaseClass;

public class OrderPage extends BaseClass {
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitprice;
	@FindBy(xpath="//*[@id=\"total_price\"]")
	WebElement totprice;
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement chkoutbuttn;
	
	public double getUnitPrice()
	{	
		String uprice=unitprice.getText();
		String unit=uprice.replaceAll("[^a-zA-Z0-9]",""); //this will replace all the special charactr with null from the string
		double finalunitprice=Double.parseDouble(unit); //converting string into double
		return finalunitprice/100;  //we use /100 as replaceall will remove $ and . as well so we get2898 n we want 28.98
	}
	public double getTotalPrice()
	{
		String tprice=totprice.getText();
		String total=tprice.replaceAll("[^a-zA-Z0-9]",""); //this will replace all the special charactr with null from the string
		double finaltotalprice=Double.parseDouble(total); //converting string into double
		return finaltotalprice/100;  //we use /100 as replaceall will remove $ and . as well so we get2898 n we want 28.98
	}
	
	public LoginPage clickOnCheckOut()
	{
		chkoutbuttn.click();
		return new LoginPage(); 
	}

}
