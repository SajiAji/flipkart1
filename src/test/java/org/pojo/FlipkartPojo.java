package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPojo extends BaseClass{
	
	public FlipkartPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='Pke_EE']")
	WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//div[text()='SAMSUNG Galaxy M31s (Mirage Blue, 128 GB)']")
	WebElement product;

	public WebElement getProduct() {
		return product;
	}
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addCart;

	public WebElement getAddCart() {
		return addCart;
	}
	
	@FindBy(xpath="(//a[@title='Login'])[1]")
	WebElement log;

	public WebElement getLog() {
		return log;
	}
}