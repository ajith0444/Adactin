package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClassV2;

public class BookedItinerary extends BaseClassV2{
	
	public BookedItinerary(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	
	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}
	
	
}
