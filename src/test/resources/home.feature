Feature: Home page
  
  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    
    Scenario Outline: Verify the name sort is working 
      When The home page should be displayed
      Then The order of the products name has to be as the selection "<Sort Type>"
      Examples:
        |Sort Type   |
        |Name (A to Z)|
        |Name (Z to A)|

    Scenario Outline: Verify the price sort is working
      When The home page should be displayed
      Then The order of the products price has to be as the selection "<Sort Type>"
      Examples:
        |Sort Type   |
        |Price (low to high)|
        |Price (high to low)|
      