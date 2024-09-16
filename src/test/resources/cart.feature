Feature: Cart page feature

  Background: User should be able to see his cart
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    Scenario Outline: User should see all the products he added to the cart
      Given The home page should be displayed
      And I add the product "<products>" to the cart
      And I click the cart icon
      Then I should see the product "<products>" in the cart
      And I remove the product "<products>" from cart
      Examples:
      |products                 |
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |


