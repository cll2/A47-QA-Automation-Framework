Feature: Login feature

  Scenario: Successful login
    Given I open Login page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged into the website