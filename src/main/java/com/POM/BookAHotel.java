package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClassV2;

public class BookAHotel extends BaseClassV2{

	public BookAHotel(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getInputFirstName() {
		return inputFirstName;
	}

	public WebElement getInputLastName() {
		return inputLastName;
	}

	public WebElement getInputAddress() {
		return inputAddress;
	}

	public WebElement getCreditCardNumber() {
		return creditCardNumber;
	}

	public WebElement getCreditCardType() {
		return creditCardType;
	}

	public WebElement getCreditCardMonth() {
		return creditCardMonth;
	}

	public WebElement getCreditCardYear() {
		return creditCardYear;
	}

	public WebElement getCreditCardCVV() {
		return creditCardCVV;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}


	@FindBy(id="first_name")
	private WebElement inputFirstName;
	
	@FindBy(id="last_name")
	private WebElement inputLastName;
	
	@FindBy(id="address")
	private WebElement inputAddress;
	
	@FindBy(id="cc_num")
	private WebElement creditCardNumber;
	
	@FindBy(id="cc_type")
	private WebElement creditCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement creditCardMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement creditCardYear;
	
	@FindBy(id="cc_cvv")
	private WebElement creditCardCVV;
	
	@FindBy(id="book_now")
	private WebElement bookNowBtn;
	
	@FindBy(id="cancel")
	private WebElement cancelBtn;
	
	
	
}
