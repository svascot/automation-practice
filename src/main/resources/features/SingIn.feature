Feature: Shopping Automation
  Scenario: Testing the authentication
    Given I go to the Website
    When I click on Sign In button
    And I specify my credentials and click Login
    Then I can log into the website

  Scenario: Testing the purchase of two items
    Given I go to the Website
    When I add two elements to the cart
    And I proceed to checkout
    And I confirm address, shipping, payments and final order
    Then the elements are bought