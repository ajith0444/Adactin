package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClassV2;

public class HotelBookingConfirmation extends BaseClassV2{
	
	public HotelBookingConfirmation(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="order_no")
	private WebElement orderNo;
	
	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getSearchHotelbtn() {
		return searchHotelbtn;
	}

	public WebElement getMyItineraryBtn() {
		return myItineraryBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	@FindBy(id="search_hotel")
	private WebElement searchHotelbtn;
	
	@FindBy(id="my_itinerary")
	private WebElement myItineraryBtn;
	
	@FindBy(id="logout")
	private WebElement logoutBtn;
}
