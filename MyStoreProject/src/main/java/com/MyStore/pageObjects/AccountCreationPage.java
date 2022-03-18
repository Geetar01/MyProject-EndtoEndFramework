package com.MyStore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.MyStore.base.BaseClass;

public class AccountCreationPage extends BaseClass
{
	
	public AccountCreationPage() //this constructor is used to initialize the driver
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(css=".page-heading")
	WebElement validatepage;
	@FindBy(id="uniform-id_gender2")
	WebElement title;
	@FindBy(name="customer_firstname")
	WebElement firstname;
	@FindBy(id="customer_lastname")
	WebElement lastname;
	@FindBy(id="email")
	WebElement emailid;
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement date;
	//
	@FindBy(id="months")
	WebElement month;
	//
	@FindBy(id="years")
	WebElement year;
	//
	@FindBy(id="uniform-newsletter")
	WebElement newsletter;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement addfirstname;
	@FindBy(xpath="//input[@id='lastname']")
	WebElement addlastname;
	@FindBy(xpath="//input[@id='company']")
	WebElement company;
	@FindBy(xpath="//input[@id='address1']")
	WebElement address1;
	@FindBy(xpath="//input[@id='address2']")
	WebElement address2;
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	@FindBy(css="#id_state")
	WebElement state;
	//
	
	@FindBy(css="#postcode")
	WebElement postcode;
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	//
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobileno;
	@FindBy(xpath="//input[@id='alias']")
	WebElement addressalias;
	
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span")
	WebElement submitaccnt;
	
	
	public boolean validateCreateAccntPage()
	{
		return validatepage.isDisplayed();	
	}
	public void enterPersonalInfo(String firstname1,String lastname1,String email,String pswd)
	{
		title.click();
		firstname.sendKeys(firstname1);
		lastname.sendKeys(lastname1);
		emailid.sendKeys(email);
		password.sendKeys(pswd);
		date.click(); //arrowdown n select 6
		Select dt=new Select(date);
		//dt.selectByVisibleText("6");
		dt.selectByValue("6");
		month.click();
		Select mnth=new Select(month);
		mnth.selectByIndex(11);
		year.click();
		Select yr=new Select(year);
		yr.selectByValue("1986");
		newsletter.click();
	}
	public void enterAddress(String addfirstname1,String addlastname1,String company1,String address11,String address22,String city1,String postcode1,String mobile1,String addressalias1)
	{
		addfirstname.sendKeys(addfirstname1);
		addlastname.sendKeys(addlastname1);
		company.sendKeys(company1);
		address1.sendKeys(address11);
		address2.sendKeys(address22);
		city.sendKeys(city1);
		state.click(); ///select
		Select st=new Select(state);
		st.selectByIndex(6);
		postcode.sendKeys(postcode1);
		country.click();//select
		Select cntry=new Select(country);
		cntry.selectByIndex(1); //United States
		mobileno.sendKeys(mobile1);
		addressalias.sendKeys(addressalias1);
		submitaccnt.click();
		
	}
	
}

