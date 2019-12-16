package com.StepDefenition;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.BaseClass.BaseClassV2;
import com.POM.BookAHotel;
import com.POM.BookedItinerary;
import com.POM.HotelBookingConfirmation;
import com.POM.Login;
import com.POM.SearchHotel;
import com.POM.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.template.utility.CaptureOutput;

public class StepDefenition extends BaseClassV2 {
	Login l = new Login(driver);
	SearchHotel sh = new SearchHotel(driver);
	SelectHotel sh1 = new SelectHotel(driver);
	BookAHotel bah = new BookAHotel(driver);
	HotelBookingConfirmation hbc = new HotelBookingConfirmation(driver);
	BookedItinerary bi = new BookedItinerary(driver);
	
	public String capturedOrderNumber;
	
	@Given("^User launches the URL$")
		public static void user_launches_the_URL() throws Throwable {
		   
		    
		}
	
	@When("^User enters the username \"([^\"]*)\"$")
	public void user_enters_the_username(String arg1) throws Throwable {
		sendKeys(l.getUsername(), arg1);
	}

	@When("^User enters the password \"([^\"]*)\"$")
	public void user_enters_the_password(String arg1) throws Throwable {
		sendKeys(l.getPassword(), arg1);
	}

	@When("^User clicks on login$")
	public void user_clicks_on_login() throws Throwable {
	 click(l.getLoginBtn());
	}

	@Then("^Verify the User have loggedin$")
	public void verify_the_User_have_loggedin() throws Throwable {
		String text = sh.getDisplayUsername().getAttribute("value").substring(6, 17);
		System.out.println(text);
		Assert.assertEquals("ajith201094", text);
		System.out.println("User logged into the correct account");
	}
	
	@Then("^User verifies that they are in the correct page$")
	public void user_verifies_that_they_are_in_the_correct_page() throws Throwable {
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "AdactIn.com - Search Hotel");
	    System.out.println("User verified the title named \"" +title+ "\" successfully");
	    
	}

	@When("^User clicks on Search hotel option$")
	public void user_clicks_on_Search_hotel_option() throws Throwable {
	    click(sh.getClickSearchHotel());
	    System.out.println("User clicks Search Hotel link");
	}

	@Then("^User verifies that they can view Search Hotel form$")
	public void user_verifies_that_they_can_view_Search_Hotel_form() throws Throwable {
		WebElement form = driver.findElement(By.xpath("//td[@class='login_title']"));
		////td[text()='Search Hotel ']
	    System.out.println("User can view "+form.getText() +" form");
	}

	@When("^User clicks on Booked Itinerary$")
	public void user_clicks_on_Booked_Itinerary() throws Throwable {
	    click(bi.getBookedItinerary());
	    System.out.println("User clicks on Booked Itinerary link");
	}

	@Then("^User verifies that they can view Booked Itinerary form$")
	public void user_verifies_that_they_can_view_Booked_Itinerary_form() throws Throwable {
	    WebElement title = driver.findElement(By.xpath("//td[@class='login_title']"));
	    System.out.println("User can view "+title.getText()+" form");
	}
	
	@When("^User selects \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_selects_location_hotel_Standard(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
	   Select selectLocation = new Select(sh.getLocation());
	   selectLocation.selectByValue(arg1);
	   System.out.println("User selects "+arg1);
	   Select selectHotlel = new Select(sh.getHotels());
	   selectHotlel.selectByValue(arg2);
	   System.out.println("User selects "+arg2);
	   Select selectRoomType = new Select(sh.getRoomType());
	   selectRoomType.selectByValue(arg3);
	   System.out.println("User selects "+arg3);
	   Select selectRoomNo = new Select(sh.getRoomNos());
	   selectRoomNo.selectByValue(arg4);
	   System.out.println("User selects "+arg4);
	   
	   sendKeys(sh.getCheckIn(), arg5);
	   System.out.println("User selects "+arg5);
	   sendKeys(sh.getCheckout(), arg6);
	   System.out.println("User selects "+arg6);
	   
	   Select selectAdultRoom = new Select(sh.getAdultRoom());
	   selectAdultRoom.selectByValue(arg7);
	   System.out.println("User selects "+arg7);
	   //Select selectChildRoom = new Select(sh.getChildRoom());
	   //selectChildRoom.selectByValue(arg8);
	   System.out.println("User selects "+arg8);
	   
	}

	@Then("^User clicks the Search button$")
	public void user_clicks_the_Search_button() throws Throwable {
	   click(sh.getSubmit());
	   System.out.println("User clicks on Search button");
	}

	@Then("^User books the hotel and captures the order number$")
	public void user_books_the_hotel_and_captures_the_order_number() throws Throwable {
	   click(sh1.getSelectData());
	   System.out.println("User selects the hotel");
	   click(sh1.getContinueBtn());
	   
	   sendKeys(bah.getInputFirstName(), "Ajith");
	   sendKeys(bah.getInputLastName(), "Kumar");
	   sendKeys(bah.getInputAddress(), "123 Bablizon Saint");
	   sendKeys(bah.getCreditCardNumber(), "9876543210123456");
	   
	   Select selectCreditCardType = new Select(bah.getCreditCardType());
	   selectCreditCardType.selectByValue("VISA");
	   Select selectCreditCardMonth = new Select(bah.getCreditCardMonth());
	   selectCreditCardMonth.selectByValue("12");
	   Select selectCreditCardYear = new Select(bah.getCreditCardYear());
	   selectCreditCardYear.selectByValue("2022");
	   
	   sendKeys(bah.getCreditCardCVV(), "121");
	   
	   click(bah.getBookNowBtn());
	}

	@When("^User clicks on Booked Itinerary, searches for order number$")
	public void user_clicks_on_Booked_Itinerary_searches_for_order_number() throws Throwable {
	   capturedOrderNumber = hbc.getOrderNo().getAttribute("value");
	   System.out.println("Order number Captured : "+capturedOrderNumber);
	   click(hbc.getMyItineraryBtn());
	   System.out.println("User clicks on My Itinerary button");
	}

	@Then("^User clicks on Cancel order number$")
	public void user_clicks_on_Cancel_order_number() throws Throwable {
		
	   WebElement cancelOrder = driver.findElement(By.xpath("//input[@value='Cancel "+capturedOrderNumber+"']"));
	   click(cancelOrder);
	   System.out.println("User cancels order number "+capturedOrderNumber);
	}

	@Then("^User Clicks on Yes on popup$")
	public void user_Clicks_on_Yes_on_popup() throws Throwable {
		
	   Alert ac = driver.switchTo().alert();
	   System.out.println(ac.getText());
	   ac.dismiss(); //***Changes made here to fail the test case***
	}

	@Then("^User verifies that the order is no longer appears in Booked itinerary$")
	public void user_verifies_that_the_order_is_no_longer_appears_in_Booked_itinerary() throws Throwable {
	   List<WebElement> Order = driver.findElements(By.xpath("//input[@class=\"select_text\"]"));
	   for(WebElement x : Order) {
		   String checkOrder = x.getAttribute("value");
		   SoftAssert sa = new SoftAssert();
		   sa.assertNotEquals(checkOrder, capturedOrderNumber);
		   Assert.assertNotEquals(checkOrder, capturedOrderNumber);
		   //System.out.println(checkOrder);
	   }
	   System.out.println("The order number "+capturedOrderNumber+" is not in the Booked Itinerary list");
	}
	
	
}
