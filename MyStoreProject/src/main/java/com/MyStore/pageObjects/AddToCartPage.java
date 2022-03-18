package com.MyStore.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.MyStore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement quantitywanted;
	@FindBy(name="group_1")
	WebElement selectsize;
	
	@FindBy(id="color_14")
	WebElement selectedcolour;
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocartbttn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement validateaddtocrtmsg;
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proccedtochkout;
	
	public void enterQuantitySize(String qty,String size)
	{
		quantitywanted.clear();    //this will remove the preentered value
		quantitywanted.sendKeys(qty);
		selectsize.click();
		Select sz=new Select(selectsize);
		sz.selectByVisibleText(size);
		selectedcolour.click();
	}
	public void clickOnAddToCart()
	{
		addtocartbttn.click();
	}
	
	public boolean validateAddoToCart() throws Throwable
	{// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]//h2/i")));
		
		//Thread.sleep(9000);
		return validateaddtocrtmsg.isDisplayed();
	}
	public OrderPage clickOnCheckOut()
	{
		//explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
		JavascriptExecutor executor=(JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();",proccedtochkout); //proccedtochkout is the agruments[0]
		
		return new OrderPage();
	}
}
