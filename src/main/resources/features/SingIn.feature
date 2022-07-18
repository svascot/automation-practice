Feature: Shopping Automation
  Scenario: Testing the authentication
    Given I go to the Website
    When I click on Sign In button
    And I specify my credentials and click Login
    Then I can log into the website