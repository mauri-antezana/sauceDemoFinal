Feature: Login into Sauce Demo

  Background:User login into Sauce Demo
    Given I am in sauce demo web page

  Scenario Outline: Login into Sauce Demo with valid credentials
    Given I set the user name text box with "<user>"
    And I set the password text box with "<password>"
    When I click on the login button
    Then The home page should be displayed
    Examples:
      | user          | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |