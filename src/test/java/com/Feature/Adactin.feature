Feature: To test the functionality of Adactin website

	Background:
	 Given User launches the URL
    When User enters the username "ajith201094"
    And User enters the password "ajith201094"
    And User clicks on login


  @TC-101
  Scenario: To verify valid login details
    #Given User launches the URL
    #When User enters the username "ajith201094"
    #And User enters the password "ajith201094"
    #And User clicks on login
    Then Verify the User have loggedin

  @TC-120
  Scenario: To Verify Title of every Page reflects what the page objective is.
    For example: Title of Search Hotel page should have “Search Hotel”
    

    #Given User launches the URL
    #When User enters the username "ajith201094"
    #And User enters the password "ajith201094"
    #And User clicks on login
    #Then Verify the User have loggedin
    Then User verifies that they are in the correct page
    When User clicks on Search hotel option
    Then User verifies that they can view Search Hotel form
    When User clicks on Booked Itinerary
    Then User verifies that they can view Booked Itinerary form

  @TC-119
  Scenario Outline: To verify that the order gets cancelled after click on Cancel order number link
    #Given User launches the URL
    #When User enters the username "ajith201094"
    #And User enters the password "ajith201094"
    #And User clicks on login
    #Then Verify the User have loggedin
    When User selects "<location>","<hotel>","<roomType>","<no of rooms>","<Checkin date>","<Checkout date>","<No of adults>","<No of children>"
    Then User clicks the Search button
    Then User books the hotel and captures the order number
    When User clicks on Booked Itinerary, searches for order number
    Then User clicks on Cancel order number
    Then User Clicks on Yes on popup
    And User verifies that the order is no longer appears in Booked itinerary
    
    Examples:
    |location	|hotel			|roomType	|no of rooms	|Checkin date	|Checkout date	|No of adults	|No of children	|
		|Sydney		|Hotel Creek|Standard|2						|10/12/2019		|11/12/2019			|1						|0							|