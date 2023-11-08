@login @regression
Feature: WebDriver University - Login Page


  Background:
    Given I access the webdriveruniversity login page

  @login-positive
  Scenario: Validate Successful Login
    When   I enter a username webdriver
    And I enter a password webdriver123
    And I click login button
    Then I should be presented with validation success message

  @login-negative
  Scenario: Validate Unsuccessful Login - Valid Username and Invalid Password
    When I enter a username webdriver
    And I enter a password webdriver
    And I click login button
    Then I should be presented with validation failed message

@smoke
  Scenario Outline:
    When I enter a username <username>
    And I enter a password <password>
    And I click login button
    Then I should be presented with the following message <message>

    Examples:
      | username  | password     | message              |
      | webdriver | webdriver123 | validation succeeded |
      | webdriver | webdriver1 | validation failed |
      | kerem | webdriver | validation failed |