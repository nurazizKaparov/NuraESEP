Feature: Login functionality

  Background: Land to home page
    Given Go to login page

  Scenario: Checking login functionality
    Given Enter userName on the field
    And Enter password on the field
    When user click on login button
    Then user should successfully logged in
    And select account to login
    When user should see main page