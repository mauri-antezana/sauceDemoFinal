Feature: Checkout: Information page

  Background: User should to see an overview of his checkout
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button


    Scenario: Verify the tax is 8% of the total
      Given The home page should be displayed
      And I add all the products to the cart
      And I click the cart icon
      And I click on the checkout button
      And I fill the information for the checkout with
        |Mauricio|Antezana|00000|
      When I click the continue button in the information page
      Then Verify the tax is 0.08 of the total


    Scenario: Verify the total is the summation of all of the products price
      Given The home page should be displayed
      And I add all the products to the cart
      And I click the cart icon
      And I click on the checkout button
      And I fill the information for the checkout with
        |Mauricio|Antezana|00000|
      When I click the continue button in the information page
      Then Verify the total is equal to the products price summation


