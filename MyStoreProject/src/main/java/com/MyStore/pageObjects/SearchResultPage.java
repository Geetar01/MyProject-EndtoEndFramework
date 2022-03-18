package com.MyStore.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img[1]")
	WebElement productresult;
	
	
	//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img //for t-shirt
	//*[@id=\"center_column\"]//img   //for t-shirt
	//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img    //for printed summer dress
	//*[@id="center_column"]/ul/li[1]//img   //for printed summer dress
	
	public boolean isProductAvailable()
	{
		return productresult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct()
	{
		productresult.click();
		return new AddToCartPage();
	}
}
	
	/*
	public void isProductAvailable()
	{
		//List<WebElement> clicklinkproduct=driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]"));
		//int tot=clicklinkproduct.size();
		//for(int i=0;i<tot;i++)
		//{}	
		if(driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]")).size()==0)
			{
				if(driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]")).size()>0)
				{
					int n=driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]")).size();
					System.out.println("elements present" +n);
					driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]")).get(5).click();	
				}
				else
				{
					System.out.println("none of the element present");
				}
			}
			else
			{ //compiler always executes this block 
				driver.findElements(By.xpath("//*[@id='center_column']//a[1]/img[1]")).get(4).click();
			}
		
	}*/

