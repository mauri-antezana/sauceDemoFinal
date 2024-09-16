Feature: Checkout: Information page

  Background: User should be to fill his information with correct data
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario: Information fields are empty
      Given The home page should be displayed
      And I click the cart icon
      And I click on the checkout button
      And I click the continue button in the information page
      Then An error message for incomplete fields should appear