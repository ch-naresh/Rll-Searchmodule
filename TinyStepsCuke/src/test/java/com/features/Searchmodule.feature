
Feature: Test the Search Functionality

  Background: 
    Given I navigate to the FirstCry URL
    And I have valid credentials for login

  Scenario Outline: Login, Search 
    When I log into the application with my credentials
    Then I should be redirected to the homepage
    When I search for a specific product
    And select  "<searchproduct>" from the search results
    And User switches focus to the new tab
    Then title should contain "<searchproduct>"
    Examples:
|searchproduct |
|watches       |
|Jackets       |
