package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}
	//new account creation
	@FindBy(id="email")
	WebElement userid;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(id="SubmitLogin")
	WebElement signintbttn;
	
	@FindBy(id="email_create")
	WebElement emailfornewaccnt;
	@FindBy(name="SubmitCreate")
	WebElement createnewaccntbttn;
	
	
	public HomePage login1(String user,String pwd)
	{
		userid.sendKeys(user);
		password.sendKeys(pwd);
		signintbttn.click();
		return new HomePage();
	}
	

	public AddressPage login2(String user,String pwd)
	{
		userid.sendKeys(user);
		password.sendKeys(pwd);
		signintbttn.click();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String emailforaccnt)
	{
		emailfornewaccnt.sendKeys(emailforaccnt);
		createnewaccntbttn.click();
		return new AccountCreationPage(); //aftr this buttn it will take us to homepage 
	}
	
	
	
}

